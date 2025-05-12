package kamenov.naturalnaturefinalapp.service.impl;

import kamenov.naturalnaturefinalapp.service.RecyclingAiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecyclingAiServiceImpl implements RecyclingAiService {

    private final RestTemplate restTemplate;
    private final String OPENAI_API_URL = "https://api.openai.com/v1/chat/completions";
    @Value("${openai.api.key_2}")
    private String apiKey;

    public RecyclingAiServiceImpl(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    @Override
    public String askRecyclingBot(String userQuestion) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("Authorization", "Bearer " + apiKey);

            Map<String, Object> message = new HashMap<>();
            message.put("role", "user");
            message.put("content", userQuestion);

            Map<String, Object> requestBody = new HashMap<>();
            requestBody.put("model", "gpt-3.5-turbo");
            requestBody.put("messages", List.of(message));
            requestBody.put("max_tokens", 150); // Ограничаване на дължината на отговора

            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);
            ResponseEntity<Map> response = restTemplate.postForEntity(OPENAI_API_URL, entity, Map.class);

            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                List<Map<String, Object>> choices = (List<Map<String, Object>>) response.getBody().get("choices");
                if (choices != null && !choices.isEmpty()) {
                    Map<String, Object> messageResponse = (Map<String, Object>) choices.get(0).get("message");
                    if (messageResponse != null && messageResponse.containsKey("content")) {
                        return (String) messageResponse.get("content");
                    }
                }
            }
            return "Sorry, I couldn't get a valid response from the AI. Please try again or check your API key.";
        } catch (HttpClientErrorException e) {
            return "Error: " + e.getStatusCode() + " - " + e.getResponseBodyAsString();
        } catch (Exception e) {
            return "An unexpected error occurred: " + e.getMessage();
        }
    }
}