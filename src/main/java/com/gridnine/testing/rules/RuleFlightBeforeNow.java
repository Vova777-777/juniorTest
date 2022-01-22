package com.gridnine.testing.rules;

import com.gridnine.testing.Flight;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class RuleFlightBeforeNow implements AbleConfirmRule {

    public List<Flight> filterListFlight(List<Flight> flightList){
        return flightList.stream().filter(flight -> !this.abilityToBeRightly(flight)).
                collect(Collectors.toList());

    }

    @Override
    public boolean abilityToBeRightly(Flight flight) {
        return LocalDateTime.now().isAfter(flight.getTimeDepartureFlight());
    }


}
