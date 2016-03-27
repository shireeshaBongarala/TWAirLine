package com.twair;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class FlightsTests {
    private String source;
    private String destination;

    @Before
    public void setUp() throws Exception {
        source = "TestSource";
        destination = "TestDestination";
    }

    @Test
    public void shouldReturnListOfFlightsForSourceDestination() throws Exception {
        Plane plane1 = new Plane("type1", 30);
        Plane plane2 = new Plane("type2", 60);
        Flight flight1 = new Flight(source, destination, plane1, null);
        Flight flight2 = new Flight("TestSource1", destination, plane2, null);
        Flight flight3 = new Flight(source, destination, plane1, null);
        Flights allFlights = new Flights();
        allFlights.addFlight(flight1);
        allFlights.addFlight(flight2);
        allFlights.addFlight(flight3);

        ArrayList<Flight> flights = allFlights.search(source, destination);
        Assert.assertEquals(source, flights.get(0).getSource());
        Assert.assertEquals(destination, flights.get(0).getDestination());
        Assert.assertEquals(source, flights.get(1).getSource());
        Assert.assertEquals(destination, flights.get(1).getDestination());
        Assert.assertEquals(2, flights.size());
    }
}
