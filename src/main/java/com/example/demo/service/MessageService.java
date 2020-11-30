package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.model.CustomerMessage;
import com.example.demo.model.Message;
import com.example.demo.repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MessageService {

    private final MessageRepo messageRepo;
    private final CustomerService customerService;
    private final JavaMailSender javaMailSender;

    @Autowired
    public MessageService(MessageRepo messageRepo, JavaMailSender javaMailSender, CustomerService customerService) {
        super();
        this.messageRepo = messageRepo;
        this.javaMailSender=javaMailSender;
        this.customerService=customerService;
    }

    public Message createMessage(Message message) {
        System.out.println("message" + message);
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

    public void sendMessageToEmail(Message message) {
        SimpleMailMessage toEmail = new SimpleMailMessage();
        toEmail.setSubject(message.getSubject());
        toEmail.setText(message.getContent());
        //Not sure if this part matters
        toEmail.setFrom("whatever@mail.com");

        toEmail.setTo(System.getenv("mailAddress"));
        javaMailSender.send(toEmail);
    }

    public void handleSendMessage( Customer cInfo, Message mInfo) {
        Customer customer = customerService.customerExists(cInfo);
        mInfo.setCustomerId(customer.getId());
        Message message = createMessage(mInfo);
        sendMessageToEmail(message);
    }
    public void handleSendMessageAPI(CustomerMessage customerMessage) {
        Customer cInfo = new Customer(
                0,
                customerMessage.getFullName(),
                customerMessage.getPhone(),
                customerMessage.getEmail(),
                customerMessage.getIsSubscribed()? (byte)(1): (byte)(0));
        Customer customer = customerService.customerExists(cInfo);
        Message mInfo = new Message(
                0,
                customerMessage.getSubject(),
                customerMessage.getContent(),
                0
        );
        mInfo.setCustomerId(customer.getId());
        Message message = createMessage(mInfo);
        sendMessageToEmail(message);
    }


}
