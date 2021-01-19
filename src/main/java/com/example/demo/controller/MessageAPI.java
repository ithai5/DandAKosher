package com.example.demo.controller;

import com.example.demo.model.views.CustomerMessage;
import com.example.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class MessageAPI {

    private final MessageService messageService;
    @Autowired
    public MessageAPI(MessageService messageService){
        this.messageService = messageService;
    }
    @PostMapping(value = "/sendMessage", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void postMessage(@RequestBody CustomerMessage customerMessage ){
        messageService.handleSendMessageAPI(customerMessage);
        }
}
