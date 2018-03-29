package com.hasan;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "cars")
public class Car extends Vehicle{

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "incrementator")
    @GenericGenerator(name = "incrementator", strategy = "increment" )
    private int id;


    @Column(name = "brand")
    private String brand;
    @Column(name = "model")
    private String model;
    @Column(name = "doors")
    private int doors;
    @Column(name = "millage")
    private long millage;
    @Column(name = "gears")
    private int gears;
    @Column(name = "isManual")
    private boolean isManual;

    private int totalCost;


    @Column(name = "CAR_OWNER_ID")
    private int ownerId;

    @OneToMany
    @JoinColumn(name = "CAR_ID", referencedColumnName = "id")
    private List<FuelConsumption> fuelConsumption = new ArrayList<>();

    public Car(String brand, String model, String engine, int year, String color, int doors, int gears, long millage, boolean isManual) {
        super(year, engine, color);
        this.brand    = brand;
        this.model    = model;
        this.doors    = doors;
        this.millage  = millage;
        this.gears    = gears;
        this.isManual = isManual;
    }

    public int getId() {
        return id;
    }

    public void setId(int car_id) {
        this.id = car_id;
    }

    public void setModel(String model){
        this.model = model;
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

    public int getOwnerId() {
        return ownerId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<FuelConsumption> getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(List<FuelConsumption> fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void addFuelRefill(FuelConsumption fuelConsumption) {
        System.out.println("\n"+ this.getOwnerId() + " Added fuel refill for car " + this.getBrand() + " " +  this.getModel());
        System.out.println("Refill Cost for " + this.getBrand() + " " + this.getModel() + " is: " + fuelConsumption.getCost() + " ILS");
        this.fuelConsumption.add(fuelConsumption);
        this.totalCost +=  fuelConsumption.getCost();
    }

    public void printTotalCost(){
        System.out.println("\nTotal cost for "+ this.getBrand() + " " + this.getModel() + " is: " + this.totalCost);
    }

    public int getTotalCost(){
        return this.totalCost;
    }
}
