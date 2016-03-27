package com.twair;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ReservationClassTest {

    @Test
    public void shouldHaveNameAndNoOfSeatsAvailable() {
        ReservationClass reservationClass = new ReservationClass("Economy", 195, 0, null);

        Assert.assertEquals("Economy", reservationClass.getName());
        Assert.assertEquals(195, reservationClass.getAvailableSeats());
    }

    @Test
    public void shouldSubtractNoOfPassengersFromNoOfSeatsAvailable() {
        ReservationClass reservationClass = new ReservationClass("Economy", 195, 0, null);
        boolean bookingStatus = reservationClass.assignSeats(100);

        Assert.assertEquals(95, reservationClass.getAvailableSeats());
        Assert.assertTrue(bookingStatus);
    }

    @Test
    public void shouldNotSubtractIfNoOfSeatsAreNotSufficient() {
        ReservationClass reservationClass = new ReservationClass("Economy", 195, 0, null);
        boolean bookingStatus = reservationClass.assignSeats(200);

        Assert.assertEquals(195, reservationClass.getAvailableSeats());
        Assert.assertFalse(bookingStatus);
    }

    @Test
    public void shouldContainTotalNoOfSeats() {
        ReservationClass reservationClass = new ReservationClass("Economy", 195, 0, null);

        int totalNoOfSeats = reservationClass.getTotalSeats();

        Assert.assertEquals(195, totalNoOfSeats);
    }

    @Test
    public void shouldContainBasePrice() {
        ReservationClass reservationClass = new ReservationClass("Economy", 195, 6000, null);

        int basePrice = reservationClass.getBasePrice();

        Assert.assertEquals(6000, basePrice);
    }

    @Test
    public void shouldContainDateOfTravel() {
        Calendar dateOfTravel = new GregorianCalendar(2016,4,10, 9, 10, 0);

        ReservationClass reservationClass = new ReservationClass("Economy", 195, 6000, dateOfTravel);

        Assert.assertEquals(dateOfTravel, reservationClass.getDateOfTravel());
    }
}
