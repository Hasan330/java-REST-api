package com.hasan;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name= "cars")
public class Car extends Vehicle{

    @Id
    @Column(name = "car_id")
    @GeneratedValue(generator = "incrementator")
    @GenericGenerator(name = "incrementator", strategy = "increment" )
    private int             car_id;

    @Column(name = "model")
    private String          model;
    @Column(name = "doors")
    private int             doors;
    @Column(name = "millage")
    private long            millage;
    @Column(name = "gears")
    private int             gears;
    @Column(name = "isManual")
    private boolean         isManual;


    @Column(name = "CAR_OWNER_ID")
    private int ownerId;


    public Car(){

    }

    public Car(String owner, String model, String engine, int year, String color, int doors, int gears, long millage, boolean isManual) {
        super(year, owner, engine, color);
        this.model    = model;
        this.doors    = doors;
        this.millage  = millage;
        this.gears    = gears;
        this.isManual = isManual;
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
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

}
