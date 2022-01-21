package com.gridnine.testing;

import com.gridnine.testing.rules.Rule;

import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    List<Flight> flightList;
    public Filter(List<Flight> flightList){
        this.flightList = flightList;
    }
    public void filterFlight(Rule ... rules){
        for (Rule rule : rules) {
            List<Flight> resultList = flightList.stream().filter(flight -> !rule.abilityToBeRightly()).
                    collect(Collectors.toList());
        }
    }
}
