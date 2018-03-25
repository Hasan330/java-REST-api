package com.hasan;

import java.util.Calendar;

//Create vehicle as abstract class
public abstract class Vehicle {
    private int year;

    private String owner;
    private String engine;
    private String color;
    private FuelConsumption fuelConsumption;

    public Vehicle(){

    }

    public Vehicle(int year, String owner, String engine, String color) {
        this.year = year;
        this.owner = owner;
        this.engine = engine;
        this.color = color;
    }

    public void move(){
        System.out.println("Called move method");

    }

    public void refuel(Calendar refuelDate, Long initialMillage, int cost, double litresFilled, int proposedDistance, int actualDistance){
        this.fuelConsumption = new FuelConsumption(refuelDate, initialMillage, cost, litresFilled, proposedDistance, actualDistance);
    }

    public int getYear() {
        return year;
    }

    public String getOwner() {
        return owner;
    }


    public String getEngine() {
        return engine;
    }

    public String getColor() {
        return color;
    }
}
