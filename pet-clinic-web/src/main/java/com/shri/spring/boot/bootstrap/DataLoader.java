package com.shri.spring.boot.bootstrap;
/**
 *
 * @Authon: ZeeroIQ
 * @Date: 7/21/2019 11:35 AM
 */

import com.shri.spring.boot.model.*;
import com.shri.spring.boot.service.OwnerService;
import com.shri.spring.boot.service.PetTypeService;
import com.shri.spring.boot.service.SpecialityService;
import com.shri.spring.boot.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();

        if(count == 0){
            loadData();
        }
    }

    private void loadData() {
        // petTypes
        PetType dog = new PetType();
        dog.setName("Dog");
        petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        petTypeService.save(cat);
        System.out.println("Pets are loaded..");

        // speciality
        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        specialityService.save(dentistry);


        // owners
        Owner owner1 = new Owner();
        owner1.setFirstName("Shri");
        owner1.setLastName("Smith");
        owner1.setAddress("Ajnara homes 121");
        owner1.setCity("Noida");
        owner1.setContact("+91 9855333333");
        ownerService.save(owner1);
        // pets
        Pet shriPet = new Pet();
        shriPet.setPetType(dog);
        shriPet.setOwner(owner1);
        shriPet.setBirthDate(LocalDate.now());
        shriPet.setName("Tiger");
        owner1.getPets().add(shriPet);


        Owner owner2 = new Owner();
        owner2.setFirstName("Vin");
        owner2.setLastName("Smith");
        owner2.setAddress("#2/656");
        owner2.setCity("Varanasi");
        owner2.setContact("+91 9956767676");
        ownerService.save(owner2);
        // pets
        Pet VinPet = new Pet();
        VinPet.setPetType(cat);
        VinPet.setOwner(owner2);
        VinPet.setBirthDate(LocalDate.now());
        VinPet.setName("Billu");
        owner1.getPets().add(VinPet);

        System.out.println("Owners are loaded..");


        // vets
        Vet vet1 = new Vet();
        vet1.setFirstName("Shruti");
        vet1.setLastName("Sane");
        vet1.getSpecialities().add(radiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Alexandera");
        vet2.setLastName("Dadd");
        vet2.getSpecialities().add(surgery);
        vetService.save(vet2);

        System.out.println("Vets are loaded..");
    }
}
