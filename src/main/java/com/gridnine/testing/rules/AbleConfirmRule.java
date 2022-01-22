package com.gridnine.testing.rules;

import com.gridnine.testing.Flight;

import java.util.List;

public interface AbleConfirmRule {

    boolean abilityToBeRightly(Flight flight);
    List<Flight> filterListFlight(List<Flight> flightList);
}
