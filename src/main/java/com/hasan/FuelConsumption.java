package com.hasan;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name= "consumption3")
public class FuelConsumption {

    @Id
    @Column(name= "refill_id")
    @GeneratedValue(generator = "incrementator")
    @GenericGenerator(name = "incrementator", strategy = "increment" )
    private int refill_id;

    @Column(name= "cost")
    private int        cost;

    private Calendar   refuelDate;
    private Long       initialMillage;
    private double     litresFilled;
    private int        proposedDistance;
    private int        actualDistance;

//    @ManyToOne
//    @JoinColumn(name = "refill_id")
//    private Car car;

    public FuelConsumption(int refill_id, Calendar refuelDate, Long initialMillage, int cost, double litresFilled, int proposedDistance, int actualDistance) {
        this.refill_id = refill_id;
        this.refuelDate        = refuelDate;
        this.initialMillage    = initialMillage;
        this.cost              = cost;
        this.litresFilled      = litresFilled;
        this.proposedDistance  = proposedDistance;
        this.actualDistance    = actualDistance;
    }


//    public Car getCar() {
//        return car;
//    }
//
//    public void setCar(Car car) {
//        this.car = car;
//    }

    public void setRefill_id(int refill_id) {
        this.refill_id = refill_id;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Calendar getRefuelDate() {
        return refuelDate;
    }

    public Long getInitialMillage() {
        return initialMillage;
    }

    public int getRefill_id() {
        return refill_id;
    }

    public int getCost() {
        return cost;
    }

    public double getLitresFilled() {
        return litresFilled;
    }

    public int getProposedDistance() {
        return proposedDistance;
    }

    public int getActualDistance() {
        return actualDistance;
    }

//    public longDistances getLongDistance() {
//        return longDistance;
//    }

}
