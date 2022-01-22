package com.gridnine.testing;

import com.gridnine.testing.rules.RuleDepartureBeforeArrival;
import com.gridnine.testing.rules.RuleFlightBeforeNow;
import com.gridnine.testing.rules.RuleTimeOnLandMoreThanNecessary;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Main {
    //        Поместите в main() такой проверочный код. Исключите из тестового набора перелёты по следующим правилам
//        (по каждому правилу нужен отдельный вывод списка перелётов):
//        1.	вылет до текущего момента времени
//        2.	имеются сегменты с датой прилёта раньше даты вылета
//        3.	общее время, проведённое на земле превышает два часа (время на земле — это интервал между прилётом
//        одного сегмента и вылетом следующего за ним)


    public static void main(String[] args) {
        List<Flight> list = FlightBuilder.createFlights();
        System.out.println("Flights before filtration: " + "\n" +list.toString() +
                "\n" + "Size of list = " + list.size() + "\n");


        Filter filter = new Filter(list);
        list = filter.filterFlight(new RuleFlightBeforeNow());
        System.out.println("Flights after filtration per flight before now: " + "\n" +list.toString() +
                "\n" + "Size of list = " + list.size() + "\n");


        list=filter.filterFlight(new RuleDepartureBeforeArrival());
        System.out.println("Flights after filtration per departure and arrival are impossible necessary: " + "\n" +list.toString() +
                "\n" + "Size of list = " + list.size() + "\n");


        list=filter.filterFlight(new RuleTimeOnLandMoreThanNecessary(Duration.ofHours(2)));
        System.out.println("Flights after filtration per time on land more than necessary: " + "\n" +list.toString() +
                "\n" + "Size of list = " + list.size() + "\n");


        list = FlightBuilder.createFlights();
        list = filter.filterFlight(new RuleFlightBeforeNow(),
                new RuleDepartureBeforeArrival(),new RuleTimeOnLandMoreThanNecessary(Duration.ofHours(2)));
        System.out.println("Flights after filtration per all rules" + "\n" +list.toString() +
                "\n" + "Size of list = " + list.size() + "\n");
    }
}
