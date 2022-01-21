package com.gridnine.testing.rules;

import com.gridnine.testing.Flight;

import java.time.LocalDateTime;

public class RuleFlightBeforeNow extends Rule {

    private final LocalDateTime timeDeparture;
    private final LocalDateTime timeArrival;

    RuleFlightBeforeNow(Flight flight){
        this.timeDeparture = flight.getSegments().get(0).getDepartureDate();
        this.timeArrival = flight.getSegments().get(flight.getSegments().size() - 1).getArrivalDate();
    }

    @Override
    public boolean abilityToBeRightly() {
        return timeArrival.isAfter(timeDeparture);
    }


}
