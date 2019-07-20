package com.shri.spring.boot.model;

import lombok.Data;

@Data
public class Persons extends BaseEntity{

    private String firstName;
    private String lastName;
}
