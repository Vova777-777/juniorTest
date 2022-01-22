package com.gridnine.testing;

import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class FlightTest {
    public static Flight flight;
    public static LocalDateTime threeDaysFromNow;

    @BeforeClass
    public static void createFlight(){
        threeDaysFromNow = LocalDateTime.now().plusDays(3);
        flight = new Flight(Arrays.asList(new Segment(threeDaysFromNow, threeDaysFromNow.plusHours(2)),
                new Segment(threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(5))));
    }

    @Test
    public void getSegments() {
        List<Segment> segments = Arrays.asList(new Segment(threeDaysFromNow, threeDaysFromNow.plusHours(2)),
                new Segment(threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(5)));
        assertEquals(flight.getSegments().toString(), segments.toString());
    }

    @Test
    public void getTimeDepartureFlight() {
        assertEquals(flight.getSegments().get(0).getDepartureDate(), flight.getTimeDepartureFlight());
    }

    @Test
    public void getTimeArrivalFlight() {
        assertEquals(flight.getSegments().get(flight.getSegments().size()-1).getArrivalDate(),
                flight.getTimeArrivalFlight());
    }

}