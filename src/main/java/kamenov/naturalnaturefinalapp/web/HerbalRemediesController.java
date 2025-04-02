package kamenov.naturalnaturefinalapp.web;

import kamenov.naturalnaturefinalapp.service.HerbalRemedyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/herbal-remedies")
public class HerbalRemediesController {

    private static final Logger logger = LoggerFactory.getLogger(HerbalRemediesController.class);
    private final HerbalRemedyService herbalRemedyService;
@Autowired
    public HerbalRemediesController(HerbalRemedyService herbalRemedyService) {
        this.herbalRemedyService = herbalRemedyService;
    }

    @GetMapping
    public String showHerbalRemediesPage(Model model) {
        logger.info("Showing herbal remedies page");
        model.addAttribute("remedies", herbalRemedyService.getAllRemedies());
        return "herbal-remedies";
    }
}
