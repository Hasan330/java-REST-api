package com.hasan;

public class Car extends Vehicle{
    private int     doors;
    private String  model;
    private long    millage;
    private int     gears;
    private boolean isManual;

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

}
