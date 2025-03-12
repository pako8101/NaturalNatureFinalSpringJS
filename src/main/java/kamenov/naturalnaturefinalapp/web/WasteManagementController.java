package kamenov.naturalnaturefinalapp.web;

import kamenov.naturalnaturefinalapp.service.WasteManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WasteManagementController {

    @Autowired
    private WasteManagementService wasteManagementService;

    // Показване на страницата с всички съвети
    @GetMapping("/waste-management")
    public String getWasteManagementPage(Model model, @RequestParam(required = false) String category) {
        if (category != null && !category.trim().isEmpty()) {
            try {
                model.addAttribute("tips", wasteManagementService.getTipsByCategory(category));
            } catch (IllegalArgumentException e) {
                model.addAttribute("error", e.getMessage());
                model.addAttribute("tips", wasteManagementService.getAllTips());
            }
        } else {
            model.addAttribute("tips", wasteManagementService.getAllTips());
        }
        model.addAttribute("categories", wasteManagementService.getCategories());
        return "waste-management";
    }

    // Добавяне на нов съвет чрез POST заявка
    @PostMapping("/waste-management/add-tip")
    public String addNewTip(
            @RequestParam String category,
            @RequestParam String description,
            @RequestParam int priority,
            Model model) {
        try {
            wasteManagementService.addTip(category, description, priority);
            model.addAttribute("success", "Tip added successfully!");
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
        }
        model.addAttribute("tips", wasteManagementService.getAllTips());
        model.addAttribute("categories", wasteManagementService.getCategories());
        return "waste-management";
    }
}