package kamenov.naturalnaturefinalapp.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import kamenov.naturalnaturefinalapp.entity.AiRecipe;
import kamenov.naturalnaturefinalapp.repositories.AiRecipeRepository;
import kamenov.naturalnaturefinalapp.service.AiRecipeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class AiRecipeServiceImpl implements AiRecipeService {

    private static final Logger logger = LoggerFactory.getLogger(AiRecipeServiceImpl.class);

    private final AiRecipeRepository recipeRepository;
    private final WebClient webClient;
    private final ObjectMapper objectMapper;

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
            logger.error("Hugging Face API key is not set or is empty. Please check the 'huggingface.api.key' property.");
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

        String prompt = "Ти си екологичен готвач. Дай ми еко рецепта с тези продукти: " + ingredients +
                ". Използвай кратък формат на рецепта и напиши я на български.";
        logger.info("Generating recipe for ingredients: {}", ingredients);

        String requestBody = """
                {
                  "inputs": "%s",
                  "parameters": {
                    "max_length": 200,
                    "temperature": 0.7,
                    "top_p": 0.9
                  }
                }
                """.formatted(prompt);

        return webClient.post()
                .uri("/models/mixtral-8x7b-instruct-v0.1") // Сменен модел на по-достъпен
                .bodyValue(requestBody)
                .retrieve()
                .onStatus(status -> status.isError(), clientResponse -> clientResponse.bodyToMono(String.class)
                        .flatMap(errorBody -> {
                            logger.error("Hugging Face API error - Status: {}, Body: {}", clientResponse.statusCode(), errorBody);
                            try {
                                JsonNode errorNode = objectMapper.readTree(errorBody);
                                String errorMessage = errorNode.path("error").asText("Unknown error");
                                if (clientResponse.statusCode().value() == 404) {
                                    return Mono.error(new RuntimeException("Hugging Face API: Моделът не е намерен (404)."));
                                } else if (clientResponse.statusCode().value() == 429) {
                                    return Mono.error(new RuntimeException("Прекалено много заявки към Hugging Face. Моля, изчакайте малко и опитай отново."));
                                } else if (clientResponse.statusCode().value() == 503) {
                                    return Mono.error(new RuntimeException("Hugging Face API е временно недостъпен (503). Моля, опитайте отново по-късно."));
                                }
                                return Mono.error(new RuntimeException("Грешка от Hugging Face API: " + errorMessage));
                            } catch (Exception e) {
                                logger.error("Error parsing Hugging Face error response: {}", e.getMessage(), e);
                                return Mono.error(new RuntimeException("Грешка при обработка на отговор от Hugging Face API: " + errorBody));
                            }
                        }))
                .bodyToMono(String.class)
                .retryWhen(Retry.backoff(2, Duration.ofSeconds(2))
                        .maxBackoff(Duration.ofSeconds(4))
                        .filter(throwable -> {
                            String message = throwable.getMessage();
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
                            return generateFallbackRecipe(ingredients);
                        }

                        String recipe = rootNode.get(0).path("generated_text").asText()
                                .replace("\\n", "\n")
                                .replace("\\\"", "\"");

                        if (recipe.isEmpty()) {
                            logger.warn("Empty recipe content in Hugging Face response.");
                            return generateFallbackRecipe(ingredients);
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
                        return generateFallbackRecipe(ingredients);
                    }
                })
                .onErrorResume(e -> {
                    logger.error("Error generating recipe: {}", e.getMessage(), e);
                    return Mono.just(generateFallbackRecipe(ingredients));
                })
                .timeout(Duration.ofSeconds(30))
                .onErrorResume(e -> {
                    logger.error("Timeout or other error occurred: {}", e.getMessage(), e);
                    return Mono.just(generateFallbackRecipe(ingredients));
                });
    }

    private String generateFallbackRecipe(String ingredients) {
        String[] ingredientList = ingredients.split(",");
        StringBuilder recipe = new StringBuilder();

        recipe.append("**Еко-приятелска ").append(getRandomDishType()).append(" Рецепта**\n\n");
        recipe.append("**Съставки:**\n");
        for (String ingredient : ingredientList) {
            recipe.append("- ").append(ingredient.trim()).append("\n");
        }
        recipe.append("\n");

        recipe.append("**Стъпки:**\n");
        recipe.append("1. Подгответе съставките, като ги измиете и нарежете според нуждите.\n");
        recipe.append("2. Загрейте тиган с малко зехтин на слаб огън, за да пестите енергия.\n");
        recipe.append("3. Задушете съставките за 5-7 минути, докато омекнат.\n");
        recipe.append("4. Подправете с еко подправки като местни билки или био сол.\n");
        recipe.append("5. Сервирайте топло и се насладете на вашата устойчива яхния!\n\n");

        recipe.append("**Съвет:** Компостирайте остатъците от храна, за да намалите отпадъците!");

        // Запазване в базата дори при резервна логика
        AiRecipe aiRecipe = new AiRecipe();
        aiRecipe.setIngredients(ingredients);
        aiRecipe.setRecipe(recipe.toString());
        recipeRepository.save(aiRecipe);
        logger.info("Fallback recipe saved to database: {}", recipe);

        return recipe.toString();
    }

    private String getRandomDishType() {
        String[] dishTypes = {"Салата", "Супа", "Запръжка", "Яхния", "Купа"};
        return dishTypes[new Random().nextInt(dishTypes.length)];
    }
}
//public class AiRecipeServiceImpl implements AiRecipeService {
//
//    private static final Logger logger = LoggerFactory.getLogger(AiRecipeServiceImpl.class);
//
//    private final AiRecipeRepository recipeRepository;
//    private final WebClient webClient;
//    private final ObjectMapper objectMapper;
//
//    @Autowired
//    public AiRecipeServiceImpl(AiRecipeRepository recipeRepository,
//                               @Value("${OPENAI_API_KEY}") String apiKey,
//                               RestTemplateBuilder builder
//                               ) {
//        this.restTemplate = builder.build();
//        this.recipeRepository = recipeRepository;
//        this.objectMapper = new ObjectMapper();
//        this.webClient = WebClient.builder()
//                .baseUrl("https://api-inference.huggingface.co")
//                .defaultHeader("Authorization", "Bearer " + apiKey)
//                .defaultHeader("Content-Type", "application/json")
//                .build();
//
//        if (apiKey == null || apiKey.trim().isEmpty()) {
//            logger.error("Hugging Face API key is not set or is empty. Please check the 'OPENAI_API_KEY' property.");
//        } else {
//            logger.info("AiRecipeService initialized with Hugging Face API key.");
//        }
//    }
//
//    private final RestTemplate restTemplate;
//    private final String HUGGINGFACE_API_URL = "https://api-inference.huggingface.co/models/mixtral-8x7b-instruct-v0.1";
//    @Value("${OPENAI_API_KEY}")
//    private String apiKey;
//
//

