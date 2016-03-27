package com.twair;

public class ReservationClass {
    private String name;
    private int availableSeats;
    private int totalSeats;
    private int basePrice;

    public ReservationClass(String name, int totalSeats, int basePrice) {
        this.name = name;
        this.availableSeats = totalSeats;
        this.totalSeats = totalSeats;
        this.basePrice = basePrice;
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
}
