package com.twair;


import java.util.Calendar;

public class BusinessFareCalculator implements FareCalculator {
    @Override
    public double calculateBookingAmountForReservationClass(ReservationClass reservationClass, int noOfPassengers) {
        Calendar dateOfTravel = reservationClass.getDateOfTravel();

        int day = dateOfTravel.getInstance().get(Calendar.DAY_OF_WEEK);
        if(day == 1 || day == 2 || day == 6) {
            return  reservationClass.getBasePrice() * 1.30 * noOfPassengers;
        }
        return reservationClass.getBasePrice() * noOfPassengers;
    }
}
