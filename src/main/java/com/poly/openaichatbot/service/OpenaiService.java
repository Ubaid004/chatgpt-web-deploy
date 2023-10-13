package com.poly.openaichatbot.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenaiService {

    //@Value("${OPENAI_API_KEY}")
    private String apiKey="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";

    private String openaiUrl="https://api.openai.com/v1/chat/completions";

    private final RestTemplate restTemplate;

    @Autowired
    public OpenaiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String openaiServiceCall(String userInput) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set("Authorization", "Bearer " + apiKey);
        String requestBody = "{\"messages\": [{\"role\": \"system\", \"content\": \"You are a helpful assistant.\"}, {\"role\": \"user\", \"content\": \"" + userInput + "\"}], \"model\": \"gpt-3.5-turbo\"}";
        HttpEntity<String> request = new HttpEntity<>(requestBody, httpHeaders);
        String json= restTemplate.postForObject(openaiUrl, request, String.class);
        JSONObject jsonObject = new JSONObject(json);
        return jsonObject.getJSONArray("choices")
                .getJSONObject(0)
                .getJSONObject("message")
                .getString("content");

    }
}
