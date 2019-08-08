package com.shri.spring.boot.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = "pets")
@Entity
public class Owner extends Persons {


    @Builder
    public Owner(Long id, String firstName, String lastName, String address, String city, String contact, Set<Pet> pets) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.contact = contact;
        this.pets = pets;
    }

    public Owner(){}

    private String address;
    private String city;
    private String contact;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();
}
