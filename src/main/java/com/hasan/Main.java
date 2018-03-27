package com.hasan;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Main {
    public static void main(String[] args){

        //Entity Manager Factory
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");

        Owner hasan = new Owner("Hasan", 24);
        Owner sawsan = new Owner("Sawsan", 22);

        Car seat = new com.hasan.Car();
        Car seatIbiza = new com.hasan.Car("Seat","Ibiza", "1.2 TSI", 2014, "Black", 4, 5, 83500L, true);
        Car passat = new Car("VolksWagon", "Passat", "2.0", 2008, "Silver", 4, 6, 120000L, false);
        Car porsche = new com.hasan.Car("Porsche", "911", "2.6 Turbo", 2015, "Black", 2, 6, 20000L, false);

        hasan.addCar(passat);
        hasan.addCar(seatIbiza);

        sawsan.addCar(porsche);

        seat.setModel("Ibiza");
        porsche.setModel("911");

        System.out.println("Seat initial millage is: " + seatIbiza.getMillage());
        System.out.println("Seat Ibiza owner ID is: " + seatIbiza.getOwnerId());


        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(seatIbiza);
        entityManager.persist(passat);
        entityManager.persist(porsche);

        entityManager.persist(sawsan);
        entityManager.persist(hasan);

        entityManager.getTransaction().commit();

        hasan.printCars();
        sawsan.printCars();

        entityManagerFactory.close();

    }
}
