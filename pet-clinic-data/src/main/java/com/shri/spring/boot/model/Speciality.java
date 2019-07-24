package com.shri.spring.boot.model;

import lombok.Data;

import javax.persistence.Entity;

/**
 * @Authon: ZeeroIQ
 * @Date: 7/21/2019
 */
@Data
@Entity
public class Speciality extends BaseEntity {

    private String description;
}
