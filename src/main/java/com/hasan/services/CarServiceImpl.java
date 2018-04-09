package com.hasan.services;

import com.hasan.models.Car;
import com.hasan.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    @Transactional
    public List<Car> getCars() {
        return carRepository.getCars();
    }

    @Override
    public Car saveCar(Car car) {
        return null;
    }

    @Override
    public Car getCar(int id) {
        return null;
    }

    @Override
    public void deleteCar(int id) {

    }
}
