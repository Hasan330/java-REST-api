package com.hasan.models;

//Create vehicle as abstract class
public abstract class Vehicle {
    private int year;

    private String engine;
    private String color;

    public Vehicle(){

    }

    public Vehicle(int year, String engine, String color) {
        this.year   = year;
        this.engine = engine;
        this.color  = color;
    }

    public void move(){
        System.out.println("Called move method");

    }

    public int getYear() {
        return year;
    }

    public String getEngine() {
        return engine;
    }

    public String getColor() {
        return color;
    }


}
