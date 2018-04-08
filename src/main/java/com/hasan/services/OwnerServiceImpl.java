package com.hasan.services;

import com.hasan.models.Owner;

import java.util.List;

public interface OwnerServiceImpl {

    public List<Owner> getOwners();

    public void saveOwner(Owner theOwner);

    public Owner getOwner(int theId);

    public void deleteOwner(int theId);

}
