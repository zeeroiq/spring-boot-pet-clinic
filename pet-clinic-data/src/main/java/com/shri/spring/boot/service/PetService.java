package com.shri.spring.boot.service;

import com.shri.spring.boot.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);
    Pet save(Pet owner);
    Set<Pet> findAll();

}
