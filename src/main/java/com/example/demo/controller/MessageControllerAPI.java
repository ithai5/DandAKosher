package com.example.demo.controller;

import com.example.demo.model.CustomerMessage;
import com.example.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class MessageControllerAPI {

    private final MessageService messageService;
    @Autowired
    public MessageControllerAPI(MessageService messageService){
        this.messageService = messageService;
    }
    @PostMapping(value = "/sendMessage", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void postMessage(@RequestBody CustomerMessage customerMessage ){
        messageService.handleSendMessageAPI(customerMessage);
        }
}
