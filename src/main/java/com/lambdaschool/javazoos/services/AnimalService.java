package com.lambdaschool.javazoos.services;

import com.lambdaschool.javazoos.models.Animal;
import com.lambdaschool.javazoos.views.AnimalTypeCountZoos;

import java.util.List;

public interface AnimalService {
    List<Animal> findAll();

    List<AnimalTypeCountZoos> getAnimalTypeCountZoos();
//    Animal findAnimalById();
}
