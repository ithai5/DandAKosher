package com.example.demo.service;

import com.example.demo.model.Message;
import com.example.demo.repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final MessageRepo messageRepo;

    @Autowired
    public MessageService(MessageRepo messageRepo) {
        super();
        this.messageRepo = messageRepo;
    }

    public Message createMessage(Message message) {
        return messageRepo.save(message);
    }
}
