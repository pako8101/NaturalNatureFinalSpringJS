package kamenov.naturalnaturefinalapp.web;

import kamenov.naturalnaturefinalapp.entity.Article;
import kamenov.naturalnaturefinalapp.entity.ArticleGarden;
import kamenov.naturalnaturefinalapp.service.ArticleGardeningService;
import kamenov.naturalnaturefinalapp.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class UrbanGardeningController {

    private final ArticleGardeningService articleService;
    @Autowired
    public UrbanGardeningController(ArticleGardeningService articleService) {
        this.articleService = articleService;
    }

//
//    @GetMapping("/urban-gardening")
//    public String urban(Model model) {
//        model.addAttribute("pageTitle", "Urban Gardening | NatureEthos");
//        return "urban-gardening";
//    }
//    @GetMapping("/article-garden")
//    public String showArticle() {
//        return "article-garden";
//    }
@GetMapping("/urban-gardening")
public String urban(Model model) {
    model.addAttribute("pageTitle", "Urban Gardening | NatureEthos");
    return "urban-gardening";
}

    @GetMapping("/article-garden")
    public String showArticle(@RequestParam("id") Long id, Model model) {
        System.out.println("Received request for /article-garden with id: " + id);
        model.addAttribute("articleId", id);
        return "article-garden";
    }
}
