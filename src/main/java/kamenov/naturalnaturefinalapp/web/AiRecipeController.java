package kamenov.naturalnaturefinalapp.web;




import kamenov.naturalnaturefinalapp.entity.AiRecipe;
import kamenov.naturalnaturefinalapp.repositories.AiRecipeRepository;
import kamenov.naturalnaturefinalapp.service.AiRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class AiRecipeController {

    private final AiRecipeService aiRecipeService;
private final AiRecipeRepository recipeRepository;
    @Autowired
    public AiRecipeController(AiRecipeService aiRecipeService, AiRecipeRepository recipeRepository) {
        this.aiRecipeService = aiRecipeService;
        this.recipeRepository = recipeRepository;
    }
    @GetMapping("/history")
    public List<AiRecipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    @GetMapping("/history/latest")
    public List<AiRecipe> getLastFiveRecipes() {
        return recipeRepository.findTop5ByOrderByGeneratedAtDesc();
    }
    @GetMapping("/ai-recipes")
    public String showAiRecipesPage(Model model) {
        List<AiRecipe> recentRecipes = recipeRepository.findTop5ByOrderByGeneratedAtDesc();
        model.addAttribute("recentRecipes", recentRecipes);
        return "ai-recipes"; // ai-recipes.html в templates/
    }

    @PostMapping("/ai-recipe")
    public Mono<Map<String, String>> generateRecipe(@RequestBody Map<String, String> input) {
        String ingredients = input.get("ingredients");
        return aiRecipeService.getRecipeSuggestion(ingredients)
                .map(result -> Map.of("recipe", result));
    }
//    @PostMapping("/api/ai-recipe")
//    @ResponseBody
//    public Map<String, String> generateRecipe(@RequestBody Map<String, String> input) {
//        String ingredients = input.get("ingredients");
//        String prompt = "Дай ми рецепта с тези съставки: " + ingredients + ". Да е здравословна, кратка и без пластмасови опаковки.";
//
//        String aiResponse =aiRecipeService.getRecipeSuggestion(prompt); // този метод вика OpenAI API
//        return Map.of("recipe", aiResponse);
//    }
}

