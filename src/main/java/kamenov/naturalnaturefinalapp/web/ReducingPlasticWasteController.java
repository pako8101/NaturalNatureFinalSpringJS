package kamenov.naturalnaturefinalapp.web;

import kamenov.naturalnaturefinalapp.service.GreenTipService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reducing-plastic-waste")
public class ReducingPlasticWasteController {

    private static final Logger logger = LoggerFactory.getLogger(ReducingPlasticWasteController.class);
    private final GreenTipService greenTipService;

    public ReducingPlasticWasteController(GreenTipService greenTipService) {
        this.greenTipService = greenTipService;
    }

    @GetMapping
    public String showReducingPlasticWastePage(Model model) {
        logger.info("Showing reducing plastic waste page");
        model.addAttribute("tips", greenTipService.getAllTips());
        return "reducing-plastic-waste";
    }
}