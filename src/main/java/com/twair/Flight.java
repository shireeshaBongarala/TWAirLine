package com.twair;

import java.util.Calendar;

public class Flight {
    private String source;
    private String destination;
    private Calendar departureTime;
    private Calendar arrivalTime;

    public Flight(String source, String destination) {
        this.source = source;
        this.destination = destination;
    }

    public String getSource() {
        return source;
    }

    public String getDesination() {
        return destination;
    }

    public void setScheduleTime(Calendar departureTime, Calendar arrivalTime) {
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public Calendar getDepartureTime() {
        return departureTime;
    }

    public Calendar getArrivalTime() {
        return arrivalTime;
    }
}
