package com.hasan;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collections;


public class Main {
    public static void main(String[] args){

        //Entity Manager Factory
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");

        Owner hasan = new Owner("Hasan", 24);
        Owner sawsan = new Owner("Sawsan", 22);

        Car seat = new com.hasan.Car();
        Car seatIbiza = new com.hasan.Car("Seat","Ibiza", "1.2 TSI", 2014, "Black", 4, 5, 83500L, true);
        Car porsche = new com.hasan.Car();

        hasan.setCars(Collections.singletonList(seatIbiza));

        seat.setModel("Ibiza");
        porsche.setModel("911");

        System.out.println("Seat initial millage is: " + seatIbiza.getMillage());
        System.out.println("Seat Ibiza owner ID is: " + seatIbiza.getOwnerId());
        System.out.println("Hasan's cars: " + hasan.getCars().get(0).getModel());


        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(seatIbiza);
        entityManager.persist(sawsan);
        entityManager.persist(hasan);
        entityManager.getTransaction().commit();

        entityManagerFactory.close();

    }
}
