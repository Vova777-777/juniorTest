package com.gridnine.testing.rules;

import com.gridnine.testing.Flight;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class RuleFlightBeforeNow extends Rule {

    List<Flight> flightList;

    public RuleFlightBeforeNow(List<Flight> flightList) {
        this.flightList = flightList;
    }

    public List<Flight> filterListFlight(List<Flight> flightList){
        return flightList.stream().filter(flight -> !this.abilityToBeRightly(flight)).
                collect(Collectors.toList());

    }

    @Override
    public boolean abilityToBeRightly(Flight flight) {
        return LocalDateTime.now().isAfter(flight.getTimeDepartureFlight());
    }


}
