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
    private int id;

    @Column(name = "source")
    private String   source;
    @Column(name = "destination")
    private String   destination;
    @Column(name= "distance")
    private int      distance;
    @Column(name = "date")
    private Calendar dateOfTrip;

    @ManyToOne
    private Refill refill;

    public LongDistance(){

    }

    public LongDistance(String source, String destination, int distance, Calendar dateOfTrip) {
        this.source = source;
        this.destination = destination;
        this.distance = distance;
        this.dateOfTrip = dateOfTrip;
    }

    public int getId() {
        return id;
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

    public Refill getRefill() {
        return refill;
    }

    public int getDistance() {
        return distance;
    }

    public void setRefill(Refill refill) {
        this.refill = refill;
        this.refill.addLongDistance(this);
        Refill tempRefill = this.getRefill();
        Car tempCar                         = tempRefill.getCar();
        Owner tempOwner                     = tempCar.getOwner();

        System.out.println("\n"+tempOwner.getName()+ " Recorded long distance from " + this.getSource() + " to " + this.getDestination() +" (" + this.getDistance() + " KM)" + " for his car: " + tempCar.getBrand() + " " + tempCar.getModel() + " on " + this.getDateOfTrip().getTime() +"\n");

    }

    @Override
    public String toString() {
        return "LongDistance{" +
                "id=" + id +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", distance=" + distance +
                ", dateOfTrip=" + dateOfTrip.getTime() +
                ", refill=" + refill +
                '}';
    }
}
