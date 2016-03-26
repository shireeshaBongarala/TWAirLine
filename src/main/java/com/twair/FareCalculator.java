package com.twair;

public class FareCalculator {
    public int calculateBookingAmount(Flight flight, int noOfPassengers) {
        return flight.getBasePrice() * noOfPassengers;
    }
}
