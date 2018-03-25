package com.hasan;

import java.util.Calendar;


public class Main {
    public static void main(String[] args){
        Car seat = new Car();
        Car seatIbiza = new Car("Hasan", "Ibiza", "1.2 TSI", 2014, "Black", 4, 5, 83500L, true);

        Car porsche = new Car();

        seat.setModel("Ibiza");
        porsche.setModel("911");

        System.out.println("Seat model is " + seatIbiza.getModel());
        System.out.println("Porsche model is " + porsche.getModel());

        System.out.println("Seat millage is: " + seatIbiza.getMillage());

        seatIbiza.incrementMillage(480);
        System.out.println("Seat millage is: " + seatIbiza.getMillage());


        //Initial Refill
        Calendar refill = Calendar.getInstance();
        refill.set(2018, Calendar.MARCH, 11);
        System.out.println("Calendar Date: "+ refill.getTime());
        seatIbiza.refuel(1, refill, 83500L, 240, 40, 480, 0);
//        System.out.println("Last Refuel Cost: "+ seatIbiza.getLastFuelConsumption().getCost());

        //Second Refill
        Calendar refill2 = Calendar.getInstance();
        refill2.set(2018, Calendar.MARCH, 23);
        System.out.println("Calendar Date: "+ refill2.getTime());
        seatIbiza.refuel(2, refill2, 83980L, 245, 40, 500, 483);
//        System.out.println("Last Refuel Cost: "+ seatIbiza.getLastFuelConsumption().getCost());

        seatIbiza.getFuelConsumptionArrayList().forEach(x -> System.out.println("ID= "+ x.getId() + " Cost= " +  x.getCost()));;

    }
}
