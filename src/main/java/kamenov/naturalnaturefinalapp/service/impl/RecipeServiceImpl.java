package kamenov.naturalnaturefinalapp.service.impl;


import kamenov.naturalnaturefinalapp.entity.Recipe;
import kamenov.naturalnaturefinalapp.repositories.RecipeRepository;
import kamenov.naturalnaturefinalapp.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Recipe> getAllRecipes() {
        return repository.findAll();
    }

    @Override
    public Recipe getRecipeById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
