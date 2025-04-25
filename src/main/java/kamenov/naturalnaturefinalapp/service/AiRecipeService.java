package kamenov.naturalnaturefinalapp.service;

import org.springframework.cache.annotation.Cacheable;
import reactor.core.publisher.Mono;

public interface AiRecipeService {
    Mono<String> getRecipeSuggestion(String ingredients);

//    @Cacheable("recipes")
//    String getRecipeFromIngredients(String ingredients);
}
