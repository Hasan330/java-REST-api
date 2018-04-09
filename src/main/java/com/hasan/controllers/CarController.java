package com.hasan.controllers;

import com.hasan.models.Car;
import com.hasan.models.Owner;
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
