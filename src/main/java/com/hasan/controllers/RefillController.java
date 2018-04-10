package com.hasan.controllers;

import com.hasan.models.Refill;
import com.hasan.services.RefillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/refills")
public class RefillController {

    @Autowired
    private RefillService refillService;

    @GetMapping("")
    public List<Refill> listRefills(){
        // get refills from the service
        List<Refill> refills = refillService.getRefills();
        return refills;
    }

    @PostMapping("")
    public Refill saveRefill(@RequestBody Refill refill){ return refillService.saveRefill(refill); }

    @GetMapping("/get")
    public Refill getRefill(@RequestParam(value="id") int id){
        System.out.println("Hit the get in refill");
        Refill refill = refillService.getRefill(id);
        return refill;
    }

    @PostMapping("{refillId}/addDistance")
    public Refill addDistance(@PathVariable int refillId, @RequestParam(value = "distanceId") int ditanceId){
        Refill refill = refillService.addDistance(refillId, ditanceId);

        return refill;
    }
}
