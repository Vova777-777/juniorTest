package com.gridnine.testing.rules;

import com.gridnine.testing.Flight;
import com.gridnine.testing.Segment;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class RuleTimeOnLandMoreThanNecessaryTest {
    public static RuleTimeOnLandMoreThanNecessary rule;
    public static List<Flight> listFlight1;
    public static List<Flight> listExpected;
    public static LocalDateTime threeDaysFromNow;

    @Before
    public void createNeedObjects(){
        rule = new RuleTimeOnLandMoreThanNecessary(Duration.ofHours(2));
        threeDaysFromNow = LocalDateTime.now().plusDays(3);
        threeDaysFromNow = LocalDateTime.of(threeDaysFromNow.getYear(),threeDaysFromNow.getMonth(),
                threeDaysFromNow.getDayOfMonth(), threeDaysFromNow.getHour(),threeDaysFromNow.getMinute(),
                threeDaysFromNow.getSecond());

        listFlight1 = Arrays.asList(new Flight(Arrays.asList(new Segment(threeDaysFromNow.plusMinutes(5),
                        threeDaysFromNow.plusHours(2)))),
                new Flight(Arrays.asList(new Segment(threeDaysFromNow.plusMinutes(5), threeDaysFromNow.plusHours(2)),
                        new Segment(threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(5)))),
                new Flight(Arrays.asList(new Segment(threeDaysFromNow.minusDays(6), threeDaysFromNow))),
                new Flight(Arrays.asList(new Segment(threeDaysFromNow.plusMinutes(5), threeDaysFromNow.minusHours(6)))),
                new Flight(Arrays.asList(new Segment(threeDaysFromNow.plusMinutes(5), threeDaysFromNow.plusHours(2)),
                        new Segment(threeDaysFromNow.plusHours(5), threeDaysFromNow.plusHours(6)))),
                new Flight(Arrays.asList(new Segment(threeDaysFromNow, threeDaysFromNow.plusHours(2)),
                        new Segment(threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(4)),
                        new Segment(threeDaysFromNow.plusHours(6), threeDaysFromNow.plusHours(7)))));

        listExpected = Arrays.asList(new Flight(Arrays.asList(new Segment(threeDaysFromNow.plusMinutes(5),
                        threeDaysFromNow.plusHours(2)))),
                new Flight(Arrays.asList(new Segment(threeDaysFromNow.plusMinutes(5), threeDaysFromNow.plusHours(2)),
                        new Segment(threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(5)))),
                new Flight(Arrays.asList(new Segment(threeDaysFromNow.minusDays(6), threeDaysFromNow))),
                new Flight(Arrays.asList(new Segment(threeDaysFromNow.plusMinutes(5), threeDaysFromNow.minusHours(6)))));
    }

    @Test
    public void filterListFlight() {
     assertEquals(listExpected.toString(), rule.filterListFlight(listFlight1).toString());
        assertEquals(listExpected.size(), rule.filterListFlight(listFlight1).size());
    }

    @Test
    public void abilityToBeRightly() {
        Flight flightExp1 = listExpected.get(0);
        Flight flightExp2 = listExpected.get(1);
        Flight flightExp3 = listExpected.get(2);
        Flight flightExpTrue1 = listFlight1.get(4);
        Flight flightExpTrue2 = listFlight1.get(5);

        assertFalse(rule.abilityToBeRightly(flightExp1));
        assertFalse(rule.abilityToBeRightly(flightExp2));
        assertFalse(rule.abilityToBeRightly(flightExp3));
        assertTrue(rule.abilityToBeRightly(flightExpTrue1));
        assertTrue(rule.abilityToBeRightly(flightExpTrue2));
    }

    @Test
    public void computeAndGetDurationOnLandBetweenSegments() {
        Flight flight1= new Flight(Arrays.asList( new Segment(threeDaysFromNow, threeDaysFromNow.plusHours(1)),
               new Segment(threeDaysFromNow.plusHours(5), threeDaysFromNow.plusHours(7))));
        Flight flight2 = new Flight(Arrays.asList( new Segment(threeDaysFromNow, threeDaysFromNow.plusHours(4)),
                new Segment(threeDaysFromNow.plusHours(5), threeDaysFromNow.plusHours(7))));
        Flight flight3 = new Flight(Arrays.asList( new Segment(threeDaysFromNow, threeDaysFromNow.plusHours(2)),
                new Segment(threeDaysFromNow.plusHours(5), threeDaysFromNow.plusHours(7))));

        assertEquals(4*3600, rule.computeAndGetDurationOnLandBetweenSegments(flight1).getSeconds());
        assertEquals(1*3600, rule.computeAndGetDurationOnLandBetweenSegments(flight2).getSeconds());
        assertEquals(3*3600, rule.computeAndGetDurationOnLandBetweenSegments(flight3).getSeconds());
    }
}