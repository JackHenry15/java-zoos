package com.lambdaschool.javazoos.services;


import com.lambdaschool.javazoos.models.Animal;
import com.lambdaschool.javazoos.repository.AnimalRepository;
import com.lambdaschool.javazoos.repository.ZooRepository;
import com.lambdaschool.javazoos.views.AnimalTypeCountZoos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "animalService")
public class AnimalServiceImpl implements AnimalService{
    @Autowired
    AnimalRepository animalRepository;
    @Autowired
    AnimalAuditing animalAuditing;
    @Autowired
    ZooRepository zooRepository;

    @Override
    public List<Animal> findAll() {
        List<Animal> list = new ArrayList<>();
        animalRepository.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }

    @Override
    public List<AnimalTypeCountZoos> getAnimalTypeCountZoos() {
        return animalRepository.getCountAnimalZoos();
    }
    //    @Override
//    public Animal findAnimalById(long id) {
//        return animalRepository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("Animal id " + id + " Not Found"));
//    }
}
