package com.shri.spring.boot.model;

import lombok.Data;

import java.time.LocalDate;

/**
 * @Authon: ZeeroIQ
 * @Date: 7/21/2019
 */
@Data
public class Visit extends BaseEntity {

    private LocalDate date;
    private String description;
    private Pet pet;

}
