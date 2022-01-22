package com.gridnine.testing;

import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDateTime;
import static org.junit.Assert.*;

public class SegmentTest {
    public static Segment segment1;
    public static Segment segment2;
    public static Segment segment3;
    public static LocalDateTime threeDaysFromNow;

    @BeforeClass
    public static void createSegments(){
        threeDaysFromNow = LocalDateTime.now().plusHours(3);
        threeDaysFromNow = LocalDateTime.of(threeDaysFromNow.getYear(), threeDaysFromNow.getMonth(), threeDaysFromNow.getDayOfMonth(),
                threeDaysFromNow.getHour(), threeDaysFromNow.getMinute(), threeDaysFromNow.getSecond());
        segment1 = new Segment(threeDaysFromNow, threeDaysFromNow.plusDays(5));
        segment2 = new Segment(threeDaysFromNow.plusHours(2), threeDaysFromNow.plusHours(4));
        segment3 = new Segment(threeDaysFromNow.plusMinutes(1), threeDaysFromNow.plusMinutes(3));
    }

    @Test
    public void getDepartureDate() {
        assertEquals(threeDaysFromNow, segment1.getDepartureDate());
        assertEquals(threeDaysFromNow.plusHours(2), segment2.getDepartureDate());
        assertEquals(threeDaysFromNow.plusMinutes(1), segment3.getDepartureDate());
    }

    @Test
    public void getArrivalDate() {
        assertEquals(threeDaysFromNow.plusDays(5), segment1.getArrivalDate());
        assertEquals(threeDaysFromNow.plusHours(4), segment2.getArrivalDate());
        assertEquals(threeDaysFromNow.plusMinutes(3), segment3.getArrivalDate());
    }


}