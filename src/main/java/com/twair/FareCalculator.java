package com.twair;

public class FareCalculator {
    public int calculateBookingAmount(Flight flight, int noOfPassengers) {
        return flight.getBasePrice() * noOfPassengers;
    }

    public double calculateBookingAmountForReservationClass(ReservationClass reservationClass, int noOfPassengers) {
        int basePrice = reservationClass.getBasePrice();
        int availableSeats = reservationClass.getAvailableSeats();
        int totalSeats = reservationClass.getTotalSeats();

        double percentageOfAvailableSeats = availableSeats * 100/totalSeats;
        if(percentageOfAvailableSeats > 10 && percentageOfAvailableSeats < 60) {
            return basePrice * 1.3 * noOfPassengers;
        }
        if(percentageOfAvailableSeats < 10) {
            return basePrice * 1.6 * noOfPassengers;
        }
        return basePrice * noOfPassengers;
    }
}
