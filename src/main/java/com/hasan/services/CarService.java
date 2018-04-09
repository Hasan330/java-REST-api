package com.hasan.services;

import com.hasan.models.Car;
import com.hasan.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

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
}
