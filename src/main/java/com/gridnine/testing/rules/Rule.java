package com.gridnine.testing.rules;

import com.gridnine.testing.Flight;

import java.util.List;

public abstract class Rule {


    public abstract boolean abilityToBeRightly(Flight flight);
    public abstract List<Flight> filterListFlight(List<Flight> flightList);
}
