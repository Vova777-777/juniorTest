package com.gridnine.testing;

import com.gridnine.testing.rules.AbleConfirmRule;
import com.gridnine.testing.rules.RuleDepartureBeforeArrival;
import com.gridnine.testing.rules.RuleFlightBeforeNow;
import com.gridnine.testing.rules.RuleTimeOnLandMoreThanNecessary;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


public class FilterTest {

    List<Flight> listFlight1;
    AbleConfirmRule rule[];
    List<Flight> listExpected;



    @Test
    public void filterFlight() {
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
        listExpected = Arrays.asList(
                new Flight (Arrays.asList(new Segment(threeDaysFromNow, threeDaysFromNow.plusHours(2)))),
                new Flight(Arrays.asList(new Segment(threeDaysFromNow, threeDaysFromNow.plusHours(2)),
                        new Segment(threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(5)))));
        rule = new AbleConfirmRule[] {new RuleDepartureBeforeArrival(), new RuleFlightBeforeNow(),
                new RuleTimeOnLandMoreThanNecessary(Duration.ofHours(2))};

        assertEquals(listExpected.size(), new Filter(listFlight1).filterFlight(rule).size());
        assertEquals(listExpected.toString(), new Filter(listFlight1).filterFlight(rule).toString());

    }
}