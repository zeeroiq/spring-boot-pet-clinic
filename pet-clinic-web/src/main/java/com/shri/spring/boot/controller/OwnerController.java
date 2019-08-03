package com.shri.spring.boot.controller;

import com.shri.spring.boot.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/", "index", "index.html"})
    public String index(Model model) {
        model.addAttribute("owners", ownerService.findAll());
        return "owner/index";
    }

    @RequestMapping({"/find", "/find.html"})
    public String find() {
        return "implementationNeeded";
    }

    @RequestMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId) {
        return new ModelAndView("owners/ownerDetails")
                .addObject(ownerService.findById(ownerId));
    }
}
