package com.shri.spring.boot.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Owner extends Persons {

    private String address;
    private String city;
    private String contact;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();
}
