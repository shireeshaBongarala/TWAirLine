package com.twair;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class FareCalculatorTest {

    @Mock
    ReservationClass economy;
    @Mock
    Plane plane;

    @Before
    public void setUp(){
        initMocks(this);
    }

    @Test
    public void shouldCalculateAmountWhenFlightAndNoOfPassengersAreGiven() throws Exception {
        Flight flight = new Flight("HYD", "BLR", new Plane("Boeing 777", 195), null);
        Calendar departure = new GregorianCalendar(2016, 4, 4, 9, 10, 0);
        Calendar arrival = new GregorianCalendar(2016, 4, 4, 11, 10, 0);
        flight.setBasePrice(6000);
        flight.setScheduleTime(departure, arrival);

        FareCalculator fareCalculator = new FareCalculator();
        int amount = fareCalculator.calculateBookingAmount(flight, 2);

        Assert.assertEquals(amount, 12000);
    }

    @Test
    public void shouldCalculateBookingAmountForTwoPassengersInEconomyClass() {
        FareCalculator fareCalculator = new FareCalculator();

        when(economy.getTotalSeats()).thenReturn(195);
        when(economy.getAvailableSeats()).thenReturn(190);
        when(economy.getName()).thenReturn("Economy");
        when(economy.getBasePrice()).thenReturn(6000);
        int bookingAmount = fareCalculator.calculateBookingAmountForReservationClass(economy, 2);

        Assert.assertEquals(bookingAmount,12000);
    }

    @Test
    public void shouldCalculateBookingAmountForThreePassengersInEconomyClass() {
        FareCalculator fareCalculator = new FareCalculator();

        when(economy.getTotalSeats()).thenReturn(195);
        when(economy.getAvailableSeats()).thenReturn(190);
        when(economy.getName()).thenReturn("Economy");
        when(economy.getBasePrice()).thenReturn(6000);
        int bookingAmount = fareCalculator.calculateBookingAmountForReservationClass(economy, 3);

       assertEquals(bookingAmount,18000);
    }
   

}
