package com.hasan.services;

import com.hasan.models.Owner;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {


    @Override
    @Transactional
    public List<Owner> getOwners() {
//        return own.getCustomers();
        return null;
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
