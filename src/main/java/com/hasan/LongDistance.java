package com.hasan;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name= "distances")
public class LongDistance {

    @Id
    @Column(name= "id")
    @GeneratedValue(generator = "incrementator")
    @GenericGenerator(name = "incrementator", strategy = "increment" )
    private int longDistance_id;

    @Column(name = "source")
    private String   source;
    @Column(name = "destination")
    private String   destination;
    @Column(name= "distance")
    private int      distance;
    @Column(name = "date")
    private Calendar dateOfTrip;

    @ManyToOne
    private FuelConsumption fuelConsumption;

    public LongDistance(String source, String destination, int distance, Calendar dateOfTrip) {
        this.source = source;
        this.destination = destination;
        this.distance = distance;
        this.dateOfTrip = dateOfTrip;
    }

    public int getLongDistance_id() {
        return longDistance_id;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public Calendar getDateOfTrip() {
        return dateOfTrip;
    }

    public void setDateOfTrip(Calendar dateOfTrip) {
        this.dateOfTrip = dateOfTrip;
    }

    public FuelConsumption getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(FuelConsumption fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
        this.fuelConsumption.addLongDistance(this);
        FuelConsumption tempFuelConsumption = this.getFuelConsumption();
        Car tempCar                         = tempFuelConsumption.getCar();
        Owner tempOwner                     = tempCar.getOwner();

        System.out.println("\n"+tempOwner.getName()+ " Recorded long distance from " + this.getSource() + " to " + this.getDestination() + " for his car: " + tempCar.getBrand() + " " + tempCar.getModel() + " on " + this.getDateOfTrip().getTime() +"\n");
    }
}
