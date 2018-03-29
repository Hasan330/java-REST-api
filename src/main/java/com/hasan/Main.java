package com.hasan;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Main {
    public static void main(String[] args){
        //Entity Manager Factory
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        System.out.println("\n\n\t\t\t\t\t\t **** Starting Run ****\n");

        Owner hasan   = new Owner("Hasan", 24);
        Owner sawsan  = new Owner("Sawsan", 22);

        Car seatIbiza = new Car("Seat","Ibiza", "1.2 TSI", 2014, "Black", 4, 5, 83500L, true);
        Car passat    = new Car("VolksWagon", "Passat", "2.0", 2008, "Silver", 4, 6, 120000L, false);
        Car porsche   = new Car("Porsche", "911", "2.6 Turbo", 2015, "Black", 2, 6, 20000L, false);

        //Assign cars to users
        porsche.setOwner(sawsan);
        passat.setOwner(hasan);
        seatIbiza.setOwner(hasan);

        //Instantiate Refills
        FuelConsumption initialRefill = new FuelConsumption(Helpers.createDate(11,3,2018), 83500L, 240, 38, 480, 0);
        FuelConsumption secondRefill  = new FuelConsumption(Helpers.createDate(24,3,2018), 83600L, 250, 40, 500, 495);
        FuelConsumption thirdRefill   = new FuelConsumption(Helpers.createDate(2,4,2018), 2600L, 450, 60, 600, 510);
        FuelConsumption fourthRefill  = new FuelConsumption(Helpers.createDate(4,4,2018), 5600L, 40, 7, 80, 100);


//        Calendar refill = Calendar.getInstance();
//        refill.set(2018, Calendar.MARCH, 11);
//        FuelConsumption initialRefill = new FuelConsumption(refill, 83500L, 240, 38, 480, 0);
//        Calendar refill2 = Calendar.getInstance();
//        refill2.set(2018, Calendar.MARCH, 23);
//        FuelConsumption secondRefill = new FuelConsumption(refill2, 83600L, 250, 40, 500, 495);
//        Calendar refill3 = Calendar.getInstance();
//        refill3.set(2018, Calendar.MARCH, 25);
//        FuelConsumption thirdRefill = new FuelConsumption(refill3, 2600L, 450, 60, 600, 510);
//        Calendar refill4 = Calendar.getInstance();
//        refill4.set(2018, Calendar.APRIL, 30);
//        FuelConsumption fourthRefill = new FuelConsumption(refill4, 5600L, 40, 7, 80, 100);

        //Assign refills to cars
        initialRefill.setCar(seatIbiza);
        secondRefill.setCar(seatIbiza);
        thirdRefill.setCar(passat);
        fourthRefill.setCar(porsche);

        //Instantiate long distances
        LongDistance tubasRamallah1 = new LongDistance("Tubas", "Ramallah", 85, Helpers.createDate(14,3,2018));

        //Assign longDistance to refill
        tubasRamallah1.setFuelConsumption(initialRefill);







        //            **** BUSINESS LOGIC: ****

        //Calculate total money paid on a certain car
        seatIbiza.printTotalCost();
        passat.printTotalCost();
        porsche.printTotalCost();

        //Calculate total money paid by a certain user
        hasan.printTotalPayment();
        sawsan.printTotalPayment();






        //           **** DATABASE STUFF ****

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

        System.out.println("\n\n\t\t\t\t\t\t **** Ending Run ****\n");

        //Commit to database
        entityManager.getTransaction().commit();
        entityManagerFactory.close();
    }
}
