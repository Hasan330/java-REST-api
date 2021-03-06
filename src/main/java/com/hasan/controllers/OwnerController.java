package com.hasan.controllers;

import com.hasan.models.Owner;
import com.hasan.services.CarService;
import com.hasan.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    // need to inject our owner service
    @Autowired
    private OwnerService ownerService;

    @Autowired
    private CarService carService;


    @GetMapping("")
    public List<Owner> listOwners(){
        // get owners from the service
        List<Owner> owners = ownerService.getOwners();
        return owners;
    }

    @PostMapping("")
    public Owner saveOwner(@RequestBody(required=false) Owner owner){

        //Fallback to Lambda function if owner is not sent in request body
        if(owner ==null){
            System.out.println("No owner sent in creation body --> Hitting lambda owner creating function to generate random owner");
            RestTemplate restTemplate = new RestTemplate();
            String lambdaURL = "https://qhc7ac9d7c.execute-api.us-east-1.amazonaws.com/development/sampleFunction";
            owner = restTemplate.getForObject(lambdaURL, Owner.class);
        }

        System.out.println("Saving owner with details ---> " + owner);
        ownerService.saveOwner(owner);
        return owner;
    }



    //TODO: Check which of the below implementations is better (Path variable vs Request param)
    @GetMapping("/get/{id}")
    public Owner getOwnerById(@PathVariable int id){
        System.out.println("Hit the get in owner for owner with id " + id);
        Owner owner = ownerService.getOwner(id);
        return owner;
    }


    @GetMapping("/get")
    public Owner getOwner(@RequestParam(value="id") int id){
        System.out.println("Hit the get in owner");
        Owner owner = ownerService.getOwner(id);
        return owner;
    }


    @PostMapping("{ownerId}/addCar")
    public Owner addCar(@PathVariable int ownerId, @RequestParam(value = "carId") int carId){
        Owner owner = ownerService.addCar(ownerId, carId);

        return owner;
    }

    @GetMapping("{ownerId}/totalSpent")
    public String getTotalPayment(@PathVariable int ownerId){
        return ownerService.getTotalPayment(ownerId);
    }

    @GetMapping("{ownerId}/totalSpentOnCar")
    public String getCarTotalPayment(@PathVariable int ownerId, @RequestParam(value = "carId") int carId){
        return ownerService.getCarTotalPayment(ownerId, carId);
    }


    @GetMapping("{ownerId}/totalDistance")
    public String getTotalDistance(@PathVariable int ownerId){
        return ownerService.getTotalDistance(ownerId);
    }

}