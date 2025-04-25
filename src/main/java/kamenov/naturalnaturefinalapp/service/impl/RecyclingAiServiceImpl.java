package kamenov.naturalnaturefinalapp.service.impl;

import kamenov.naturalnaturefinalapp.service.RecyclingAiService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.List;
import java.util.Map;

@Service
public class RecyclingAiServiceImpl implements RecyclingAiService {



        private final RestTemplate restTemplate;
        private final String OPENAI_API_URL = "https://api.openai.com/v1/chat/completions";
        private final String API_KEY = "${openai_api_key_2}";

        public RecyclingAiServiceImpl(RestTemplateBuilder builder) {
            this.restTemplate = builder.build();
        }
@Override
public String askRecyclingBot(String userQuestion) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("Authorization", API_KEY);

            Map<String, Object> message = Map.of(
                    "role", "user",
                    "content", userQuestion
            );

            Map<String, Object> requestBody = Map.of(
                    "model", "gpt-3.5-turbo",
                    "messages", List.of(message)
            );

            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);
            ResponseEntity<Map> response = restTemplate.postForEntity(OPENAI_API_URL, entity, Map.class);

            List<Map<String, Object>> choices = (List<Map<String, Object>>) response.getBody().get("choices");
            Map<String, Object> messageResponse = (Map<String, Object>) choices.get(0).get("message");
            return (String) messageResponse.get("content");
        }
    }


