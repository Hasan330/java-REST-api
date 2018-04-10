package com.hasan.services;

import com.hasan.models.Distance;
import com.hasan.repositories.DistanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DistanceService {

    @Autowired
    DistanceRepository distanceRepository;

    @Transactional
    public List<Distance> getLongDistances() { return distanceRepository.getLongDistances(); }

    @Transactional
    public Distance saveLongDistance(Distance distance) { return distanceRepository.saveLongDistance(distance);}

    @Transactional
    public Distance getLongDistance(int id) {
        return distanceRepository.getLongDistance(id);
    }

    @Transactional
    public void deleteLongDistance(int id) {  }

    }