package kamenov.naturalnaturefinalapp.service.impl;

import kamenov.naturalnaturefinalapp.entity.AiRecipe;
import kamenov.naturalnaturefinalapp.repositories.AiRecipeRepository;
import kamenov.naturalnaturefinalapp.service.AiRecipeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import reactor.util.retry.Retry;

import java.time.Duration;

@Service
public class AiRecipeServiceImpl implements AiRecipeService {

    private static final Logger logger = LoggerFactory.getLogger(AiRecipeServiceImpl.class);

    private final AiRecipeRepository recipeRepository;
    private final WebClient webClient;
    private final ObjectMapper objectMapper;

    @Autowired
    public AiRecipeServiceImpl(AiRecipeRepository recipeRepository,
                               @Value("${OPENAI_API_KEY}") String apiKey) {
        this.recipeRepository = recipeRepository;
        this.objectMapper = new ObjectMapper();
        this.webClient = WebClient.builder()
                .baseUrl("https://api-inference.huggingface.co")
                .defaultHeader("Authorization", "Bearer " + apiKey)
                .defaultHeader("Content-Type", "application/json")
                .build();

        if (apiKey == null || apiKey.trim().isEmpty()) {
            logger.error("Hugging Face API key is not set or is empty. Please check the 'OPENAI_API_KEY' property.");
        } else {
            logger.info("AiRecipeService initialized with Hugging Face API key.");
        }
    }

    @Override
    @Cacheable(value = "recipes", key = "#ingredients")
    public Mono<String> getRecipeSuggestion(String ingredients) {
        if (ingredients == null || ingredients.trim().isEmpty()) {
            logger.warn("Ingredients input is empty or null.");
            return Mono.just("Моля, въведете продукти за рецептата.");
        }

        String prompt = "Ти си екологичен готвач. Дай ми еко рецепта с тези продукти: " + ingredients + ". Използвай кратък формат на рецепта и напиши я на български.";
        logger.info("Generating recipe for ingredients: {}", ingredients);

        String requestBody = """
                {
                  "inputs": "%s",
                  "parameters": {
                    "max_length": 200,
                    "temperature": 0.7
                  }
                }
                """.formatted(prompt);

        return webClient.post()
                .uri("/models/distilgpt2") // Сменен модел на distilgpt2
                .bodyValue(requestBody)
                .retrieve()
                .onStatus(status -> status.isError(), clientResponse -> {
                    HttpStatus statusCode = HttpStatus.valueOf(clientResponse.statusCode().value());
                    return clientResponse.bodyToMono(String.class)
                            .flatMap(errorBody -> {
                                logger.error("Hugging Face API error - Status: {}, Body: {}", statusCode, errorBody);
                                // Проверяваме дали тялото започва с HTML (<!DOCTYPE или <html)
                                if (errorBody.trim().startsWith("<!DOCTYPE") || errorBody.trim().startsWith("<html")) {
                                    if (statusCode == HttpStatus.SERVICE_UNAVAILABLE) {
                                        return Mono.error(new RuntimeException("Hugging Face API е временно недостъпен (503 Service Unavailable). Моля, опитайте отново по-късно."));
                                    }
                                    return Mono.error(new RuntimeException("Неочаквана HTML грешка от Hugging Face API: " + statusCode));
                                }
                                // Ако не е HTML, опитваме да парснем като JSON
                                try {
                                    JsonNode errorNode = objectMapper.readTree(errorBody);
                                    String errorMessage = errorNode.path("error").asText();

                                    if (statusCode == HttpStatus.TOO_MANY_REQUESTS) {
                                        return Mono.error(new RuntimeException("Прекалено много заявки към Hugging Face. Моля, изчакайте малко и опитай отново."));
                                    }
                                    return Mono.error(new RuntimeException("Грешка от Hugging Face API: " + errorMessage));
                                } catch (Exception e) {
                                    logger.error("Error parsing Hugging Face error response: {}", e.getMessage(), e);
                                    return Mono.error(new RuntimeException("Грешка при обработка на отговор от Hugging Face API: " + errorBody));
                                }
                            });
                })
                .bodyToMono(String.class)
                .retryWhen(Retry.backoff(2, Duration.ofSeconds(2))
                        .maxBackoff(Duration.ofSeconds(4))
                        .filter(throwable -> {
                            String message = throwable.getMessage();
                            // Retry само за 429 (Too Many Requests) и 503 (Service Unavailable)
                            return message.contains("Прекалено много заявки към Hugging Face") ||
                                    message.contains("Hugging Face API е временно недостъпен");
                        })
                        .doBeforeRetry(retrySignal -> logger.info("Retrying request to Hugging Face due to error, attempt: {}", retrySignal.totalRetries() + 1)))
                .map(response -> {
                    try {
                        logger.debug("Hugging Face API response: {}", response);
                        JsonNode rootNode = objectMapper.readTree(response);
                        if (!rootNode.isArray() || rootNode.isEmpty()) {
                            logger.error("No valid response found in Hugging Face response: {}", response);
                            return "Грешка: Hugging Face не върна рецепта.";
                        }

                        String recipe = rootNode.get(0).path("generated_text").asText()
                                .replace("\\n", "\n")
                                .replace("\\\"", "\"");

                        if (recipe.isEmpty()) {
                            logger.warn("Empty recipe content in Hugging Face response.");
                            return "Грешка: Получена е празна рецепта.";
                        }

                        // Запазване в базата
                        AiRecipe aiRecipe = new AiRecipe();
                        aiRecipe.setIngredients(ingredients);
                        aiRecipe.setRecipe(recipe);
                        recipeRepository.save(aiRecipe);
                        logger.info("Recipe saved to database: {}", recipe);

                        return recipe;
                    } catch (Exception e) {
                        logger.error("Error parsing Hugging Face response: {}", e.getMessage(), e);
                        return "Грешка при обработка на отговора от Hugging Face: " + e.getMessage();
                    }
                })
                .onErrorResume(e -> {
                    logger.error("Error generating recipe: {}", e.getMessage(), e);
                    return Mono.just("Грешка при генериране на рецепта: " + e.getMessage());
                })
                .timeout(Duration.ofSeconds(50))
                .onErrorResume(e -> {
                    logger.error("Timeout or other error occurred: {}", e.getMessage(), e);
                    return Mono.just("Грешка: Заявката отне твърде много време. Моля, опитай отново по-късно.");
                });
    }
}

