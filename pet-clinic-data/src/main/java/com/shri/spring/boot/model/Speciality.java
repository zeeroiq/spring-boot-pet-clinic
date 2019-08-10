package com.shri.spring.boot.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

/**
 * @Authon: ZeeroIQ
 * @Date: 7/21/2019
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Speciality extends BaseEntity {

    private String description;
}
