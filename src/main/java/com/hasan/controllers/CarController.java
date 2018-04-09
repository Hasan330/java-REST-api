package com.hasan.controllers;

import com.hasan.models.Car;
import com.hasan.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    // need to inject our car service
    @Autowired
    private CarService carService;


    @GetMapping("")
    public List<Car> listCars(){
        // get owners from the service
        List<Car> cars = carService.getCars();
        return cars;
    }

    @PostMapping("")
    public Car saveCar(@RequestBody Car car){
        System.out.println("Saving car with details ---> " + car);
        carService.saveCar(car);
        return car;
    }

    @GetMapping("/get")
    public Car getCar(@RequestParam(value="id") int id){
        System.out.println("Hit the get in Car");
        Car car = carService.getCar(id);
        return car;
    }

    @PostMapping("{carId}/addRefill")
    public Car addRefill(@RequestParam(value = "refillId") int refillId, @PathVariable int carId){
        Car car = carService.addRefill(carId, refillId);

        return car;
    }

}
