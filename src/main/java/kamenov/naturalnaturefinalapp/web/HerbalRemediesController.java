package kamenov.naturalnaturefinalapp.web;

import kamenov.naturalnaturefinalapp.service.HerbalRemedyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class HerbalRemediesController {

    private static final Logger logger = LoggerFactory.getLogger(HerbalRemediesController.class);
    private final HerbalRemedyService herbalRemedyService;
@Autowired
    public HerbalRemediesController(HerbalRemedyService herbalRemedyService) {
        this.herbalRemedyService = herbalRemedyService;
    }

//    @GetMapping
//    public String showHerbalRemediesPage(Model model) {
//        logger.info("Showing herbs remedies page");
//        model.addAttribute("remedies", herbalRemedyService.getAllRemedies());
//        return "herbs-remedies";
//    }



        @GetMapping("/herbal-remedies")
        public String showHerbalRemedies(Model model) {
            model.addAttribute("pageTitle", "Herbal Remedies: Healing with Nature’s Touch");
            return "herbal-remedies";
        }

        @GetMapping("/article-herbal")
        public String showArticle(@RequestParam("id") Long id, Model model) {
            model.addAttribute("articleId", id);
            return "article-herbal";
        }

}
