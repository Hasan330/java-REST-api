package com.hasan.services;

import com.hasan.models.Owner;
import com.hasan.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;


    @Override
    @Transactional
    public List<Owner> getOwners() {
        return ownerRepository.getOwners();
    }

    @Override
    @Transactional
    public void saveOwner(Owner theOwner) {

    }

    @Override
    @Transactional
    public Owner getOwner(int theId) {
        return null;
    }

    @Override
    @Transactional
    public void deleteOwner(int theId) {

    }





}
