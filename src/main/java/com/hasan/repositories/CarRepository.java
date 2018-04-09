package com.hasan.repositories;

import com.hasan.models.Car;

import java.util.List;

public interface CarRepository {

    public List<Car> getCars();

    public Car saveCar(Car car);

    public Car getCar(int id);

    public void deleteCar(int id);
}
