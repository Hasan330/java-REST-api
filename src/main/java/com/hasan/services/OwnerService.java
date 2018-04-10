package com.hasan.services;

import com.hasan.models.Car;
import com.hasan.models.Owner;
import com.hasan.repositories.CarRepository;
import com.hasan.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private CarRepository carRepository;


//    @Override
    @Transactional
    public List<Owner> getOwners() {
        return ownerRepository.getOwners();
    }


    @Transactional
    public Owner getOwner(int id) {
        return ownerRepository.getOwner(id);
    }


    //    @Override
    @Transactional
    public Owner saveOwner(Owner theOwner) {
        return ownerRepository.saveOwner(theOwner);
    }


//    @Override
    @Transactional
    public Owner addCar(int ownerId, int carId){

        Car car = carRepository.getCar(carId);
        Owner owner = ownerRepository.getOwner(ownerId);
        owner.addCar(car);

        System.out.println("Adding car " + car + " to owner " + ownerId);

        return ownerRepository.updateOwner(owner);
    }

//    @Override
    @Transactional
    public void deleteOwner(int id) {

    }

    @Transactional
    public String getTotalPayment(int id){
        Owner owner = ownerRepository.getOwner(id);

        List<Car> cars = owner.getCars();

        //Add all payments from those cars
        int totalUserPayment = 0;
        for(int i=0; i < cars.size(); i++){
            totalUserPayment += cars.get(i).getTotalCost();
        }

        //Print Outcome
//        System.out.println("\nTotal money paid by " + owner.getName() + " on all cars is: " + totalUserPayment + "\n");
        return "\nTotal money paid by " + owner.getName() + " on all cars is: " + totalUserPayment + "\n";
    }
}
