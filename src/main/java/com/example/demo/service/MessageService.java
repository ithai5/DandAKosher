package com.example.demo.service;

import com.example.demo.model.Message;
import com.example.demo.repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    //Consider adding error handling
    public ResponseEntity<Message> findById(int id) {
        Optional<Message> response = messageRepo.findById(id);
        if (response.isPresent()) {
            return new ResponseEntity<Message>(response.get(), HttpStatus.OK);
        }
        return null;
    }
    /*
    public void sendMessageToEmail(Message message) {
        SimpleMailMessage toEmail = new SimpleMailMessage();
        toEmail.setText(message.);
    }
    */
}
