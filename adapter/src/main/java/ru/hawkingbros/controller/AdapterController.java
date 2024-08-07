package ru.hawkingbros.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.hawkingbros.model.Message;
import ru.hawkingbros.service.AdapterService;

@RestController
public class AdapterController {

    private final AdapterService adapterService;

    public AdapterController(AdapterService adapterService) {
        this.adapterService = adapterService;
    }

    @PostMapping("/api/messages")
    public String processMessage(@RequestBody Message message) {
        return adapterService.processMessage(message);
    }
}
