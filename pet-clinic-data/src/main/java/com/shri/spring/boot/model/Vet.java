package com.shri.spring.boot.model;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Vet extends Persons {

    private Set<Speciality> specialities = new HashSet<>();
}
