package com.hasan.services;

import com.hasan.models.LongDistance;
import com.hasan.repositories.LongDistanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LongDistanceService {

    @Autowired
    LongDistanceRepository longDistanceRepository;

    @Transactional
    public List<LongDistance> getLongDistances() { return longDistanceRepository.getLongDistances(); }

    @Transactional
    public LongDistance saveLongDistance(LongDistance longDistance) { return longDistanceRepository.saveLongDistance(longDistance);}

    @Transactional
    public LongDistance getLongDistance(int id) {
        return longDistanceRepository.getLongDistance(id);
    }

    @Transactional
    public void deleteLongDistance(int id) {  }

    }