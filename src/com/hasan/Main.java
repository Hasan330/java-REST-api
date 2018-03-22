package com.hasan;

public class Main {
    public static void main(String[] args){
        Car seat = new Car();
        Car seatIbiza = new Car("Hasan", "Ibiza", 2014, "1.2 TSI", "Black", 83500L);

        Car porsche = new Car();


        seat.setModel("Ibiza");
        porsche.setModel("911");

        System.out.println("Seat model is " + seatIbiza.getModel());
        System.out.println("Porsche model is " + porsche.getModel());

        System.out.println("Seat millage is: " + seatIbiza.getMillage());

        seatIbiza.incrementMillage(480);
        System.out.println("Seat millage is: " + seatIbiza.getMillage());

    }
}