//    @Override
//    public String generateRecipe(String ingredients) throws Exception {
//        try {
//            // Първо опитваме да използваме Hugging Face API
//            return generateRecipeWithHuggingFace(ingredients);
//        } catch (Exception e) {
//            // Ако API-то не работи, използваме резервна логика
//            return generateFallbackRecipe(ingredients);
//        }
//    }
//@Override
//public String generateRecipeWithHuggingFace(String ingredients) throws Exception {
//        try {
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.APPLICATION_JSON);
//            headers.set("Authorization", "Bearer " + apiKey);
//
//            String prompt = "Generate a sustainable recipe using the following ingredients: " + ingredients +
//                    ". Focus on eco-friendly cooking methods and include a title, ingredients list, and steps.";
//
//            Map<String, Object> requestBody = new HashMap<>();
//            requestBody.put("inputs", prompt);
//            requestBody.put("parameters", Map.of(
//                    "max_length", 300,
//                    "temperature", 0.7,
//                    "top_p", 0.9
//            ));
//
//            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);
//            ResponseEntity<List> response = restTemplate.postForEntity(HUGGINGFACE_API_URL, entity, List.class);
//
//            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null && !response.getBody().isEmpty()) {
//                Map<String, Object> result = (Map<String, Object>) response.getBody().get(0);
//                if (result.containsKey("generated_text")) {
//                    return (String) result.get("generated_text");
//                }
//            }
//            throw new Exception("Invalid response from Hugging Face API");
//        } catch (HttpClientErrorException e) {
//            throw new Exception("Hugging Face API error: " + e.getStatusCode() + " - " + e.getResponseBodyAsString());
//        } catch (Exception e) {
//            throw new Exception("Failed to generate recipe with Hugging Face API: " + e.getMessage());
//        }
//    }
//@Override
//public String generateFallbackRecipe(String ingredients) {
//        // Локална логика за генериране на рецепта, ако API-то не работи
//        String[] ingredientList = ingredients.split(",");
//        StringBuilder recipe = new StringBuilder();
//
//        recipe.append("<strong>Eco-Friendly ").append(getRandomDishType()).append(" Recipe</strong><br><br>");
//        recipe.append("<strong>Ingredients:</strong><br>");
//        for (String ingredient : ingredientList) {
//            recipe.append("- ").append(ingredient.trim()).append("<br>");
//        }
//        recipe.append("<br>");
//
//        recipe.append("<strong>Steps:</strong><br>");
//        recipe.append("1. Prepare your ingredients by washing and chopping them as needed.<br>");
//        recipe.append("2. Heat a pan with a small amount of olive oil using low heat to save energy.<br>");
//        recipe.append("3. Sauté the ingredients for 5-7 minutes until tender.<br>");
//        recipe.append("4. Season with eco-friendly spices like local herbs or organic salt.<br>");
//        recipe.append("5. Serve warm and enjoy your sustainable meal!<br><br>");
//
//        recipe.append("<strong>Tip:</strong> Compost any food scraps to reduce waste!");
//
//        return recipe.toString();
//    }
//@Override
//public String getRandomDishType() {
//        String[] dishTypes = {"Salad", "Soup", "Stir-Fry", "Stew", "Bowl"};
//        return dishTypes[new Random().nextInt(dishTypes.length)];
//    }
//}

