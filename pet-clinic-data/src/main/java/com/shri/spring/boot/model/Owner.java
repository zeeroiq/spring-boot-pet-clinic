package com.shri.spring.boot.model;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Owner extends Persons {

    private String address;
    private String city;
    private String contact;
    private Set<Pet> pets = new HashSet<>();
}
