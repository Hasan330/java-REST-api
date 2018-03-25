package com.hasan;

import java.util.Calendar;

public class Car extends Vehicle{
    private int     doors;
    private String  model;
    private long    millage;
    private int     gears;
    private boolean isManual;
    private FuelConsumption fuelConsumption;


    public Car(){

    }

    public Car(String owner, String model, String engine, int year, String color, int doors, int gears, long millage, boolean isManual) {
        super(year, owner, engine, color);
        this.doors    = doors;
        this.millage  = millage;
        this.gears    = gears;
        this.isManual = isManual;
    }


    public void setModel(String model){
        String validModel = model.toLowerCase();
        if(validModel.equals("ibiza") || validModel.equals("leon")){
            this.model = model;
        } else {
            this.model = "Unknown";
        }
    }

    public String getModel(){
        return this.model;
    }

    public void setMillage(Long millage){
        this.millage = millage;
    }

    public Long getMillage(){
        return this.millage;
    }

    public void incrementMillage(int distance){
        this.millage += distance;
    }


    //Getter for fuel consumption
    public FuelConsumption getFuelConsumption() {
        return fuelConsumption;
    }

    //Adding the refuel method
    public void refuel(Calendar refuelDate, Long initialMillage, int cost, double litresFilled, int proposedDistance, int actualDistance){
        System.out.println("Refueling Vehicle with "+ cost + " Sheikels on " + refuelDate.getTime());
        this.fuelConsumption = new FuelConsumption(refuelDate, initialMillage, cost, litresFilled, proposedDistance, actualDistance);
    }

}
