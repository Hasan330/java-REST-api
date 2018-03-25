package com.hasan;

import java.util.Calendar;


public class Main {
    public static void main(String[] args){
        com.hasan.Car seat = new com.hasan.Car();
        com.hasan.Car seatIbiza = new com.hasan.Car("Hasan", "Ibiza", "1.2 TSI", 2014, "Black", 4, 5, 83500L, true);
        com.hasan.Car porsche = new com.hasan.Car();

        seat.setModel("Ibiza");
        porsche.setModel("911");

        System.out.println("Seat initial millage is: " + seatIbiza.getMillage());


        //Initial Refill
        Calendar refill = Calendar.getInstance();
        refill.set(2018, Calendar.MARCH, 11);
        seatIbiza.refuel(1, refill, 83500L, 240, 40, 480, 0);
        System.out.println("Car Millage on initial refill= "+ seatIbiza.getMillage());

        //Second Refill
        Calendar refill2 = Calendar.getInstance();
        refill2.set(2018, Calendar.MARCH, 23);
        seatIbiza.refuel(2, refill2, 83980L, 245, 40, 500, 483);
        System.out.println("Car Millage on second refill= "+ seatIbiza.getMillage() + "\n");

        seatIbiza.getFuelConsumptionArrayList().forEach(x -> System.out.println("Refill ID= "+ x.getId() + " Cost= " +  x.getCost()));;

    }
}
