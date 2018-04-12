package com.hasan.services;

import com.hasan.models.Car;
import com.hasan.models.Distance;
import com.hasan.models.Refill;
import com.hasan.repositories.CarRepository;
import com.hasan.repositories.DistanceRepository;
import com.hasan.repositories.RefillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RefillService {

    @Autowired
    private RefillRepository refillRepository;

    @Autowired
    private DistanceRepository distanceRepository;

    @Autowired
    private CarRepository carRepository;

    @Transactional
    public List<Refill> getRefills(){ return refillRepository.getRefills(); }

    @Transactional
    public Refill saveRefill(Refill refill){ return refillRepository.saveRefill(refill); }

    @Transactional
    public Refill getRefill(int id) {
        return refillRepository.getRefill(id);
    }

    @Transactional
    public Refill addDistance(int refillId, int distanceId){

        Distance distance = distanceRepository.getLongDistance(distanceId);
        Refill refill = refillRepository.getRefill(refillId);
        refill.addDistance(distance);


        //Add distance to car distances
        Car car = distance.getRefill().getCar();
        car.addTotalDistance(distance.getDistance());

        System.out.println("Adding distance " + distance + " to refill " + refillId);

        carRepository.updateCar(car);
        return refillRepository.updateRefill(refill);
    }
}
