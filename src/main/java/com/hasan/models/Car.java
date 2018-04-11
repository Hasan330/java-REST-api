package com.hasan.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
//    @Column(name= "totalDistance")
    private  int totalDistance;

    private int totalCost;


    @ManyToOne
    @JsonIgnore
//    @JsonBackReference
    private Owner owner;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Refill> refills = new ArrayList<>();

    public Car(){

    }

    public Car(String brand, String model, String engine, int year, String color, int doors, int gears, long millage, boolean isManual) {
        super(year, engine, color);
        this.brand    = brand;
        this.model    = model;
        this.doors    = doors;
        this.millage  = millage;
        this.gears    = gears;
        this.isManual = isManual;
//        this.totalDistance = 0;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<Refill> getRefills() {
        return refills;
    }

    public void setRefills(List<Refill> refills) {
        this.refills = refills;
    }

    public void addFuelRefill(Refill refill) {
        System.out.println("\n"+ this.owner.getName() + " Added fuel refills for car " + this.getBrand() + " " +  this.getModel());
        System.out.println("Refill Cost for " + this.getBrand() + " " + this.getModel() + " is: " + refill.getCost() + " ILS");
        this.totalCost +=  refill.getCost();

        this.addTotalDistance(refill.getTotalDistance());

        refill.setCar(this);
        this.refills.add(refill);
    }

    public void printTotalCost(){
        System.out.println("Total cost for "+ this.getBrand() + " " + this.getModel() + " is: " + this.totalCost);
    }

    public int getTotalCost(){
        return this.totalCost;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
//        this.owner.addCar(this);
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public void addTotalDistance(int currentDistance) {
        System.out.println("Adding to totalDistance field in Car object "+ totalDistance);
        this.totalDistance += currentDistance;
        System.out.println("Car totalDistance after adding " + currentDistance + "KM is " + this.totalDistance);
    }



    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", doors=" + doors +
                ", millage=" + millage +
                ", gears=" + gears +
                ", isManual=" + isManual +
                ", totalCost=" + totalCost +
//                ", owner=" + owner.getName() +
                '}';
    }
}
