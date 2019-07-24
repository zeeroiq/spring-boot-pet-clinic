package com.shri.spring.boot.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Vet extends Persons {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_speciality",
            joinColumns = @JoinColumn(name = "vet_id"),
            inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> specialities = new HashSet<>();
}
