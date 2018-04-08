package com.hasan.controllers;

import com.hasan.models.Car;
import com.hasan.models.Owner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {


    @RequestMapping("/createCar")
    public Car createCar(@RequestParam(value="model", defaultValue="testCar") String model){
        Car seatIbiza = new Car("Seat", model, "1.2 TSI", 2014, "Black", 4, 5, 83500L, true);
        Owner Rami = new Owner("Rami", 25);
        return seatIbiza;
    }

    @RequestMapping("/carName")
    public String returnCarName(@RequestParam(value="model", defaultValue="testCar") String model){
        Car seatIbiza = new Car("Seat", model, "1.2 TSI", 2014, "Black", 4, 5, 83500L, true);
        Owner Rami = new Owner("Rami", 25);
        seatIbiza.setOwner(Rami);
        return "Car Details: " + seatIbiza.toString();
    }


}
