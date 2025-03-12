package kamenov.naturalnaturefinalapp.service;



import kamenov.naturalnaturefinalapp.entity.Recipe;

import java.util.List;

public interface RecipeService {
    List<Recipe> getAllRecipes();

    Recipe getRecipeById(Long id);

    void saveRecipe(Recipe recipe);

    void updateRecipe(Recipe recipe);

    void deleteRecipe(Long id);

    boolean canEditRecipe(Recipe recipe);
}

