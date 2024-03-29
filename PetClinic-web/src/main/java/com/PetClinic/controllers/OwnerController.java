package com.PetClinic.controllers;

import com.PetClinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }


    @RequestMapping({"","/","/owner", "/owner/index.hmtl"})
    public String listOwner(Model model){

        model.addAttribute("owners", ownerService.findAll());
        return "owner/index";
    }

    @RequestMapping("/find")
    public String findOwners(){

        return "notImplemented";
    }
}
