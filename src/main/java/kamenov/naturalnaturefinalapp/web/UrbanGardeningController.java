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


    @GetMapping("/urban-gardening")
    public String urban(Model model) {
        model.addAttribute("pageTitle", "Urban Gardening | NatureEthos");
        return "urban-gardening";
    }

//    @GetMapping("/urban-gardening")
//    public String urbanGardening(@RequestParam(defaultValue = "1") int page, Model model) {
//        int articlesPerPage = 3;
//        List<ArticleGarden> articles = articleService.getPaginatedArticles(page, articlesPerPage);
//        long totalArticles = articleService.getTotalArticles(); // Поправка: Използваме getTotalArticles()
//        int totalPages = (int) Math.ceil((double) totalArticles / articlesPerPage);
//
//        model.addAttribute("articles", articles);
//        model.addAttribute("currentPage", page);
//        model.addAttribute("totalPages", totalPages);
//
//        return "urban-gardening";
//    }

    @GetMapping("/urban-gardening/article{id}")
    public String viewArticle(@PathVariable Long id, Model model) {
        Optional<ArticleGarden> article = articleService.getArticleById(id);
        if (article.isPresent()) {
            model.addAttribute("article", article.get());
            return "article-garden";
        } else {
            model.addAttribute("error", "Article not found.");
            return "article-garden";
        }
    }
}
