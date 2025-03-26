package kamenov.naturalnaturefinalapp.web;

import kamenov.naturalnaturefinalapp.service.PlasticTipService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reducing-plastics")
public class ReducingPlasticsController {

    private static final Logger logger = LoggerFactory.getLogger(ReducingPlasticsController.class);
    private final PlasticTipService plasticTipService;

    public ReducingPlasticsController(PlasticTipService plasticTipService) {
        this.plasticTipService = plasticTipService;
    }

    @GetMapping
    public String showReducingPlasticsPage(Model model) {
        logger.info("Showing reducing plastics page");
        model.addAttribute("tips", plasticTipService.getAllTips());
        return "reducing-plastics";
    }
}