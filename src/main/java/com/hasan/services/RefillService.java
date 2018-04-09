package com.hasan.services;

import com.hasan.models.Refill;
import com.hasan.repositories.RefillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RefillService {

    @Autowired
    private RefillRepository refillRepository;

    @Transactional
    public List<Refill> getRefills(){ return refillRepository.getRefills(); }

    @Transactional
    public Refill saveRefill(Refill refill){ return refillRepository.saveRefill(refill); }

    @Transactional
    public Refill getRefill(int id) {
        return refillRepository.getRefill(id);
    }
}
