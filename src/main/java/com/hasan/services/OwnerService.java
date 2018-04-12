package com.hasan.services;

import com.hasan.models.Car;
import com.hasan.models.Owner;
import com.hasan.models.Refill;
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
        return "\nTotal money paid by " + owner.getName() + " on all cars is: " + totalUserPayment + "\n";
    }

   @Transactional
   public String getCarTotalPayment(int ownerId, int carId){

       //Make sure car belongs to said user
      Owner owner = ownerRepository.getOwner(ownerId);
      List<Car> ownerCars = owner.getCars();

      boolean correctAccess = false;
      for(Car ownerCar:ownerCars){
          System.out.println("Car id:" + ownerCar.getId());
          if(ownerCar.getId() == carId){
              correctAccess = true;
          }
      }

      //Get total payment on car if user has access grants
       if(correctAccess == true){
           Car car = carRepository.getCar(carId);
           List<Refill> refills = car.getRefills();

           int totalCarPayment = 0;
           for(Refill refill:refills){
               totalCarPayment += refill.getCost();
           }
           return "Total money spent by user on car is " + totalCarPayment;

       }
       else {
          return "User has no rights to access this car";
       }
   }

   @Transactional
    public String getTotalDistance(int ownerId){
       Owner owner = ownerRepository.getOwner(ownerId);
       List<Car> cars = owner.getCars();

       //Add all distances from those cars
       int totalDistance = 0;
       for(int i=0; i < cars.size(); i++){
           totalDistance += cars.get(i).getTotalDistance();
       }
       return "\nTotal distance convered by " + owner.getName() + " using all cars is: " + totalDistance + "\n";
   }


}
