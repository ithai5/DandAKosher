package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.model.Message;
import com.example.demo.service.CustomerService;
import com.example.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService=messageService;
    }

    @GetMapping("/sendMessage")
    public String writeMessage() {
        return "sendEmail";
    }

    @PostMapping("/sendMessage")
    public String sendMessage(@ModelAttribute Customer cInfo, @ModelAttribute Message mInfo) {
        messageService.handleSendMessage(cInfo, mInfo);
        return "redirect:/";
    }
}
