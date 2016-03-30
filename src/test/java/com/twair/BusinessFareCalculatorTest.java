package com.twair;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class BusinessFareCalculatorTest {
    @Mock
    ReservationClass business;

    @Before
    public void setUp(){
        initMocks(this);
    }

    @Test
    public void shouldCalculateBookingAmountForPassengerInBusinessClassOnASunday() {
        FareCalculator businessFareCalculator = new BusinessFareCalculator();
        Calendar dateOfTravel = new GregorianCalendar(2016, 4, 27, 9, 10, 0);

        when(business.getTotalSeats()).thenReturn(35);
        when(business.getAvailableSeats()).thenReturn(35);
        when(business.getBasePrice()).thenReturn(20000);
        when(business.getDateOfTravel()).thenReturn(dateOfTravel);
        double bookingAmount = businessFareCalculator.calculateBookingAmountForReservationClass(business, 1);

        Assert.assertEquals(bookingAmount, 26000, 0.0);
    }

}
