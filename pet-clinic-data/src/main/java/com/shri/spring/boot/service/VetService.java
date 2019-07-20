package com.shri.spring.boot.service;

import com.shri.spring.boot.model.Owner;
import com.shri.spring.boot.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);
    Vet save(Owner owner);
    Set<Vet> findAll();
}
