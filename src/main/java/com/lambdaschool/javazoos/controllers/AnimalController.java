package com.lambdaschool.javazoos.controllers;


import com.lambdaschool.javazoos.services.AnimalService;
import com.lambdaschool.javazoos.views.AnimalTypeCountZoos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {
    @Autowired
    AnimalService animalService;

    @GetMapping(value = "/count")
    public ResponseEntity<?> getAnimalZooCounts()
    {
        List<AnimalTypeCountZoos> myAnimals = animalService.getAnimalTypeCountZoos();
        return new ResponseEntity<>(myAnimals,
                HttpStatus.OK);
    }
}