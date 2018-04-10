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
public class LongDistanceRepository {


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

    public List<LongDistance> getLongDistances() {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        Transaction tx = currentSession.beginTransaction();

        List<LongDistance> longDistances = currentSession.createQuery("from Longdistance").getResultList();
        longDistances.forEach(longDistance -> System.out.println("Long Distance details " + longDistance.getSource() + " " + longDistance.getDestination()));

        tx.commit();
        currentSession.close();

        // return the results
        return longDistances;
    }

    public LongDistance saveLongDistance(LongDistance longDistance) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        Transaction tx = currentSession.beginTransaction();

        currentSession.save(longDistance);
        currentSession.getTransaction().commit();
        currentSession.close();

        return longDistance;
    }

    public LongDistance getLongDistance(int id) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        Transaction tx = currentSession.beginTransaction();

        LongDistance longDistance = currentSession.get(LongDistance.class, id);
        System.out.println("getLongDistance function --> long distance details: " + longDistance );

        tx.commit();
        currentSession.close();

        return longDistance;
    }

    public void deleteLongDistance(int id) {

    }


    public LongDistance updateLongDistance(LongDistance longDistance){

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        Transaction tx = currentSession.beginTransaction();

        currentSession.update(longDistance);

        currentSession.getTransaction().commit();
        currentSession.close();

        return longDistance;
    }

}
