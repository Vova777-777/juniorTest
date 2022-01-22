package com.gridnine.testing;

import com.gridnine.testing.rules.RuleDepartureBeforeArrivalTest;
import com.gridnine.testing.rules.RuleFlightBeforeNowTest;
import com.gridnine.testing.rules.RuleTimeOnLandMoreThanNecessaryTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        RuleDepartureBeforeArrivalTest.class,
        RuleFlightBeforeNowTest.class,
        RuleTimeOnLandMoreThanNecessaryTest.class,
        FilterTest.class,
        FlightBuilderTest.class,
        FlightTest.class,
        SegmentTest.class
})
public class RunAllTests {
}
