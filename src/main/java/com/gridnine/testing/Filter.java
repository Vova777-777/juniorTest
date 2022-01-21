package com.gridnine.testing;

import com.gridnine.testing.rules.Rule;

import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    List<Flight> flightList;
    Filter(List<Flight> flightList){
        this.flightList = flightList;
    }

    public void filterFlight(Rule rule){
     List<Flight> resultList = flightList.stream().filter(flight -> rule.abilityToBeRightly()).
             collect(Collectors.toList());
    }
}
