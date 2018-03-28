package com.hasan;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Calendar;


public class Main {
    public static void main(String[] args){
        //Entity Manager Factory
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Owner hasan   = new Owner("Hasan", 24);
        Owner sawsan  = new Owner("Sawsan", 22);

        Car seatIbiza = new Car("Seat","Ibiza", "1.2 TSI", 2014, "Black", 4, 5, 83500L, true);
        Car passat    = new Car("VolksWagon", "Passat", "2.0", 2008, "Silver", 4, 6, 120000L, false);
        Car porsche   = new Car("Porsche", "911", "2.6 Turbo", 2015, "Black", 2, 6, 20000L, false);

        //Assign cars to users
        hasan.addCar(passat);
        hasan.addCar(seatIbiza);
        sawsan.addCar(porsche);

        //Refills
        Calendar refill = Calendar.getInstance();
        refill.set(2018, Calendar.MARCH, 11);
        FuelConsumption initialRefill = new FuelConsumption(refill, 83500L, 240, 38, 480, 0);
        Calendar refill2 = Calendar.getInstance();
        refill2.set(2018, Calendar.MARCH, 23);
        FuelConsumption secondRefill = new FuelConsumption(refill2, 83600L, 250, 40, 500, 495);
        Calendar refill3 = Calendar.getInstance();
        refill3.set(2018, Calendar.MARCH, 25);
        FuelConsumption thirdRefill = new FuelConsumption(refill3, 2600L, 450, 60, 600, 510);
        Calendar refill4 = Calendar.getInstance();
        refill4.set(2018, Calendar.APRIL, 30);
        FuelConsumption fourthRefill = new FuelConsumption(refill4, 5600L, 40, 7, 80, 100);

        //Assign refills to cars
        seatIbiza.addFuelConsumption(initialRefill);
        seatIbiza.addFuelConsumption(secondRefill);
        passat.addFuelConsumption(thirdRefill);
        porsche.addFuelConsumption(fourthRefill);

        //Add long distances
        Calendar tubasRamallahDate1 = Calendar.getInstance();
        tubasRamallahDate1.set(2018, Calendar.MARCH, 14);
        LongDistance tubasRamallah1 = new LongDistance("Tubas", "Ramallah", 85, tubasRamallahDate1);

        //Assign longDistance to refill
        initialRefill.addLongDistance(tubasRamallah1);

        //Persist data
        entityManager.persist(sawsan);
        entityManager.persist(hasan);
        entityManager.persist(initialRefill);
        entityManager.persist(secondRefill);
        entityManager.persist(thirdRefill);
        entityManager.persist(fourthRefill);
        entityManager.persist(tubasRamallah1);
        entityManager.persist(seatIbiza);
        entityManager.persist(passat);
        entityManager.persist(porsche);

        //Print cars
        hasan.printCars();
        sawsan.printCars();

        //Commit to database
        entityManager.getTransaction().commit();
        entityManagerFactory.close();
    }
}
