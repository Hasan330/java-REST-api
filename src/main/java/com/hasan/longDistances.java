package com.hasan;

import java.util.Date;

public class longDistances {
    //id should be auto-incremented
    private int id;
    private String source;
    private String destination;
    private int distance;
    private Date dateOfTrip;

    public longDistances(String source, String destination, int distance, Date dateOfTrip) {
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

    public int getDistance() {
        return distance;
    }

    public Date getDateOfTrip() {
        return dateOfTrip;
    }
}
