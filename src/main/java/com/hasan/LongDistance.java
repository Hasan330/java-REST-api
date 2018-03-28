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

    private String source;
    private String destination;
    private int distance;
    private Calendar dateOfTrip;

    @Column(name = "REFILL_ID")
    private int refillId;

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
}
