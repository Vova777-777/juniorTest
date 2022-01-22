package com.gridnine.testing;

import com.gridnine.testing.rules.AbleConfirmRule;

import java.util.List;


public class Filter {
    List<Flight> flightList;

    public Filter(List<Flight> flightList){
        this.flightList = flightList;
    }

    public List<Flight> filterFlight(AbleConfirmRule... rules){
        for (AbleConfirmRule rule : rules){
            flightList = rule.filterListFlight(flightList);
        }
        return flightList;
    }
}
