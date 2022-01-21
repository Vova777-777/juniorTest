package com.gridnine.testing.rules;

import com.gridnine.testing.Flight;
import com.gridnine.testing.Segment;

import java.time.Duration;
import java.time.LocalDateTime;

public class RuleDepartureBeforeArrival extends Rule {


    public RuleDepartureBeforeArrival(Flight flight) {
        super(flight);
    }

    @Override
    public boolean abilityToBeRightly() {
        for (Segment segment : flight.getSegments()){
            if (segment.getDepartureDate().isBefore(segment.getArrivalDate())) return true;
        }
        return false;
    }


}
