package com.shri.spring.boot.service.springdatajpa;

import com.shri.spring.boot.model.Owner;
import com.shri.spring.boot.repositories.OwnerRepository;
import com.shri.spring.boot.repositories.PetRepository;
import com.shri.spring.boot.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @Author: ZeeroIQ
 * @Date: 8/3/2019 11:59 PM
 */
@ExtendWith(MockitoExtension.class)
class OwnerSpringDataJpaServiceTest {

    private static final String LAST_NAME = "Kake";

    Owner owner;

    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSpringDataJpaService service;

    @BeforeEach
    void setUp() {
        owner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(owner);
        Owner kake = service.findByLastName(LAST_NAME);
        assertEquals(LAST_NAME, kake.getLastName());
        verify(ownerRepository).findByLastName(LAST_NAME);
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        owners.add(Owner.builder().id(1l).build());
//        owners.add(Owner.builder().id(2l).build());

        when(ownerRepository.findAll()).thenReturn(owners);

        Set<Owner> ownerSet = service.findAll();
        assertNotNull(ownerSet);
        assertEquals(1, ownerSet.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(owner));
        Owner owner1 = service.findById(1L);
        assertNotNull(owner1);
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner owner1 = service.findById(1l);
        assertNull(owner1);
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1L).build();
        when(ownerRepository.save(any())).thenReturn(owner);
        Owner savedOwner = service.save(ownerToSave);
        assertNotNull(savedOwner);
    }
    @Test
    void delete() {
        service.delete(owner);
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(ownerRepository).deleteById(anyLong());
    }

}