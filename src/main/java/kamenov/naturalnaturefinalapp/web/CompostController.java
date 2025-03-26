package kamenov.naturalnaturefinalapp.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/compost")
public class CompostController {

    private static final Logger logger = LoggerFactory.getLogger(CompostController.class);

    @GetMapping
    public String showCompostPage(Model model) {
        logger.info("Showing compost page");
        return "compost";
    }
}