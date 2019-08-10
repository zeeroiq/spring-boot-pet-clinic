package com.shri.spring.boot.formatter;

/**
 * @Author: ZeeroIQ
 * @Date: 8/10/2019 6:10 PM
 */

import com.shri.spring.boot.model.PetType;
import com.shri.spring.boot.service.PetTypeService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

/**
 * Helper class to parse the objects while thymeleaf pet type selection
 *
 */

@Component
public class PetTypeFormatter implements Formatter<PetType> {

    private final PetTypeService petTypeService;

    public PetTypeFormatter(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public PetType parse(String text, Locale locale) throws ParseException {
        Collection<PetType> findPetTypes = petTypeService.findAll();

        for(PetType petType: findPetTypes) {
            if(petType.getName().equals(text)) {
                return petType;
            }
        }

        throw new ParseException("Type not found: " + text, 0);
    }

    @Override
    public String print(PetType petType, Locale locale) {
        return petType.getName();
    }
}
