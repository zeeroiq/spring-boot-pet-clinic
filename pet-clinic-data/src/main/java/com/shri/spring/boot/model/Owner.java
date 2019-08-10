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
        if(pets != null){
            this.pets = pets;
        }
    }

    public Owner(){}

    private String address;
    private String city;
    private String contact;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    public Pet getPet(String name, boolean ignoreNew) {
        name = name.toLowerCase();
        for(Pet pet: pets) {
            if(!ignoreNew || !pet.isNew()) {
                String compareName = pet.getName();
                compareName = compareName.toLowerCase();
                if(compareName.equals(name)) {
                    return pet;
                }
            }
        }
        return null;
    }

    public Pet getPet(String name) {
        return getPet(name, false);
    }
}
