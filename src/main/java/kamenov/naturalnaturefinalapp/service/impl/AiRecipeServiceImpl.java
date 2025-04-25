package kamenov.naturalnaturefinalapp.service.impl;

import kamenov.naturalnaturefinalapp.entity.AiRecipe;
import kamenov.naturalnaturefinalapp.repositories.AiRecipeRepository;
import kamenov.naturalnaturefinalapp.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import kamenov.naturalnaturefinalapp.service.AiRecipeService;

@Service
public class AiRecipeServiceImpl implements AiRecipeService {

private final AiRecipeRepository recipeRepository;
    private final WebClient webClient;

    @Autowired
    public AiRecipeServiceImpl(AiRecipeRepository recipeRepository,
                               @Value("${openai_api_key_2}") String apiKey) {
        this.recipeRepository = recipeRepository;
        this.webClient = WebClient.builder()
                .baseUrl("https://api.openai.com/v1")
                .defaultHeader("Authorization", "Bearer " + apiKey)
                .defaultHeader("Content-Type", "application/json")
                .build();
    }
    @Override
    @Cacheable(value = "recipes", key = "#ingredients")
    public Mono<String> getRecipeSuggestion(String ingredients) {
        String prompt = "Дай ми еко рецепта с тези продукти: " + ingredients + ". Използвай кратък формат на рецепта и напиши я на български.";

        return webClient.post()
                .uri("/chat/completions")
                .bodyValue("""
                {
                  "model": "gpt-3.5-turbo",
                  "messages": [
                    {"role": "system", "content": "Ти си екологичен готвач."},
                    {"role": "user", "content": "%s"}
                  ]
                }
                """.formatted(prompt))
                .retrieve()
                .bodyToMono(String.class)
                .map(response -> {
                    try {
                        // По-точен парсинг с RegEx
                        int index = response.indexOf("\"content\":\"");
                        if (index == -1) return "Грешка при анализиране на отговора.";

                        String content = response.substring(index + 10);
                        int endIndex = content.indexOf("\"");
                        String recipe = content.substring(0, endIndex)
                                .replace("\\n", "\n")
                                .replace("\\\"", "\"");

                        // Запазване в базата
                        AiRecipe aiRecipe = new AiRecipe();
                        aiRecipe.setIngredients(ingredients);
                        aiRecipe.setRecipe(recipe);
                        recipeRepository.save(aiRecipe);

                        return recipe;
                    } catch (Exception e) {
                        return "Грешка при обработка на отговора: " + e.getMessage();
                    }
                })
                .onErrorResume(e -> Mono.just("Грешка при генериране на рецепта: " + e.getMessage()));
    }

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

}

