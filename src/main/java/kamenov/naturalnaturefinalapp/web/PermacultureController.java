package kamenov.naturalnaturefinalapp.web;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PermacultureController {

    @GetMapping("/permaculture")
    public String showPermaculture(Model model) {
        model.addAttribute("pageTitle", "Permaculture: Cultivating a Sustainable Future");
        return "permaculture";
    }

    @GetMapping("/article-permaculture")
    public String showArticle(@RequestParam("id") Long id, Model model) {
        model.addAttribute("articleId", id);
        return "article-permaculture";
    }
}
