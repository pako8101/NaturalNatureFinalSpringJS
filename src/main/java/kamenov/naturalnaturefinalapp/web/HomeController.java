package kamenov.naturalnaturefinalapp.web;

import kamenov.naturalnaturefinalapp.entity.AiRecipe;
import kamenov.naturalnaturefinalapp.repositories.AiRecipeRepository;
import kamenov.naturalnaturefinalapp.repositories.RecipeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
private final AiRecipeRepository recipeRepository;

    public HomeController(AiRecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }


    @GetMapping("/")
    public String home() {
        return "index";
    }
    @GetMapping("/about")
    public String getAboutPage(Model model) {
        model.addAttribute("pageTitle", "About NatureEthos");
        return "about";
    }

//    @GetMapping("/api/ai-recipes")
//    public String showAiRecipesPage(Model model) {
//        List<AiRecipe> recentRecipes = recipeRepository.findTop5ByOrderByGeneratedAtDesc();
//        model.addAttribute("recentRecipes", recentRecipes);
//        return "ai-recipes"; // ai-recipes.html в templates/
//    }
//    @GetMapping("/waste-management")
//    public String wasteManagement() {
//        return "waste-management";
//    }

}
