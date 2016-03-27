package com.twair;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class EconomyFareCalculatorTest {

    @Mock
    ReservationClass economy;
    @Mock
    Plane plane;

    @Mock
    ReservationClass business;

    @Before
    public void setUp(){
        initMocks(this);
    }

    @Test
    public void shouldCalculateBookingAmountForTwoPassengersInEconomyClass() {
        EconomyFareCalculator economyFareCalculator = new EconomyFareCalculator();

        when(economy.getTotalSeats()).thenReturn(195);
        when(economy.getAvailableSeats()).thenReturn(190);
        when(economy.getName()).thenReturn("Economy");
        when(economy.getBasePrice()).thenReturn(6000);
        double bookingAmount = economyFareCalculator.calculateBookingAmountForReservationClass(economy, 2);

        Assert.assertEquals(bookingAmount,12000, 0.0);
    }

    @Test
    public void shouldCalculateBookingAmountForThreePassengersInEconomyClass() {
        EconomyFareCalculator economyFareCalculator = new EconomyFareCalculator();

        when(economy.getTotalSeats()).thenReturn(195);
        when(economy.getAvailableSeats()).thenReturn(190);
        when(economy.getName()).thenReturn("Economy");
        when(economy.getBasePrice()).thenReturn(6000);
        double bookingAmount = economyFareCalculator.calculateBookingAmountForReservationClass(economy, 3);

       assertEquals(bookingAmount,18000, 0.0);
    }

    @Test
    public void shouldCalculateBookingAmountWhenFirstFortyToNinetyPercentOfTotalSeatsAreAvailable() {
        EconomyFareCalculator economyFareCalculator = new EconomyFareCalculator();

        when(economy.getTotalSeats()).thenReturn(195);
        when(economy.getAvailableSeats()).thenReturn(95);
        when(economy.getBasePrice()).thenReturn(6000);
        double bookingAmount = economyFareCalculator.calculateBookingAmountForReservationClass(economy, 2);

        assertEquals(bookingAmount, 15600, 0.0);
    }

    @Test
    public void shouldCalculateBookingAmountWhenLessThanTenPercentOfTotalSeatsAreAvailable() {
        EconomyFareCalculator economyFareCalculator = new EconomyFareCalculator();

        when(economy.getTotalSeats()).thenReturn(195);
        when(economy.getAvailableSeats()).thenReturn(5);
        when(economy.getBasePrice()).thenReturn(6000);
        double bookingAmount = economyFareCalculator.calculateBookingAmountForReservationClass(economy, 2);

        assertEquals(bookingAmount, 19200, 0.0);
    }
}
