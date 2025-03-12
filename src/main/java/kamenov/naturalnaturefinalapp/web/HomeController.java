package kamenov.naturalnaturefinalapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }
//    @GetMapping("/waste-management")
//    public String wasteManagement() {
//        return "waste-management";
//    }

}
