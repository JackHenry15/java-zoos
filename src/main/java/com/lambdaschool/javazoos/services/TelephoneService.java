package com.lambdaschool.javazoos.services;

import com.lambdaschool.javazoos.models.Telephone;

import java.util.List;

public interface TelephoneService {

    List<Telephone> findAll();

    Telephone findTelephoneById(long id);
}
