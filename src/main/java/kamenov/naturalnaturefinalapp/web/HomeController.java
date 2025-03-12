package kamenov.naturalnaturefinalapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }
    @GetMapping("/about")
    public String getAboutPage(Model model) {
        model.addAttribute("pageTitle", "About NatureEthos");
        return "about";
    }
//    @GetMapping("/waste-management")
//    public String wasteManagement() {
//        return "waste-management";
//    }

}
