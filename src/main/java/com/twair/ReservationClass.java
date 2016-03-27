package com.twair;

public class ReservationClass {
    private String name;
    private int availableSeats;
    private int totalSeats;

    public ReservationClass(String name, int totalSeats) {
        this.name = name;
        this.availableSeats = totalSeats;
        this.totalSeats = totalSeats;
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
}
