package com.shri.spring.boot.controller;

import com.shri.spring.boot.model.Owner;
import com.shri.spring.boot.service.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: ZeeroIQ
 * @Date: 7/31/2019 9:50 PM
 */
public class OwnerControllerTest {

    @Mock
    OwnerService ownerService;

    @InjectMocks
    OwnerController ownerController;

    Set<Owner> owners;
    MockMvc mockMvc;
    @BeforeEach
    void setup() {
        owners = new HashSet<>();
        owners.add(Owner.builder().id(1l).build());
        owners.add(Owner.builder().id(2l).build());

//        mockMvc = MockMvcBuilder.standaloneSetup(ownerController).build();
    }

    @Test
    public void index() {
    }

    @Test
    public void find() {
    }

    @Test
    public void showOwner() {
    }
}