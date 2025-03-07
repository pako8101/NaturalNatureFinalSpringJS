package kamenov.naturalnaturefinalapp.web;


import kamenov.naturalnaturefinalapp.entity.RecyclingCenter;
import kamenov.naturalnaturefinalapp.service.RecyclingCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/recycling")

public class RecyclingCenterController {
    @Autowired
    private final RecyclingCenterService service;

    public RecyclingCenterController(RecyclingCenterService service) {
        this.service = service;
    }

    @GetMapping("/centers")
    public List<RecyclingCenter> getCentersByCity(@RequestParam String city) {
        return service.getCentersByCity(city);
    }
    @GetMapping("/recycling")
    public String recyclingMap(@RequestParam(required = false) String city,
                               Model model) {
        model.addAttribute("points",
                city != null ? service.getCentersByCity(city) : service.getAllCenters());
        return "recycling";
    }
}




