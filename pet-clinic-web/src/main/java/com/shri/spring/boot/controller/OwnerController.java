package com.shri.spring.boot.controller;

import com.shri.spring.boot.model.Owner;
import com.shri.spring.boot.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private static final String VIEW_OWNER_CREATE_OR_UPDATE_FORM = "owner/createOrUpdateOwnerForm";
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    // if need to control the form post with more detail
    @InitBinder
    public void setAllowedFields(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("id");
    }


    @RequestMapping({"", "/", "index", "index.html"})
    public String index(Model model) {
        model.addAttribute("owners", ownerService.findAll());
        return "owner/index";
    }

    @RequestMapping({"/find", "/find.html"})
    public String find(Model model) {
        model.addAttribute("owner", Owner.builder().build());
        return "owner/findOwners";
    }

    @GetMapping
    public String processFindForm(Owner owner, BindingResult result, Model model) {
        if(owner.getLastName() == null) {
            owner.setLastName("");
        }

        List<Owner> res = ownerService.findAllByLastNameLike("%" + owner.getLastName() + "%");
        if(res.isEmpty()) {
            result.rejectValue("lastName", "not found", "not found");
            return "owner/findOwners";
        } else if(res.size() == 1) {
            owner = res.get(0);
            return "redirect:/owners/" + owner.getId();
        } else {
            model.addAttribute("owners", res);
            return "owner/ownersList";
        }

    }


    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId) {
        return new ModelAndView("owner/ownerDetails")
                .addObject(ownerService.findById(ownerId));
    }

    @GetMapping("/new")
    public String initCreationForm(Model model) {
        model.addAttribute("owner", Owner.builder().build());
        return VIEW_OWNER_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/new")
    public String processCreationForm(@Valid Owner owner, BindingResult result) {
        if(result.hasErrors()) {
            return VIEW_OWNER_CREATE_OR_UPDATE_FORM;
        } else {
            Owner ownerSaved = ownerService.save(owner);
            return "redirect:/owners/" + ownerSaved.getId();
        }
    }

    @GetMapping("/{ownerId}/edit")
    public String initUpdateForm(@PathVariable("ownerId") Long ownerId, Model model) {
        model.addAttribute(ownerService.findById(ownerId));
        return VIEW_OWNER_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/{ownerId}/edit")
    public String processUpdateOwnerForm(@Valid Owner owner,
                                         BindingResult result, @PathVariable("ownerId") Long ownerId) {

        if(result.hasErrors()) {
            return VIEW_OWNER_CREATE_OR_UPDATE_FORM;
        } else {
            owner.setId(ownerId);
            Owner savedOwner = ownerService.save(owner);
            return "redirect:/owners/" + savedOwner.getId();
        }
    }
}
