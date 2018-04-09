package com.hasan.repositories;

import com.hasan.models.Car;
import com.hasan.models.LongDistance;
import com.hasan.models.Owner;
import com.hasan.models.Refill;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OwnerRepositoryImpl {

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

//    @Override
    public List<Owner> getOwners() {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        Transaction tx = currentSession.beginTransaction();

        List<Owner> owners = currentSession.createQuery("from Owner").getResultList();
        owners.forEach(owner -> System.out.println("Owner details " + owner.getName() + " " + owner.getId()));

        tx.commit();
        currentSession.close();

        // return the results
        return owners;
    }

//    @Override
    public Owner saveOwner(Owner theOwner) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        Transaction tx = currentSession.beginTransaction();

        currentSession.save(theOwner);
        currentSession.getTransaction().commit();
        currentSession.close();

        return theOwner;
    }

//    @Override
    public Owner getOwner(int theId) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        Transaction tx = currentSession.beginTransaction();

        Owner owner = currentSession.get(Owner.class, theId);
        System.out.println("getOwner function --> owner details: " + owner );

        tx.commit();
        currentSession.close();

        return owner;
    }

    public Owner updateOwner(Owner owner){

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        Transaction tx = currentSession.beginTransaction();

        currentSession.update(owner);

        currentSession.getTransaction().commit();
        currentSession.close();




        return owner;
    }

//    @Override
    public void deleteOwner(int theId) {

    }
}
