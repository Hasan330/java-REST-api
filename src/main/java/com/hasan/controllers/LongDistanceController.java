package com.hasan.controllers;

import com.hasan.models.LongDistance;
import com.hasan.services.LongDistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/longdistances")
public class LongDistanceController {


    // need to inject our longDistance service
    @Autowired
    private LongDistanceService longDistanceService;

    @GetMapping("")
    public List<LongDistance> listLongDistances(){
        // get owners from the service
        List<LongDistance> longDistances = longDistanceService.getLongDistances();
        return longDistances;
    }

    @PostMapping("")
    public LongDistance saveLongDistance(@RequestBody LongDistance longDistance){
        System.out.println("Saving longDistance with details ---> " + longDistance);
        longDistanceService.saveLongDistance(longDistance);
        return longDistance;
    }

    @GetMapping("/get")
    public LongDistance getLongDistance(@RequestParam(value="id") int id){
        System.out.println("Hit the get in LongDistance");
        LongDistance longDistance = longDistanceService.getLongDistance(id);
        return longDistance;
    }


}
