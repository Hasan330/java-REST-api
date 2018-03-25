package com.hasan;

//Create vehicle as abstract class
public abstract class Vehicle {
    private int year;

    private String owner;
    private String engine;
    private String color;

    public Vehicle(){

    }

    public Vehicle(int year, String owner, String engine, String color) {
        this.year   = year;
        this.owner  = owner;
        this.engine = engine;
        this.color  = color;
    }

    public void move(){
        System.out.println("Called move method");

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
