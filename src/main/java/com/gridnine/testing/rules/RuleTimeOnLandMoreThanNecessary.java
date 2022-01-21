package com.gridnine.testing.rules;

import com.gridnine.testing.Flight;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class RuleTimeOnLandMoreThanNecessary extends Rule {


    Duration duration;

    public RuleTimeOnLandMoreThanNecessary(Duration duration){
        this.duration = duration;
    }

    public List<Flight> filterListFlight(List<Flight> flightList){
        List<Flight> resultList = flightList.stream().filter(flight -> !this.abilityToBeRightly(flight)).
                collect(Collectors.toList());
        return resultList;
    }

    @Override
    public boolean abilityToBeRightly(Flight flight) {
        return duration.compareTo(computeAndGetDurationOnLandBetweenSegments(flight)) < 0;
    }

    public Duration computeAndGetDurationOnLandBetweenSegments(Flight flight){
        LocalDateTime arrivalTimePreviousSegment;
        LocalDateTime departureTimeNextSegment;
        Duration resultDuration = Duration.ofSeconds(0);
        Duration durationBetweenSegments;
        for (int i = 0; i < flight.getSegments().size() - 1; i++){
            arrivalTimePreviousSegment = flight.getSegments().get(i).getArrivalDate();
            departureTimeNextSegment = flight.getSegments().get(i + 1).getDepartureDate();
            durationBetweenSegments = Duration.between(arrivalTimePreviousSegment, departureTimeNextSegment);
            resultDuration = resultDuration.plus(durationBetweenSegments);
        }
        return resultDuration;
    }
}
