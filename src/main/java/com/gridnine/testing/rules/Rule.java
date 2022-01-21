package com.gridnine.testing.rules;

import com.gridnine.testing.Flight;

public abstract class Rule {

    Flight flight;

    Rule(Flight flight){
        this.flight = flight;
    }

    public abstract boolean abilityToBeRightly();
}
