package com.hasan.controllers;

import com.hasan.models.Distance;
import com.hasan.services.DistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/distances")
public class DistanceController {


    // need to inject our longDistance service
    @Autowired
    private DistanceService distanceService;

    @GetMapping("")
    public List<Distance> listLongDistances(){
        // get owners from the service
        List<Distance> distances = distanceService.getLongDistances();
        return distances;
    }

    @PostMapping("")
    public Distance saveLongDistance(@RequestBody Distance distance){
        System.out.println("Saving distance with details ---> " + distance);
        distanceService.saveLongDistance(distance);
        return distance;
    }

    @GetMapping("/get")
    public Distance getLongDistance(@RequestParam(value="id") int id){
        System.out.println("Hit the get in Distance");
        Distance distance = distanceService.getLongDistance(id);
        return distance;
    }


}
