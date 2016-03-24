package com.twair;

import java.util.ArrayList;

public class DataSource {
    public static ArrayList<String> locations = new ArrayList<String>() {{
        add("Hyderabad");
        add("Bangalore");
    }};

    public static ArrayList<Plane> planes = new ArrayList<Plane>(){{
        add(new Plane("Boeing777-200LR(77L)", 195));
        add(new Plane("Airbus A319 V2", 144));
        add(new Plane("Airbus A321", 152));
    }};

    public static Flights flights = new Flights(){{
        addFlight(new Flight(locations.get(0), locations.get(1), planes.get(0)));
        addFlight(new Flight(locations.get(0), locations.get(1), planes.get(1)));
        addFlight(new Flight(locations.get(0), locations.get(1), planes.get(2)));
    }};
}
