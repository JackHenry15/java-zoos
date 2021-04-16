package com.lambdaschool.javazoos.services;


import com.lambdaschool.javazoos.models.Zoo;
import com.lambdaschool.javazoos.repository.AnimalRepository;
import com.lambdaschool.javazoos.repository.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "zooService")
public class ZooServiceImpl implements ZooService{
    @Autowired
    private ZooRepository zooRepository;

    @Autowired
    private AnimalRepository animalRepository;

    public Zoo findZooById(long id) throws EntityNotFoundException
    {
        return zooRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Zoo id " + id + " Not Found"));
    }

    @Override
    public List<Zoo> findAll() {
        List<Zoo> list = new ArrayList<>();
        zooRepository.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }
}
