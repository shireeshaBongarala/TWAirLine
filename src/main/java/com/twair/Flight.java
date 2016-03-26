package com.twair;

import java.util.Calendar;

public class Flight {
    private String source;
    private String destination;
    private Plane plane;
    private Calendar departureTime;
    private Calendar arrivalTime;
    private int numberOfSeats;
    private int basePrice;

    public Flight(String source, String destination, Plane plane) {
        this.source = source;
        this.destination = destination;
        this.plane = plane;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public void setScheduleTime(Calendar departureTime, Calendar arrivalTime) throws Exception {
        if(departureTime.after(arrivalTime)) {
            throw new Exception("departure time cannot be greater than arrival time");
        }
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public Calendar getDepartureTime() {
        return departureTime;
    }

    public Calendar getArrivalTime() {
        return arrivalTime;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public int getBasePrice() {
        if(basePrice == 0 && DataSource.planeBasePrice.containsKey(plane.getType())){
            basePrice  = DataSource.planeBasePrice.get(plane.getType());
        }
        return basePrice;
    }
}
