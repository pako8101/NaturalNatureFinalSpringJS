package kamenov.naturalnaturefinalapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PackingLightController {

    @GetMapping("/packing-light")
    public String showPackingLight(Model model) {
        model.addAttribute("pageTitle", "Packing Light: Sustainable Travel Guide");
        return "packing-light";
    }

    @GetMapping("/article-packing")
    public String showArticle(@RequestParam("id") Long id, Model model) {
        System.out.println("Received request for /article-packing with id: " + id);
        model.addAttribute("articleId", id);
        return "article-packing";
    }
}