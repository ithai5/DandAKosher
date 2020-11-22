package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.model.Message;
import com.example.demo.service.CustomerService;
import com.example.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MessageController {

    private final MessageService messageService;
    private final CustomerService customerService;

    @Autowired
    public MessageController(MessageService messageService, CustomerService customerService){
        this.messageService=messageService;
        this.customerService=customerService;
    }

    @GetMapping("/sendMessage")
    public String writeMessage() {
        return "sendEmail";
    }

    @PostMapping("/sendMessage")
    public String sendMessage(@ModelAttribute Customer cInfo, @ModelAttribute Message mInfo) {
        Customer customer = customerService.customerExists(cInfo);
        mInfo.setCustomerId(customer.getId());
        System.out.println("mInfo" + mInfo);
        Message message = messageService.createMessage(mInfo);
        messageService.sendMessageToEmail(message);
        return "redirect:/";
    }
}
