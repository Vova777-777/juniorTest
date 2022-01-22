package com.gridnine.testing.rules;

import com.gridnine.testing.Flight;
import com.gridnine.testing.Segment;

import java.util.List;
import java.util.stream.Collectors;

public class RuleDepartureBeforeArrival implements AbleConfirmRule {

    public List<Flight> filterListFlight(List<Flight> flightList){
        return flightList.stream().filter(flight -> !this.abilityToBeRightly(flight)).
                collect(Collectors.toList());

    }

    @Override
    public boolean abilityToBeRightly(Flight flight) {
        for (Segment segment : flight.getSegments()){
            if (segment.getDepartureDate().isBefore(segment.getArrivalDate())) return false;
        }
        return true;
    }


}
