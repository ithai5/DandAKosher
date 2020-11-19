package com.example.demo;


import com.example.demo.model.Message;
import com.example.demo.service.MessageService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;

@SpringBootTest
public class MessageTest {

    private final MessageService messageService;

    @Autowired
    public MessageTest(MessageService messageService){
        this.messageService=messageService;
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
}
