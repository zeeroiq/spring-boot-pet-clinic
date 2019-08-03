package com.shri.spring.boot.service.map;

import com.shri.spring.boot.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: ZeeroIQ
 * @Date: 8/3/2019 10:17 PM
 */
class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;
    final String lastName = "Kake";
    final Long ownerId = 1L;

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeMapService(), new PetServiceMap());
        ownerServiceMap.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerServiceMap.findAll();
        assertEquals(1, owners.size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerId);
        assertEquals(0,ownerServiceMap.findAll().size());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
        assertEquals(0,ownerServiceMap.findAll().size());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Owner owner = Owner.builder().id(id).build();
        Owner savedOwner = ownerServiceMap.save(owner);
        assertEquals(id, savedOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner owner = ownerServiceMap.save(Owner.builder().build());
        assertNotNull(owner);;
        assertNotNull(owner.getId());
    }
    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(ownerId);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void findByLastName() {
        Owner kake = ownerServiceMap.findByLastName(lastName);
        assertNotNull(kake);
        assertEquals(ownerId, kake.getId());
    }
    @Test
    void findByLastNameNotFound() {
        Owner kake = ownerServiceMap.findByLastName("Check");
        assertNull(kake);
    }
}