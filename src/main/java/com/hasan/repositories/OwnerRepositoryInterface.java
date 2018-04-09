package com.hasan.repositories;

import com.hasan.models.Owner;

import java.util.List;

public interface OwnerRepositoryInterface {
    public List<Owner> getOwners();

    public Owner saveOwner(Owner theOwner);

    public Owner getOwner(int theId);

    public void deleteOwner(int theId);

    public Owner updateOwner(Owner owner);

}
