package kamenov.naturalnaturefinalapp.web;

import kamenov.naturalnaturefinalapp.entity.Order;
import kamenov.naturalnaturefinalapp.entity.Recipe;
import kamenov.naturalnaturefinalapp.entity.UserEntity;
import kamenov.naturalnaturefinalapp.service.OrderService;
import kamenov.naturalnaturefinalapp.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GreenCookingController {

    private  final RecipeService recipeService;

    private final OrderService orderService;
    @Autowired
    public GreenCookingController(RecipeService recipeService, OrderService orderService) {
        this.recipeService = recipeService;
        this.orderService = orderService;
    }


    @GetMapping("/green-cooking")
    public String greenCooking(Model model) {
        model.addAttribute("recipes", recipeService.getAllRecipes());
        return "green-cooking";
    }
    @GetMapping("/admin/add-recipe")
    public String showAddRecipeForm(Model model) {
        model.addAttribute("recipe", new Recipe());
        return "add-recipe";
    }

    @PostMapping("/admin/add-recipe")
    public String addRecipe(@ModelAttribute Recipe recipe) {
        recipeService.saveRecipe(recipe);
        return "redirect:/green-cooking";
    }

    @GetMapping("/green-cooking/edit/{id}")
    public String showEditRecipeForm(@PathVariable Long id, Model model, @AuthenticationPrincipal UserEntity user) {
        Recipe recipe = recipeService.getRecipeById(id);
        if (recipe == null || !recipeService.canEditRecipe(recipe)) {
            return "redirect:/green-cooking";
        }
        model.addAttribute("recipe", recipe);
        return "edit-recipe";
    }

    @PostMapping("/green-cooking/edit/{id}")
    public String editRecipe(@PathVariable Long id, @ModelAttribute Recipe recipe) {
        Recipe existingRecipe = recipeService.getRecipeById(id);
        if (existingRecipe != null && recipeService.canEditRecipe(existingRecipe)) {
            recipe.setId(id);
            recipe.setCreatedBy(existingRecipe.getCreatedBy());
            recipeService.updateRecipe(recipe);
        }
        return "redirect:/green-cooking";
    }

    @GetMapping("/green-cooking/delete/{id}")
    public String deleteRecipe(@PathVariable Long id) {
        Recipe recipe = recipeService.getRecipeById(id);
        if (recipe != null && recipeService.canEditRecipe(recipe)) {
            recipeService.deleteRecipe(id);
        }
        return "redirect:/green-cooking";
    }
}
