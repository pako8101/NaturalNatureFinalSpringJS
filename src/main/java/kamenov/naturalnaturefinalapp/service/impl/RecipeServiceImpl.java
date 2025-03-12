package kamenov.naturalnaturefinalapp.service.impl;


import kamenov.naturalnaturefinalapp.entity.Recipe;
import kamenov.naturalnaturefinalapp.entity.UserEntity;
import kamenov.naturalnaturefinalapp.repositories.RecipeRepository;
import kamenov.naturalnaturefinalapp.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository repository;
    @Autowired
    public RecipeServiceImpl(RecipeRepository repository) {
        this.repository = repository;
    }
    @Override
    public void saveRecipe(Recipe recipe) {
        UserEntity currentUser = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        recipe.setCreatedBy(currentUser);
        repository.save(recipe);
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return repository.findAll();
    }

    @Override
    public Recipe getRecipeById(Long id) {
        return repository.findById(id).orElse(null);
    }
@Override
    public void updateRecipe(Recipe recipe) {
        repository.save(recipe);
    }
@Override
    public void deleteRecipe(Long id) {
        repository.deleteById(id);
    }
@Override
    public boolean canEditRecipe(Recipe recipe) {
        UserEntity currentUser = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return recipe.getCreatedBy().getId().equals(currentUser.getId());
    }
}
