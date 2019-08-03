package com.shri.spring.boot.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

/**
 * @Authon: ZeeroIQ
 * @Date: 7/21/2019
 */
@Data
@Entity
public class Visit extends BaseEntity {

    private LocalDate date;
    private String description;

    // TODO : it is not needed to specify the cascade type here, but without this it shows error
    // check for this later on
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "pet_id")
    private Pet pet;

}