//    @Override
//    @Cacheable(value = "recipes", key = "#ingredients")
//    public Mono<String> getRecipeSuggestion(String ingredients) {
//        if (ingredients == null || ingredients.trim().isEmpty()) {
//            logger.warn("Ingredients input is empty or null.");
//            return Mono.just("Моля, въведете продукти за рецептата.");
//        }
//
//        String prompt = "Ти си екологичен готвач. Дай ми еко рецепта с тези продукти: " + ingredients + ". Използвай кратък формат на рецепта и напиши я на български.";
//        logger.info("Generating recipe for ingredients: {}", ingredients);
//
//        String requestBody = """
//                {
//                  "inputs": "%s",
//                  "parameters": {
//                    "max_length": 200,
//                    "temperature": 0.7
//                  }
//                }
//                """.formatted(prompt);
//
//        return webClient.post()
//                .uri("/models/distilgpt2") // Сменен модел на distilgpt2
//                .bodyValue(requestBody)
//                .retrieve()
//                .onStatus(status -> status.isError(), clientResponse -> {
//                    HttpStatus statusCode = HttpStatus.valueOf(clientResponse.statusCode().value());
//                    return clientResponse.bodyToMono(String.class)
//                            .flatMap(errorBody -> {
//                                logger.error("Hugging Face API error - Status: {}, Body: {}", statusCode, errorBody);
//                                // Проверяваме дали тялото започва с HTML (<!DOCTYPE или <html)
//                                if (errorBody.trim().startsWith("<!DOCTYPE") || errorBody.trim().startsWith("<html")) {
//                                    if (statusCode == HttpStatus.SERVICE_UNAVAILABLE) {
//                                        return Mono.error(new RuntimeException("Hugging Face API е временно недостъпен (503 Service Unavailable). Моля, опитайте отново по-късно."));
//                                    }
//                                    return Mono.error(new RuntimeException("Неочаквана HTML грешка от Hugging Face API: " + statusCode));
//                                }
//                                // Ако не е HTML, опитваме да парснем като JSON
//                                try {
//                                    JsonNode errorNode = objectMapper.readTree(errorBody);
//                                    String errorMessage = errorNode.path("error").asText();
//
//                                    if (statusCode == HttpStatus.TOO_MANY_REQUESTS) {
//                                        return Mono.error(new RuntimeException("Прекалено много заявки към Hugging Face. Моля, изчакайте малко и опитай отново."));
//                                    }
//                                    return Mono.error(new RuntimeException("Грешка от Hugging Face API: " + errorMessage));
//                                } catch (Exception e) {
//                                    logger.error("Error parsing Hugging Face error response: {}", e.getMessage(), e);
//                                    return Mono.error(new RuntimeException("Грешка при обработка на отговор от Hugging Face API: " + errorBody));
//                                }
//                            });
//                })
//                .bodyToMono(String.class)
//                .retryWhen(Retry.backoff(2, Duration.ofSeconds(2))
//                        .maxBackoff(Duration.ofSeconds(4))
//                        .filter(throwable -> {
//                            String message = throwable.getMessage();
//                            // Retry само за 429 (Too Many Requests) и 503 (Service Unavailable)
//                            return message.contains("Прекалено много заявки към Hugging Face") ||
//                                    message.contains("Hugging Face API е временно недостъпен");
//                        })
//                        .doBeforeRetry(retrySignal -> logger.info("Retrying request to Hugging Face due to error, attempt: {}", retrySignal.totalRetries() + 1)))
//                .map(response -> {
//                    try {
//                        logger.debug("Hugging Face API response: {}", response);
//                        JsonNode rootNode = objectMapper.readTree(response);
//                        if (!rootNode.isArray() || rootNode.isEmpty()) {
//                            logger.error("No valid response found in Hugging Face response: {}", response);
//                            return "Грешка: Hugging Face не върна рецепта.";
//                        }
//
//                        String recipe = rootNode.get(0).path("generated_text").asText()
//                                .replace("\\n", "\n")
//                                .replace("\\\"", "\"");
//
//                        if (recipe.isEmpty()) {
//                            logger.warn("Empty recipe content in Hugging Face response.");
//                            return "Грешка: Получена е празна рецепта.";
//                        }
//
//                        // Запазване в базата
//                        AiRecipe aiRecipe = new AiRecipe();
//                        aiRecipe.setIngredients(ingredients);
//                        aiRecipe.setRecipe(recipe);
//                        recipeRepository.save(aiRecipe);
//                        logger.info("Recipe saved to database: {}", recipe);
//
//                        return recipe;
//                    } catch (Exception e) {
//                        logger.error("Error parsing Hugging Face response: {}", e.getMessage(), e);
//                        return "Грешка при обработка на отговора от Hugging Face: " + e.getMessage();
//                    }
//                })
//                .onErrorResume(e -> {
//                    logger.error("Error generating recipe: {}", e.getMessage(), e);
//                    return Mono.just("Грешка при генериране на рецепта: " + e.getMessage());
//                })
//                .timeout(Duration.ofSeconds(50))
//                .onErrorResume(e -> {
//                    logger.error("Timeout or other error occurred: {}", e.getMessage(), e);
//                    return Mono.just("Грешка: Заявката отне твърде много време. Моля, опитай отново по-късно.");
//                });
//    }
//}



