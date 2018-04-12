package com.hasan.services;

import com.hasan.models.Car;
import com.hasan.models.Refill;
import com.hasan.repositories.CarRepository;
import com.hasan.repositories.RefillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private RefillRepository refillRepository;

//    @Override
    @Transactional
    public List<Car> getCars() {
        return carRepository.getCars();
    }

//    @Override
    public Car saveCar(Car car) {
        return carRepository.saveCar(car);
    }

//    @Override
    public Car getCar(int id) {
        return carRepository.getCar(id);
    }

//    @Override
    public void deleteCar(int id) {

    }

    @Transactional
    public Car addRefill(int carId, int refillId){

        Refill refill = refillRepository.getRefill(refillId);
        Car car = carRepository.getCar(carId);
        car.addFuelRefill(refill);

        System.out.println("Adding refill " + refill + " to car " + car);

        return carRepository.updateCar(car);
    }

    public String getTotalDistance(int carId){
        Car car = carRepository.getCar(carId);

        List<Refill> refills = car.getRefills();

        int totalDistance = 0;
        for(Refill refill:refills){
            totalDistance += refill.getTotalDistance();
        }

        car.setTotalDistance(totalDistance);
        final Car updatedCar = carRepository.updateCar(car);

        return  "Total distance covered by: " + updatedCar.getBrand() + " " +   updatedCar.getModel() + " is: " + updatedCar.getTotalDistance() + " KM";
    }


}
