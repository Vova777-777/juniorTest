package com.gridnine.testing.rules;

import com.gridnine.testing.Flight;

import java.time.Duration;
import java.time.LocalDateTime;

public class RuleTimeOnLandMoreThanNecessary extends Rule {

    Flight flight;
    Duration duration;

    public RuleTimeOnLandMoreThanNecessary(Flight flight, Duration duration){
        super(flight);
        this.duration = duration;
    }

    @Override
    public boolean abilityToBeRightly() {
        return duration.compareTo(computeAndGetDurationOnLandBetweenSegments()) < 0;
    }

    public Duration computeAndGetDurationOnLandBetweenSegments(){
        LocalDateTime arrivalTimePreviousSegment;
        LocalDateTime departureTimeNextSegment;
        Duration resultDuration = Duration.ofSeconds(0);
        Duration durationBetweenSegments;
        for (int i = 0; i < flight.getSegments().size() - 1; i++){
            arrivalTimePreviousSegment = flight.getSegments().get(i).getDepartureDate();
            departureTimeNextSegment = flight.getSegments().get(i + 1).getArrivalDate();
            durationBetweenSegments = Duration.between(arrivalTimePreviousSegment, departureTimeNextSegment);
            resultDuration = resultDuration.plus(durationBetweenSegments);
        }
        return resultDuration;
    }
}
