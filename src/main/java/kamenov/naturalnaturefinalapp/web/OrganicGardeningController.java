package kamenov.naturalnaturefinalapp.web;

import jakarta.transaction.Transactional;
import kamenov.naturalnaturefinalapp.entity.OrganicGardeningTip;
import kamenov.naturalnaturefinalapp.service.OrganicGardeningService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrganicGardeningController {

    private final OrganicGardeningService gardeningService;

    public OrganicGardeningController(OrganicGardeningService gardeningService) {
        this.gardeningService = gardeningService;
    }

    @GetMapping("/organic-gardening")
    @Transactional()
    public String getOrganicGardeningPage(Model model) {
        // Инициализация на съвети, ако са празни
        if (gardeningService.getAllTips().isEmpty()) {
            OrganicGardeningTip tip1 = new OrganicGardeningTip();
            tip1.setTitle("Composting Basics");
            tip1.setDescription("Start composting kitchen scraps like vegetable peels and coffee grounds to create rich, natural fertilizer for your garden. Use a compost bin with good ventilation and turn it weekly for best results.");
            tip1.setImagePath("/images/compost.jpg");

            OrganicGardeningTip tip2 = new OrganicGardeningTip();
            tip2.setTitle("Companion Planting");
            tip2.setDescription("Plant marigolds alongside tomatoes to naturally repel pests, or grow basil with peppers to enhance flavor and deter insects. This method boosts biodiversity and reduces chemical use.");
            tip2.setImagePath("/images/companion-planting.jpg");

            OrganicGardeningTip tip3 = new OrganicGardeningTip();
            tip3.setTitle("Water Conservation");
            tip3.setDescription("Install a rainwater harvesting system or use drip irrigation to save water. Mulch with straw or wood chips to retain moisture and keep soil healthy without overwatering.");
            tip3.setImagePath("/images/water-conservation.jpg");

            gardeningService.saveTip(tip1);
            gardeningService.saveTip(tip2);
            gardeningService.saveTip(tip3);
        }

        model.addAttribute("tips", gardeningService.getAllTips());
        model.addAttribute("showAll", false); // По подразбиране показва само един съвет
        return "organic-gardening";
    }

    @GetMapping("/organic-gardening/toggle-tips")
    public String toggleTips(@RequestParam boolean showAll, Model model) {
        model.addAttribute("tips", gardeningService.getAllTips());
        model.addAttribute("showAll", showAll);
        return "organic-gardening";
    }
}