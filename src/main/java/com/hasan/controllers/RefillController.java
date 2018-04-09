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
}
