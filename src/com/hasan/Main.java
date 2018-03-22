package com.hasan;

public class Main {
    public static void main(String[] args){
        Car seat = new Car();
        Car porsche = new Car();


        seat.setModel("Ibiza");
        porsche.setModel("911");

        System.out.println("Seat model is " + seat.getModel());
        System.out.println("Porsche model is " + porsche.getModel());

        seat.setMillage(83500L);
        System.out.println("Seat millage is: " + seat.getMillage());

        seat.incrementMillage(480);
        System.out.println("Seat millage is: " + seat.getMillage());

    }
}
