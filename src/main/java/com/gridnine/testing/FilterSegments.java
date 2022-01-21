package com.gridnine.testing;

import java.time.Duration;
import java.time.LocalDateTime;

public class FilterSegments {
    private final LocalDateTime timeDeparture;
    private final LocalDateTime timeArrival;
    Flight flight;
    FilterSegments(Flight flight){
        this.flight = flight;
        this.timeDeparture = flight.getSegments().get(0).getDepartureDate();
        this.timeArrival = flight.getSegments().get(flight.getSegments().size() - 1).getArrivalDate();
    }

    public LocalDateTime getTimeDeparture() {
        return timeDeparture;

    }

    public LocalDateTime getTimeArrival() {
        return timeArrival;
    }

    public long computeAndGetSecondsOnLandBetweenSegment(){
        LocalDateTime arrivalTimePreviousSegment;
        LocalDateTime departureTimeNextSegment;
        Duration duration;
        long seconds = 0L;
        for (int i = 0; i < flight.getSegments().size() - 1; i++){
            arrivalTimePreviousSegment = flight.getSegments().get(i).getDepartureDate();
            departureTimeNextSegment = flight.getSegments().get(i + 1).getArrivalDate();
            duration = Duration.between(arrivalTimePreviousSegment, departureTimeNextSegment);
            duration = duration.plusSeconds(seconds);
            seconds = duration.getSeconds();
        }
        return seconds;
    }

    public boolean ArrivalTimeBeforeDepartureTime(LocalDateTime timeArrival, LocalDateTime timeDeparture){
        return timeArrival.isBefore(timeDeparture);
    }
}
