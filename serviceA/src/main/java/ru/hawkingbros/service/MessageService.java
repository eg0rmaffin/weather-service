package ru.hawkingbros.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.hawkingbros.model.Message;

@Service
public class MessageService {

    private final RestTemplate restTemplate;
    private final String adapterServiceUrl;

    public MessageService(RestTemplate restTemplate, @Value("${adapter.service.url}") String adapterServiceUrl) {
        this.restTemplate = restTemplate;
        this.adapterServiceUrl = adapterServiceUrl;
    }

    public String sendMessageToAdapter(Message message) {
        return restTemplate.postForObject(adapterServiceUrl, message, String.class);
    }
}
