package com.hasan.controllers;

import com.hasan.models.Owner;
import com.hasan.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    // need to inject our customer service
    @Autowired
    private OwnerService ownerService;


    @GetMapping("")
    public List<Owner> listOwners(){
        // get owners from the service
        List<Owner> owners = ownerService.getOwners();
        return owners;
    }


    @GetMapping("/get")
    public Owner getOwner(@RequestParam(value="id", defaultValue="2") int id){
        System.out.println("Hit the get in owner");
        Owner owner = ownerService.getOwner(id);
        return owner;
    }

    @PostMapping("")
    public Owner saveOwner(@RequestBody Owner owner){
        System.out.println("Saving owner with details ---> " + owner);
        ownerService.saveOwner(owner);
        return owner;
    }
}