package com.gridnine.testing.rules;

import com.gridnine.testing.Flight;

import java.time.LocalDateTime;

public class RuleFlightBeforeNow extends Rule {


    public RuleFlightBeforeNow(Flight flight){
        super(flight);
    }

    @Override
    public boolean abilityToBeRightly() {
        return LocalDateTime.now().isAfter(flight.getTimeDepartureFlight());
    }


}
