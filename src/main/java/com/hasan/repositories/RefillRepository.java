package com.hasan.repositories;

import com.hasan.models.Car;
import com.hasan.models.Distance;
import com.hasan.models.Owner;
import com.hasan.models.Refill;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RefillRepository {

    //TODO: Make this autowired
    SessionFactory sessionFactory =
            new Configuration()
                    .configure()
                    .addAnnotatedClass(Owner.class)
                    .addAnnotatedClass(Car.class)
                    .addAnnotatedClass(Refill.class)
                    .addAnnotatedClass(Distance.class)
                    .buildSessionFactory();



    public List<Refill> getRefills(){
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        Transaction tx = currentSession.beginTransaction();

        List<Refill> refills = currentSession.createQuery("from Refill").getResultList();
        refills.forEach(refill -> System.out.println("Refill details " + refill.getCost() + " " + refill.getId()));

        tx.commit();
        currentSession.close();

        // return the results
        return refills;
    }

    public Refill saveRefill(Refill refill) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        Transaction tx = currentSession.beginTransaction();

        currentSession.save(refill);
        currentSession.getTransaction().commit();
        currentSession.close();

        return refill;
    }

//    @Override
    public Refill getRefill(int id) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        Transaction tx = currentSession.beginTransaction();

        Refill refill = currentSession.get(Refill.class, id);
        System.out.println("getOwner function --> refill details: " + refill );

        currentSession.close();

        return refill;
    }

    public Refill updateRefill(Refill refill){

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        Transaction tx = currentSession.beginTransaction();

        currentSession.update(refill);

        currentSession.getTransaction().commit();
        currentSession.close();

        return refill;
    }
}
