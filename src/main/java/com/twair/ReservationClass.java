package com.twair;

import java.util.Calendar;

public class ReservationClass {
    private String name;
    private int availableSeats;
    private int totalSeats;
    private int basePrice;
    private Calendar dateOfTravel;

    public ReservationClass(String name, int totalSeats, int basePrice, Calendar dateOfTravel) {
        this.name = name;
        this.availableSeats = totalSeats;
        this.totalSeats = totalSeats;
        this.basePrice = basePrice;
        this.dateOfTravel = dateOfTravel;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public String getName() {
        return name;
    }

    public boolean assignSeats(int noOfPassengers) {
        if (noOfPassengers > availableSeats) {
            return false;
        }
        availableSeats-= noOfPassengers;
        return true;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public Calendar getDateOfTravel() {
        return dateOfTravel;
    }
}
