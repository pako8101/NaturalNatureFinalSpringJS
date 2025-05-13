package kamenov.naturalnaturefinalapp.service;

import org.springframework.cache.annotation.Cacheable;
import reactor.core.publisher.Mono;

public interface AiRecipeService {
    Mono<String> getRecipeSuggestion(String ingredients);

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
//    String generateRecipeWithHuggingFace(String ingredients) throws Exception;
//
//    String generateFallbackRecipe(String ingredients);
//
//    String getRandomDishType();

//    String generateRecipe(String ingredients) throws Exception;

//    @Cacheable("recipes")
//    String getRecipeFromIngredients(String ingredients);
}
