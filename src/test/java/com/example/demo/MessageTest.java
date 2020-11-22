package com.example.demo;


import com.example.demo.model.Message;
import com.example.demo.service.CustomerService;
import com.example.demo.service.MessageService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootTest
public class MessageTest {

    private final MessageService messageService;
    private final CustomerService customerService;
    private final JavaMailSender javaMailSender;

    @Autowired
    public MessageTest(MessageService messageService, CustomerService customerService, JavaMailSender javaMailSender){
        this.messageService=messageService;
        this.customerService=customerService;
        this.javaMailSender=javaMailSender;
    }

    @Test
    void CreateMessage(){
        Message message = new Message(4,"we test", "testtesttesttesttesttesttesttest", 6);
        Message messageDummy = new Message(4,"we test", "testtesttesttesttesttesttesttest", 6);
        //should pass the test
        Assertions.assertEquals(messageService.createMessage(message), message);

        //should fail
        messageDummy.setContent("We fail");
        Assertions.assertNotEquals(messageService.createMessage(message), messageDummy);
        //test Exception for invalid foreign key
        message.setCustomerId(99);
        Assertions.assertThrows(DataIntegrityViolationException.class , ()->messageService.createMessage(message));
    }

    @Test
    void findMessageById() {
        //Find a message in the database, expect true
        ResponseEntity<Message> msg1 = messageService.findById(1);
        Assertions.assertEquals("blablablablablablablablabla", msg1.getBody().getContent());

        //Expect true
        ResponseEntity<Message> msg2 = messageService.findById(3);
        Assertions.assertNotEquals("issue2", msg2.getBody().getSubject());

        //Test invalid id
        ResponseEntity<Message> msg3 = messageService.findById(99);
        Assertions.assertNull(msg3);
    }

    @Test
    void sendMessage() {
        //Dummy Data
        Message testMsg = messageService.findById(4).getBody();

        //
        SimpleMailMessage toSend = new SimpleMailMessage();
        toSend.setSubject(testMsg.getSubject());
        toSend.setText(testMsg.getContent());

        String customerEmail = customerService.findCustomerById(testMsg.getCustomerId()).getBody().getEmail();
        toSend.setFrom("jakesuck@gmail.com");

        String businessEmail = "dandakosher@gmail.com";
        toSend.setTo(businessEmail);

        javaMailSender.send(toSend);
    }
}
