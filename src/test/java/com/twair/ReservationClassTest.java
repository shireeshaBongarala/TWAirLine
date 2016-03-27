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
}
