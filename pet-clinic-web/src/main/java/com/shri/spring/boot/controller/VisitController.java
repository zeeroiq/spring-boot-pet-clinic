package com.shri.spring.boot.controller;

import com.shri.spring.boot.model.Pet;
import com.shri.spring.boot.model.Visit;
import com.shri.spring.boot.service.PetService;
import com.shri.spring.boot.service.VisitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * @Author: ZeeroIQ
 * @Date: 8/10/2019 6:29 PM
 */
@Controller
public class VisitController {

    private final VisitService visitService;
    private final PetService petService;


    public VisitController(VisitService visitService, PetService petService) {
        this.visitService = visitService;
        this.petService = petService;
    }


    @ModelAttribute("visit")
    public Visit loadPetWithVisit(@PathVariable("petId") Long petId, Model model) {
        Pet pet = petService.findById(petId);
        model.addAttribute("pet", pet);
        Visit visit = new Visit();
        pet.getVisits().add(visit);
        visit.setPet(pet);
        return visit;
    }

    @GetMapping("/owners/*/pets/{petId}/visits/new")
    public String initNewVisitForm(@PathVariable("petId") Long petId) {
        return "pet/createOrUpdateVisitForm";
    }

    @PostMapping("/owners/*/pets/{petId}/visits/new")
    public String processNewVisitForm(@Valid Visit visit, BindingResult result) {
        if(result.hasErrors()) {
            return "pet/createOrUpdateVisitForm";
        } else {
            visitService.save(visit);

            return "redirect:/owners/" + visit.getPet().getOwner().getId();
        }
    }
}
