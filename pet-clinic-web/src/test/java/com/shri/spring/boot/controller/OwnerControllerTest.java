package com.shri.spring.boot.controller;

import com.shri.spring.boot.model.Owner;
import com.shri.spring.boot.service.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @Author: ZeeroIQ
 * @Date: 7/31/2019 9:50 PM
 */
@ExtendWith(MockitoExtension.class)
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
//        owners.add(Owner.builder().id(2l).build());
        mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
    }

    @Test
    public void index() throws Exception{
        when(ownerService.findAll()).thenReturn(owners);
        mockMvc.perform(get("/owners"))
               .andExpect(status().isOk())
               .andExpect(view().name("owner/index"))
               .andExpect(model().attribute("owners", hasSize(1)));
    }

    @Test
    public void listOwnerByindex() throws Exception{
        when(ownerService.findAll()).thenReturn(owners);
        mockMvc.perform(get("/owners/index"))
               .andExpect(status().isOk())
               .andExpect(view().name("owner/index"))
               .andExpect(model().attribute("owners", hasSize(1)));
    }

    @Test
    public void find() throws Exception {
        mockMvc.perform(get("/owners/find"))
               .andExpect(status().isOk())
               .andExpect(view().name("implementationNeeded"));
    }

    @Test
    public void showOwner() {
    }
}