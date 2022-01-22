package com.gridnine.testing;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class FlightBuilderTest {
    List<Flight> listFlight1;
    List<Flight> listExpected;

    @Test
    public void createFlights() {
        LocalDateTime threeDaysFromNow = LocalDateTime.now().plusDays(3);
        listFlight1 = Arrays.asList(new Flight(Arrays.asList(new Segment(threeDaysFromNow, threeDaysFromNow.plusHours(2)))),
                new Flight(Arrays.asList(new Segment(threeDaysFromNow, threeDaysFromNow.plusHours(2)),
                        new Segment(threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(5)))),
                new Flight(Arrays.asList(new Segment(threeDaysFromNow.minusDays(6), threeDaysFromNow))),
                new Flight(Arrays.asList(new Segment(threeDaysFromNow, threeDaysFromNow.minusHours(6)))),
                new Flight(Arrays.asList(new Segment(threeDaysFromNow, threeDaysFromNow.plusHours(2)),
                        new Segment(threeDaysFromNow.plusHours(5), threeDaysFromNow.plusHours(6)))),
                new Flight(Arrays.asList(new Segment(threeDaysFromNow, threeDaysFromNow.plusHours(2)),
                        new Segment(threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(4)),
                        new Segment(threeDaysFromNow.plusHours(6), threeDaysFromNow.plusHours(7)))));


        listExpected = FlightBuilder.createFlights();
        assertEquals(listExpected.toString(), listFlight1.toString());

    }
}