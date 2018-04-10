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
public class DistanceRepository {


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
                    .addAnnotatedClass(Distance.class)
                    .buildSessionFactory();

    public List<Distance> getLongDistances() {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        Transaction tx = currentSession.beginTransaction();

        List<Distance> distances = currentSession.createQuery("from Distance").getResultList();
        distances.forEach(longDistance -> System.out.println("Long Distance details " + longDistance.getSource() + " " + longDistance.getDestination()));

        tx.commit();
        currentSession.close();

        // return the results
        return distances;
    }

    public Distance saveLongDistance(Distance distance) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        Transaction tx = currentSession.beginTransaction();

        currentSession.save(distance);
        currentSession.getTransaction().commit();
        currentSession.close();

        return distance;
    }

    public Distance getLongDistance(int id) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        Transaction tx = currentSession.beginTransaction();

        Distance distance = currentSession.get(Distance.class, id);
        System.out.println("getLongDistance function --> long distance details: " + distance);

        tx.commit();
        currentSession.close();

        return distance;
    }

    public void deleteLongDistance(int id) {

    }


    public Distance updateLongDistance(Distance distance){

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        Transaction tx = currentSession.beginTransaction();

        currentSession.update(distance);

        currentSession.getTransaction().commit();
        currentSession.close();

        return distance;
    }

}
