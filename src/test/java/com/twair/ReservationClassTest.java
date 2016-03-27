package com.twair;

import org.junit.Assert;
import org.junit.Test;

public class ReservationClassTest {

    @Test
    public void shouldHaveNameAndNoOfSeatsAvailable() {
        ReservationClass reservationClass = new ReservationClass("Economy", 195);

        Assert.assertEquals("Economy", reservationClass.getName());
        Assert.assertEquals(195, reservationClass.getAvailableSeats());
    }

    @Test
    public void shouldSubtractNoOfPassengersFromNoOfSeatsAvailable() {
        ReservationClass reservationClass = new ReservationClass("Economy", 195);
        boolean bookingStatus = reservationClass.assignSeats(100);

        Assert.assertEquals(95, reservationClass.getAvailableSeats());
        Assert.assertTrue(bookingStatus);
    }

    @Test
    public void shouldNotSubtractIfNoOfSeatsAreNotSufficient() {
        ReservationClass reservationClass = new ReservationClass("Economy", 195);
        boolean bookingStatus = reservationClass.assignSeats(200);

        Assert.assertEquals(195, reservationClass.getAvailableSeats());
        Assert.assertFalse(bookingStatus);
    }
}
