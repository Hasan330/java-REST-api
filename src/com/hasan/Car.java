package com.hasan;

import java.util.ArrayList;
import java.util.Calendar;

public class Car extends Vehicle{
    private int     doors;
    private String  model;
    private long    millage;
    private int     gears;
    private boolean isManual;
    private FuelConsumption lastFuelConsumption;

    //Adding an array-list for fuel consumption
    ArrayList<FuelConsumption> FuelConsumptionArrayList = new ArrayList<FuelConsumption>();


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
        // Only print that millage got incremented if distance was covered
        if(distance != 0){
            System.out.println("Incrementing car millage by: " + distance);
        }
        this.millage += distance;
    }

    //Getter for fuel consumption
    public FuelConsumption getLastFuelConsumption() {
        return lastFuelConsumption;
    }

    public ArrayList<FuelConsumption> getFuelConsumptionArrayList() {
        return FuelConsumptionArrayList;
    }

    //Adding the refuel method
    public void refuel(int id, Calendar refuelDate, Long initialMillage, int cost, double litresFilled, int proposedDistance, int actualDistance){
        System.out.println("\nTransaction id: " + id + " -> Refueling Vehicle with "+ cost + " Sheikels on " + refuelDate.getTime());
        this.lastFuelConsumption = new FuelConsumption(id, refuelDate, initialMillage, cost, litresFilled, proposedDistance, actualDistance);

        FuelConsumptionArrayList.add(lastFuelConsumption);

        //TODO: Use increment millage method as a part of method functionality to dynamically add to car millage when you refuel (optional)
        incrementMillage(actualDistance);
    }

}
