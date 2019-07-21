package com.shri.spring.boot.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Pet extends BaseEntity{

    private String name;
    private PetType petType;
    private Owner owner;
    private LocalDate birthDate;

}
