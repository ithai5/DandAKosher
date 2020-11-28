package com.example.demo.service;

import com.example.demo.model.Plate;
import com.example.demo.repository.PlateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlateService {

    private final PlateRepo plateRepo;

    @Autowired
    public PlateService(PlateRepo plateRepo) {
        this.plateRepo = plateRepo;
    }

    public Plate createPlate(Plate plate) {
        return plateRepo.save(plate);
    }
}
