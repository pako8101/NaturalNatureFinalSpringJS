package kamenov.naturalnaturefinalapp.service;



import kamenov.naturalnaturefinalapp.entity.Recipe;

import java.util.List;

public interface RecipeService {
    List<Recipe> getAllRecipes();

    Recipe getRecipeById(Long id);
}

