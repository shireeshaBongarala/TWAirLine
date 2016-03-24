package com.twair;

import java.util.ArrayList;

public class Flights {
    ArrayList<Flight> flights = new ArrayList<Flight>();
    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public ArrayList<Flight> search(String source, String destination) {
        ArrayList<Flight> matchingFlights = new ArrayList<Flight>();
        for(Flight flight : flights) {
            if(flight.getSource().equals(source) && flight.getDestination().equals(destination)) {
                matchingFlights.add(flight);
            }
        };
        return matchingFlights;
    }
}
