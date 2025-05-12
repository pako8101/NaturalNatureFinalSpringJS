package kamenov.naturalnaturefinalapp.web;

import kamenov.naturalnaturefinalapp.service.RecyclingAiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RecyclingBotController {

    private final RecyclingAiService aiService;
    private final List<HistoryEntry> history = new ArrayList<>();

    public RecyclingBotController(RecyclingAiService aiService) {
        this.aiService = aiService;
    }

    @GetMapping("/recycling-bot")
    public String showRecyclingBot(Model model) {
        model.addAttribute("history", history);
        return "recycling-bot";
    }

    @PostMapping("/recycling-bot")
    public String askBot(@RequestParam String question, Model model) {
        String answer = aiService.askRecyclingBot(question);
        history.add(new HistoryEntry(question, answer));
        model.addAttribute("history", history);
        return "recycling-bot";
    }

    public static class HistoryEntry {
        private final String question;
        private final String answer;

        public HistoryEntry(String question, String answer) {
            this.question = question;
            this.answer = answer;
        }

        public String getQuestion() {
            return question;
        }

        public String getAnswer() {
            return answer;
        }
    }
}