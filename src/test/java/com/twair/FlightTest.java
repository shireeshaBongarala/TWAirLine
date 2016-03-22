package com.twair;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class FlightTest {
    private String source;
    private String dest;

    @Before
    public void setUp() throws Exception {
        this.source = "TestSource";
        this.dest = "TestDestination";
    }

    @Test
    public void shouldHaveSourceDestination() throws Exception {
        Flight flight = new Flight(source, dest);
        Assert.assertEquals(source, flight.getSource());
        Assert.assertEquals(dest, flight.getDesination());
    }

    @Test
    public void shouldHaveArrivalAndDeparture() throws Exception {
        Calendar departure = new GregorianCalendar(2016,4,10, 9, 10, 0);
        Calendar arrival = new GregorianCalendar(2016,4,10, 11, 10, 0);
        Flight flight = new Flight(source, dest);
        flight.setScheduleTime(departure, arrival);
        Assert.assertEquals(departure, flight.getDepartureTime());
        Assert.assertEquals(arrival, flight.getArrivalTime());
    }
}
