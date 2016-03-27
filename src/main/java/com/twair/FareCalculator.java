package com.twair;

public class FareCalculator {
    public int calculateBookingAmount(Flight flight, int noOfPassengers) {
        return flight.getBasePrice() * noOfPassengers;
    }

    public int calculateBookingAmountForReservationClass(ReservationClass reservationClass, int noOfPassengers) {
        int basePrice = reservationClass.getBasePrice();
        int availableSeats = reservationClass.getAvailableSeats();
        int totalSeats = reservationClass.getTotalSeats();
        double percentageOfAvailableSeats = availableSeats/totalSeats;
        return basePrice * noOfPassengers;
    }
}
