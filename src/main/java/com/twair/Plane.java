package com.twair;

public class Plane {
    private String type;
    private int numSeats;
    public Plane(String type, int numSeats) {
        this.type = type;
        this.numSeats = numSeats;
    }

    public String getType() {
        return type;
    }

    public int getNumSeats() {
        return numSeats;
    }
}
