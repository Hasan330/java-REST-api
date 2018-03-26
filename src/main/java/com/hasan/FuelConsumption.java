package com.hasan;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name= "consumption_table")
public class FuelConsumption {

    @Id
    @Column(name= "id")
    @GeneratedValue(generator = "incrementator")
    @GenericGenerator(name = "incrementator", strategy = "increment" )
    private int        id;

    @Column(name= "cost")
    private int        cost;

    private Calendar   refuelDate;
    private Long       initialMillage;
    private double     litresFilled;
    private int        proposedDistance;
    private int        actualDistance;

//    private longDistances longDistance;

    public FuelConsumption(int id, Calendar refuelDate, Long initialMillage, int cost, double litresFilled, int proposedDistance, int actualDistance) {
        this.id                = id;
        this.refuelDate        = refuelDate;
        this.initialMillage    = initialMillage;
        this.cost              = cost;
        this.litresFilled      = litresFilled;
        this.proposedDistance  = proposedDistance;
        this.actualDistance    = actualDistance;
    }

//    public FuelConsumption(int id, Calendar refuelDate, Long initialMillage, int cost, double litresFilled, int proposedDistance, int actualDistance, longDistances longDistance) {
//        this(id, refuelDate, initialMillage, cost, litresFilled, proposedDistance, actualDistance);
//        this.longDistance = longDistance;
//    }

    public void setId(int id) {
        this.id = id;
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

    public int getId() {
        return id;
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
