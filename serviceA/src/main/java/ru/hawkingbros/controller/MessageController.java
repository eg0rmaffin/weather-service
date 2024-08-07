package ru.hawkingbros.controller;

import org.springframework.web.bind.annotation.*;
import ru.hawkingbros.model.Message;
import ru.hawkingbros.service.MessageService;

@RestController
@RequestMapping("/api")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestBody Message message) {
        return messageService.sendMessageToAdapter(message);
    }
}
