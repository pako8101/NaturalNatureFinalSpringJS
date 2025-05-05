package kamenov.naturalnaturefinalapp.web;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarbonOffsetController {

    @GetMapping("/carbon-offsetting")
    public String showCarbonOffsetting(Model model) {
        model.addAttribute("pageTitle", "Carbon Offsetting: A Guide to Green Living");
        return "carbon-offsetting";
    }

    @GetMapping("/article-carbon")
    public String showArticle(@RequestParam("id") Long id, Model model) {
        model.addAttribute("articleId", id);
        return "article-carbon";
    }
}