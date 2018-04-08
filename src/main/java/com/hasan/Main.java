package com.hasan;

import com.hasan.models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args){
        SessionFactory factory =
                        new Configuration()
                        .configure()
                        .addAnnotatedClass(Owner.class)
                        .addAnnotatedClass(Car.class)
                        .addAnnotatedClass(Refill.class)
                        .addAnnotatedClass(LongDistance.class)
                        .buildSessionFactory();

        System.out.println("\n\n\t\t\t\t\t\t **** Starting Run ****\n");

        Owner hasan   = new Owner("Hasan", 24);
        Owner sawsan  = new Owner("Sawsan", 22);

        Car seatIbiza = new Car("Seat","Ibiza", "1.2 TSI", 2014, "Black", 4, 5, 83500L, true);
        Car passat    = new Car("VolksWagon", "Passat", "2.0", 2008, "Silver", 4, 6, 120000L, false);
        Car porsche   = new Car("Porsche", "911", "2.6 Turbo", 2015, "Black", 2, 6, 20000L, false);

        //Assign cars to users
        hasan.addCar(passat);
        hasan.addCar(seatIbiza);
        sawsan.addCar(porsche);

        //Instantiate Refills
        Refill initialRefill = new Refill(Helpers.createDate(11,3,2018), 83500L, 240, 38, 480, 0);
        Refill secondRefill  = new Refill(Helpers.createDate(24,3,2018), 83600L, 100, 14, 200, 190);
        Refill thirdRefill   = new Refill(Helpers.createDate(2,4,2018), 2600L, 450, 60, 600, 510);
        Refill fourthRefill  = new Refill(Helpers.createDate(4,4,2018), 5600L, 300, 17, 80, 100);

        //Assign refills to cars
        initialRefill.setCar(seatIbiza);
        secondRefill.setCar(seatIbiza);
        thirdRefill.setCar(passat);
        fourthRefill.setCar(porsche);

        //Instantiate long distances
        LongDistance tubasRamallah1 = new LongDistance("Tubas", "Ramallah", 85, Helpers.createDate(14,3,2018));

        //Assign longDistance to refill
        tubasRamallah1.setRefill(initialRefill);




        //            **** BUSINESS LOGIC: ****

        //Calculate total money paid on a certain car
        seatIbiza.printTotalCost();
        passat.printTotalCost();
        porsche.printTotalCost();

        //Calculate total money paid by a certain user
        hasan.printTotalPayment();
        sawsan.printTotalPayment();






        //           **** DATABASE STUFF ****

//        Persist data
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        session.save(hasan);
        session.save(sawsan);
        session.save(initialRefill);
        session.save(secondRefill);
        session.save(thirdRefill);
        session.save(fourthRefill);
        session.save(tubasRamallah1);
        session.save(seatIbiza);
        session.save(passat);
        session.save(porsche);



        //Print cars
        hasan.printCars();
        sawsan.printCars();

        Owner savedOwner = session.get(Owner.class, hasan.getId());
        System.out.println(savedOwner);
        Car result = session.get(Car.class, seatIbiza.getId());
        System.out.println("Ibiza car -->" + result);
        LongDistance distanceResult = session.get(LongDistance.class, tubasRamallah1.getId());
        System.out.println("Long distance -->" + distanceResult);


        //Querying cars
        List<Car> cars = session.createQuery("from Car c where"
                + " c.brand='Porsche' OR c.model='Ibiza'").getResultList();
        cars.forEach(car -> System.out.println("second time " + car.getModel() + " " + car.getId() +" --> " +car.getOwner()));


        //Updating car
        Car carToBeupdated = session.get(Car.class, 1);
        carToBeupdated.setModel("Carera Turbo");


        //Deleting a Car
//        Car carToBeDeleted = session.get(Car.class, 7);
//        session.delete(carToBeDeleted);


        System.out.println("\n\n\t\t\t\t\t\t **** Ending Run ****\n");

        //Commit to database
        session.getTransaction().commit();
        factory.close();
    }
}
