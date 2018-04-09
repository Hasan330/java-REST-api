package com.hasan.services;

import com.hasan.models.Car;

import java.util.List;

public interface CarService {

    public List<Car> getCars();

    public Car saveCar(Car car);

    public Car getCar(int id);

    public void deleteCar(int id);
}
