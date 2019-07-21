package com.shri.spring.boot.bootstrap;
/**
 *
 * @Authon: ZeeroIQ
 * @Date: 7/21/2019 11:35 AM
 */

import com.shri.spring.boot.model.Owner;
import com.shri.spring.boot.model.Vet;
import com.shri.spring.boot.service.OwnerService;
import com.shri.spring.boot.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Shri");
        owner1.setLastName("Smith");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Vin");
        owner2.setLastName("Smith");
        ownerService.save(owner2);
        System.out.println("Owners are loaded..");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Shruti");
        vet1.setLastName("Sane");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Alexandera");
        vet2.setLastName("Dadd");
        vetService.save(vet2);
        System.out.println("Vets are loaded..");

    }
}
