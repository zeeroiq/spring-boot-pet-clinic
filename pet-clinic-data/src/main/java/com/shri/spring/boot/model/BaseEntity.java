package com.shri.spring.boot.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseEntity implements Serializable {

    private Long Id;
}
