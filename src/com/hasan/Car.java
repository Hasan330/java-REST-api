package com.hasan;

public class Car {
    private long millage;
    private int year;

    private String owner;
    private String model;
    private String engine;
    private String color;

    public Car(){

    }

    public Car(String owner, String model, int year, String engine, String color, long millage) {
        this.millage = millage;
        this.year = year;
        this.owner = owner;
        this.model = model;
        this.engine = engine;
        this.color = color;
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


    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
