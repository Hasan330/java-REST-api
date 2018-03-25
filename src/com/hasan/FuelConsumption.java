package com.hasan;

import java.util.Calendar;

public class FuelConsumption {
    private Calendar refuelDate;
    private Long initialMillage;
    private int cost;
    private double litresFilled;
    private int proposedDistance;
    private int actualDistance;

    private longDistances longDistance;

    public FuelConsumption(Calendar refuelDate, Long initialMillage, int cost, double litresFilled, int proposedDistance, int actualDistance, longDistances longDistance) {
        this(refuelDate, initialMillage, cost, litresFilled, proposedDistance, actualDistance);
        this.longDistance = longDistance;
    }

    public FuelConsumption(Calendar refuelDate, Long initialMillage, int cost, double litresFilled, int proposedDistance, int actualDistance) {
        this.refuelDate = refuelDate;
        this.initialMillage = initialMillage;
        this.cost = cost;
        this.litresFilled = litresFilled;
        this.proposedDistance = proposedDistance;
        this.actualDistance = actualDistance;
    }

    public Calendar getRefuelDate() {
        return refuelDate;
    }

    public Long getInitialMillage() {
        return initialMillage;
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

    public longDistances getLongDistance() {
        return longDistance;
    }
}
