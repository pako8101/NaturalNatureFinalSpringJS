package kamenov.naturalnaturefinalapp.service.impl;

import kamenov.naturalnaturefinalapp.service.AiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
@Service
public class AiServiceImpl implements AiService {


        @Value("${openai_api_key_2}")
        private String apiKey;

        private static final String OPENAI_URL = "https://api.openai.com/v1/chat/completions";
@Override
public String getOpenAiResponse(String userPrompt) {
            RestTemplate restTemplate = new RestTemplate();

            // Подготвяме JSON payload
            Map<String, Object> message = new HashMap<>();
            message.put("role", "user");
            message.put("content", userPrompt);

            Map<String, Object> requestBody = new HashMap<>();
            requestBody.put("model", "gpt-3.5-turbo");
            requestBody.put("messages", new Map[]{message});
            requestBody.put("temperature", 0.7);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(apiKey);

            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

            ResponseEntity<Map> response = restTemplate.exchange(
                    OPENAI_URL,
                    HttpMethod.POST,
                    entity,
                    Map.class
            );

            // Извличаме отговора
            try {
                Map<String, Object> choice = (Map<String, Object>) ((Map[]) ((java.util.List<?>) response.getBody().get("choices")).toArray())[0];
                Map<String, String> messageData = (Map<String, String>) choice.get("message");
                return messageData.get("content");
            } catch (Exception e) {
                return "Грешка при генериране на отговор от AI.";
            }
        }
    }


