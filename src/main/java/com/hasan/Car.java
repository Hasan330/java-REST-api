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

    @ManyToOne
    private Owner owner;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Refill> refill = new ArrayList<>();

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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<Refill> getRefill() {
        return refill;
    }

    public void setRefill(List<Refill> refill) {
        this.refill = refill;
    }

    public void addFuelRefill(Refill refill) {
        System.out.println("\n"+ this.owner.getName() + " Added fuel refill for car " + this.getBrand() + " " +  this.getModel());
        System.out.println("Refill Cost for " + this.getBrand() + " " + this.getModel() + " is: " + refill.getCost() + " ILS");
        this.refill.add(refill);
        this.totalCost +=  refill.getCost();
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
        this.owner.addCar(this);
    }
}
