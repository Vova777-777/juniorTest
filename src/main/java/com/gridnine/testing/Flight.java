package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


public class Flight {
    private final List<Segment> segments;

    public Flight(final List<Segment> segs) {
        segments = segs;
    }

    public List<Segment> getSegments() {
        return segments;
    }

    public LocalDateTime getTimeDepartureFlight(){
        return segments.get(0).getDepartureDate();
    }

    public LocalDateTime getTimeArrivalFlight(){
        return segments.get(segments.size() - 1).getArrivalDate();
    }

    @Override
    public String toString() {
        return segments.stream().map(Object::toString)
            .collect(Collectors.joining(" "));
    }
}
