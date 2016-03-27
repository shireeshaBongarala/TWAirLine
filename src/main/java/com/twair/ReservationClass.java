package com.twair;

public class ReservationClass {
    private String name;
    private int availableSeats;

    public ReservationClass(String name, int availableSeats) {
        this.name = name;
        this.availableSeats = availableSeats;
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
}
