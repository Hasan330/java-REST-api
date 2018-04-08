package com.hasan.controllers;

import com.hasan.models.Owner;
import com.hasan.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/owner")
public class OwnerController {

    // need to inject our customer service
    @Autowired
    private OwnerService ownerService;


    @GetMapping("/list")
    public List<Owner> listOwners(){
        // get owners from the service
        List<Owner> theOwner = ownerService.getOwners();
        return theOwner;
    }

    @RequestMapping("/owner")
    public String test(@RequestParam(value="name", defaultValue="testOwner") String name){
        Owner user = new Owner(name, 22);
        return "Owner 1 " + user.getName() + " " +  user.getAge();
    }
}