package com.twair;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class FlightTests {
    private String source;
    private String dest;
    private Plane plane;

    @Before
    public void setUp() throws Exception {
        this.source = "TestSource";
        this.dest = "TestDestination";
        this.plane = new Plane("type", 30);
    }

    @Test
    public void shouldHaveSourceDestination() throws Exception {
        Flight flight = new Flight(source, dest, plane, null);
        Assert.assertEquals(source, flight.getSource());
        Assert.assertEquals(dest, flight.getDestination());
    }

    @Test
    public void shouldHaveArrivalAndDeparture() throws Exception {
        Calendar departure = new GregorianCalendar(2016,4,10, 9, 10, 0);
        Calendar arrival = new GregorianCalendar(2016,4,10, 11, 10, 0);
        Flight flight = new Flight(source, dest, plane, null);
        flight.setScheduleTime(departure, arrival);
        Assert.assertEquals(departure, flight.getDepartureTime());
        Assert.assertEquals(arrival, flight.getArrivalTime());
    }

    @Test(expected=Exception.class)
    public void DepartureDateCannotBeGreaterOrEqualToArrivalTime() throws Exception {
        Calendar departure = new GregorianCalendar(2016,5,10, 9, 10, 0);
        Calendar arrival = new GregorianCalendar(2016,4,10, 11, 10, 0);
        Flight flight = new Flight(source, dest, plane, null);
        flight.setScheduleTime(departure, arrival);
        flight.setScheduleTime(departure, departure);
    }

    @Test
    public void shouldHaveSeats() throws Exception {
        Flight flight = new Flight(source, dest, plane, null);
        flight.setNumberOfSeats(30);
        Assert.assertEquals(30, flight.getNumberOfSeats());
    }

    @Test
    public void shouldHaveBasePrice() throws Exception {
        Flight flight = new Flight(source, dest, plane, null);
        flight.setBasePrice(1000);
        Assert.assertEquals(1000, flight.getBasePrice());
    }

    @Test
    public void shouldSetBasePriceBasedOnTypeOfPlane() throws Exception {
        Plane plane = new Plane("Boeing 777", 195);

        Flight flight = new Flight(source,dest, plane, null);

        Assert.assertEquals(6000, flight.getBasePrice());
    }
    @Test
    public void shouldSetBasePriceToZeroWhenTypeOfPlaneIsNotAvailable() throws Exception {
        Plane plane = new Plane("Boeing 77721", 195);

        Flight flight = new Flight(source,dest, plane, null);

        Assert.assertEquals(0, flight.getBasePrice());
    }

    @Test
    public void shouldContainResevationClasses() {
        Plane plane = new Plane("Boeing 777", 238);

        ReservationClass economy = new ReservationClass("Economy", 195,0, null);
        ReservationClass business = new ReservationClass("Business", 35,0, null);
        ReservationClass first = new ReservationClass("First", 8, 0, null);
        List<ReservationClass> reservationClassList = new ArrayList<>();
        reservationClassList.add(economy);
        reservationClassList.add(business);
        reservationClassList.add(first);

        Flight flight = new Flight(source, dest, plane, reservationClassList);

        List<ReservationClass> actualReservationClassList = flight.getReservationClasses();

        Assert.assertEquals(reservationClassList, actualReservationClassList);
    }
}
