package com.lambdaschool.javazoos.repository;

import com.lambdaschool.javazoos.models.Animal;
import com.lambdaschool.javazoos.views.AnimalTypeCountZoos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnimalRepository extends CrudRepository<Animal, Long> {

    @Query(value = "SELECT a.animaltype as animal_animaltype, count(za.zooid) as count_zoo_ids FROM animals a LEFT JOIN zooanimals za ON a.animalid = za.animalid GROUP BY a.animaltype",
    nativeQuery = true)
    List<AnimalTypeCountZoos> getCountAnimalZoos();
}
