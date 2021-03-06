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
public class CarRepository {

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


//    @Override
    public List<Car> getCars() {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        Transaction tx = currentSession.beginTransaction();

        List<Car> cars = currentSession.createQuery("from Car").getResultList();
        cars.forEach(car -> System.out.println("Car details " + car.getModel() + " " + car.getId()));

        tx.commit();
        currentSession.close();

        // return the results
        return cars;
    }

    //    @Override
    public Car getCar(int id) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        Transaction tx = currentSession.beginTransaction();

//        Car car = currentSession.get(Car.class, id);
        Car car = (Car) currentSession.createQuery("from Car where id="+ id).getSingleResult();
        System.out.println("getCar function --> car details: " + car );

        currentSession.close();

        return car;
    }

//    @Override
    public Car saveCar(Car car) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        Transaction tx = currentSession.beginTransaction();

        currentSession.save(car);
        currentSession.getTransaction().commit();
        currentSession.close();

        return car;
    }


//    @Override
    public void deleteCar(int id) {

    }


    public Car updateCar(Car car){

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        Transaction tx = currentSession.beginTransaction();

        currentSession.update(car);

        currentSession.getTransaction().commit();
        currentSession.close();

        return car;
    }
}
