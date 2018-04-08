package com.hasan.repositories;

import com.hasan.models.Car;
import com.hasan.models.LongDistance;
import com.hasan.models.Owner;
import com.hasan.models.Refill;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OwnerRepositoryImpl implements OwnerRepository {

    // need to inject the session factory
//    @Autowired
//    private SessionFactory sessionFactory;

    //TODO: Make this autowired
    SessionFactory sessionFactory =
            new Configuration()
                    .configure()
                    .addAnnotatedClass(Owner.class)
                    .addAnnotatedClass(Car.class)
                    .addAnnotatedClass(Refill.class)
                    .addAnnotatedClass(LongDistance.class)
                    .buildSessionFactory();

    @Override
    public List<Owner> getOwners() {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        List<Owner> owners = currentSession.createQuery("from Owner order by name").getResultList();
        owners.forEach(owner -> System.out.println("Owner details " + owner.getName()));

        // return the results
        return owners;
    }

    @Override
    public void saveOwner(Owner theOwner) {

    }

    @Override
    public Owner getOwner(int theId) {
        return null;
    }

    @Override
    public void deleteOwner(int theId) {

    }
}
