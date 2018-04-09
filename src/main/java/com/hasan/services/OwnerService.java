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
    public Owner getOwner(int theId) {
        return ownerRepository.getOwner(theId);
    }


//    @Override
    @Transactional
    public void deleteOwner(int theId) {

    }
}
