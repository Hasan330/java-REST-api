package com.hasan.services;

import com.hasan.models.Owner;

import java.util.List;

public interface OwnerService {

    public List<Owner> getOwners();

    public Owner saveOwner(Owner theOwner);

    public Owner getOwner(int theId);

    public void deleteOwner(int theId);

    public Owner addCar(int ownerId, int carId);

}
