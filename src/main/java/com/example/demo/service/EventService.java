package com.example.demo.service;

import com.example.demo.model.Event;
import com.example.demo.repository.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepo eventRepo;

    @Autowired
    public EventService(EventRepo eventRepo) {
        this.eventRepo = eventRepo;
    }

    public ResponseEntity<List<Event>> findAll() {return new ResponseEntity<>(eventRepo.findAll(), HttpStatus.OK);}
}