//package kamenov.naturalnaturefinalapp.service.impl;
//
//import kamenov.naturalnaturefinalapp.entity.AiRecipe;
//import kamenov.naturalnaturefinalapp.repositories.AiRecipeRepository;
//import kamenov.naturalnaturefinalapp.repositories.RecipeRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.stereotype.Service;
//import org.springframework.web.reactive.function.client.WebClient;
//import reactor.core.publisher.Mono;
//import kamenov.naturalnaturefinalapp.service.AiRecipeService;
//
//@Service
//public class AiRecipeServiceImpl implements AiRecipeService {
//
//private final AiRecipeRepository recipeRepository;
//    private final WebClient webClient;
//
//    @Autowired
//    public AiRecipeServiceImpl(AiRecipeRepository recipeRepository,
//                               @Value("${openai_api_key_2}") String apiKey) {
//        this.recipeRepository = recipeRepository;
//        this.webClient = WebClient.builder()
//                .baseUrl("https://api.openai.com/v1")
//                .defaultHeader("Authorization", "Bearer " + apiKey)
//                .defaultHeader("Content-Type", "application/json")
//                .build();
//    }
//    @Override
//    @Cacheable(value = "recipes", key = "#ingredients")
//    public Mono<String> getRecipeSuggestion(String ingredients) {
//        String prompt = "Дай ми еко рецепта с тези продукти: " + ingredients + ". Използвай кратък формат на рецепта и напиши я на български.";
//
//        return webClient.post()
//                .uri("/chat/completions")
//                .bodyValue("""
//                {
//                  "model": "gpt-3.5-turbo",
//                  "messages": [
//                    {"role": "system", "content": "Ти си екологичен готвач."},
//                    {"role": "user", "content": "%s"}
//                  ]
//                }
//                """.formatted(prompt))
//                .retrieve()
//                .bodyToMono(String.class)
//                .map(response -> {
//                    try {
//                        // По-точен парсинг с RegEx
//                        int index = response.indexOf("\"content\":\"");
//                        if (index == -1) return "Грешка при анализиране на отговора.";
//
//                        String content = response.substring(index + 10);
//                        int endIndex = content.indexOf("\"");
//                        String recipe = content.substring(0, endIndex)
//                                .replace("\\n", "\n")
//                                .replace("\\\"", "\"");
//
//                        // Запазване в базата
//                        AiRecipe aiRecipe = new AiRecipe();
//                        aiRecipe.setIngredients(ingredients);
//                        aiRecipe.setRecipe(recipe);
//                        recipeRepository.save(aiRecipe);
//
//                        return recipe;
//                    } catch (Exception e) {
//                        return "Грешка при обработка на отговора: " + e.getMessage();
//                    }
//                })
//                .onErrorResume(e -> Mono.just("Грешка при генериране на рецепта: " + e.getMessage()));
//    }

//    @Override
//    @Cacheable(value = "recipes", key = "#ingredients")
//    public Mono<String> getRecipeSuggestion(String ingredients) {
//        String prompt = "Дай ми еко рецепта с тези продукти: " + ingredients + ". Използвай кратък формат на рецепта и напиши я на български.";
//
//        String requestBody = """
//                {
//                  "model": "gpt-3.5-turbo",
//                  "messages": [
//                    {"role": "system", "content": "Ти си екологичен готвач."},
//                    {"role": "user", "content": "%s"}
//                  ],
//                  "temperature": 0.7
//                }
//                """.formatted(prompt);
//
//        return webClient.post()
//                .uri("/chat/completions")
//                .bodyValue(requestBody)
//                .retrieve()
//                .bodyToMono(String.class)
//                .map(response -> {
//                    int start = response.indexOf("\"content\":\"") + 11;
//                    int end = response.indexOf("\"", start);
//                    return response.substring(start, end).replace("\\n", "\n");
//                })
//                .onErrorResume(e -> Mono.just("Грешка при генериране на рецепта: " + e.getMessage()));
//    }
//



