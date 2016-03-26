package com.twair;

import junit.framework.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class FareCalculatorTest {
    @Test
    public void shouldCalculateAmountWhenFlightAndNoOfPassengersAreGiven() throws Exception {
        Flight flight = new Flight("HYD", "BLR", new Plane("Boeing 777", 195));
        Calendar departure = new GregorianCalendar(2016,4,4, 9, 10, 0);
        Calendar arrival = new GregorianCalendar(2016,4,4, 11, 10, 0);
        flight.setBasePrice(6000);
        flight.setScheduleTime(departure, arrival);

        FareCalculator fareCalculator = new FareCalculator();
        int amount = fareCalculator.calculateBookingAmount(flight, 2);

        Assert.assertEquals(amount, 12000);
    }

}
