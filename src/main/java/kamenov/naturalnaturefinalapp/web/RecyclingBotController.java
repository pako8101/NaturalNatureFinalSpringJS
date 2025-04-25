package kamenov.naturalnaturefinalapp.web;

import kamenov.naturalnaturefinalapp.service.RecyclingAiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RecyclingBotController {

    private final RecyclingAiService aiService;

    public RecyclingBotController(RecyclingAiService aiService) {
        this.aiService = aiService;
    }

    @PostMapping("/recycling-bot")
    public String askBot(@RequestParam String question, Model model) {
        String answer = aiService.askRecyclingBot(question);
        model.addAttribute("question", question);
        model.addAttribute("answer", answer);
        return "recycling-bot";
    }

}

