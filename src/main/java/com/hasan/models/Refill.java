package com.hasan.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name= "refills")
public class Refill {

    @Id
    @Column(name= "id")
    @GeneratedValue(generator = "incrementator")
    @GenericGenerator(name = "incrementator", strategy = "increment" )
    private int id;

    @Column(name= "cost")
    private int        cost;

    private Calendar   refuelDate;
    private Long       initialMillage;
    private double     litresFilled;
    private int        proposedDistance;
    private int        actualDistance;
    private int        totalDistance;

    @ManyToOne
    @JsonIgnore
    private Car car;

    @OneToMany(targetEntity = Distance.class, mappedBy = "refill", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JsonIgnore
    private List<Distance> distances = new ArrayList<>();

    public Refill(){

    }

    public Refill(Calendar refuelDate, Long initialMillage, int cost, double litresFilled, int proposedDistance, int actualDistance) {
        this.refuelDate        = refuelDate;
        this.initialMillage    = initialMillage;
        this.cost              = cost;
        this.litresFilled      = litresFilled;
        this.proposedDistance  = proposedDistance;
        this.actualDistance    = actualDistance;
    }

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

    public List<Distance> getDistances() {
        return distances;
    }

    public void setDistances(List<Distance> distances) {
        this.distances = distances;
    }

    public void addDistance(Distance distance){

        this.addTotalDistance(distance.getDistance());
        this.car.addTotalDistance(distance.getDistance());

        distance.setRefill(this);
        this.distances.add(distance);
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
//        this.car.addFuelRefill(this);
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public void addTotalDistance(int totalDistance) {
        System.out.println("Adding to totalDistance field in Refill object "+ totalDistance);

        this.totalDistance += totalDistance;
    }

    @Override
    public String toString() {
        return "Refill{" +
                "id=" + id +
                ", cost=" + cost +
                ", refuelDate=" + refuelDate.getTime() +
                ", initialMillage=" + initialMillage +
                ", litresFilled=" + litresFilled +
                ", proposedDistance=" + proposedDistance +
                ", actualDistance=" + actualDistance +
                ", car=" + car +
                '}';
    }
}
