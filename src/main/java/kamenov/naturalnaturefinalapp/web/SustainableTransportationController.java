package kamenov.naturalnaturefinalapp.web;


import kamenov.naturalnaturefinalapp.entity.Article;
import kamenov.naturalnaturefinalapp.service.ArticleService;
import kamenov.naturalnaturefinalapp.service.TransportTipService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
    @RequestMapping("/sustainable-transportation")
    public class SustainableTransportationController {
private final ArticleService articleService;
        private static final Logger logger = LoggerFactory.getLogger(SustainableTransportationController.class);
        private final TransportTipService transportTipService;

        public SustainableTransportationController(ArticleService articleService, TransportTipService transportTipService) {
            this.articleService = articleService;
            this.transportTipService = transportTipService;
        }
    @GetMapping
    public String showSustainableTransportationPage(Model model) {
        logger.info("Showing sustainable transportation page");
        model.addAttribute("tips", transportTipService.getAllTips());
        model.addAttribute("articles", articleService.getFirstThreeSustainableTransportArticles());
        return "sustainable-transportation";
    }

    @GetMapping("/articles")
    public String showSustainableTransportArticlesPage(@RequestParam(defaultValue = "0") int page, Model model) {
        logger.info("Showing sustainable transport articles page, page number: {}", page);
        int pageSize = 6; // По 6 статии на страница
        Page<Article> articlePage = articleService.getSustainableTransportArticles(page, pageSize);
        model.addAttribute("articles", articlePage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", articlePage.getTotalPages());
        return "sustainable-transportation-articles";
    }
//        @GetMapping
//        public String showSustainableTransportationPage(Model model) {
//            logger.info("Showing sustainable transportation page");
//            model.addAttribute("tips", transportTipService.getAllTips());
//            return "sustainable-transportation";
//        }
}
