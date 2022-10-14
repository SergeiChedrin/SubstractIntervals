package org.testing;

import org.testing.interval.IntervalCalculator;
import org.testing.interval.TimeInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Intervals Substractions");

        // Substraction Engine
        IntervalCalculator calculationEngine = new IntervalCalculator();
        List<TimeInterval> finalResult = new ArrayList<>();

//      1. (9:00-10:00) “minus” (9:00-9:30) = (9:30-10:00)
        System.out.println("\nTest Case: " + "(9:00-10:00) minus (9:00-9:30) = \t\t(9:30-10:00)" );
        List<TimeInterval>  substractedIntervals = Arrays.asList(new TimeInterval(9.00, 10.00));
        List<TimeInterval>  substractionIntervals = Arrays.asList(new TimeInterval(9.00, 9.30));
        finalResult = calculationEngine.substractSetOfIntervals(substractedIntervals, substractionIntervals);

//      2. (9:00-10:00) “minus” (9:00-10:00) = ()
        System.out.println("\nTest Case: " + "(9:00-10:00) minus (9:00-10:00) = \t\t()" );
        substractedIntervals = Arrays.asList(new TimeInterval(9.00, 10.00));
        substractionIntervals = Arrays.asList(new TimeInterval(9.00, 10.00));
        finalResult = calculationEngine.substractSetOfIntervals(substractedIntervals, substractionIntervals);

//      3. (9:00-9:30) “minus” (9:30-15:00) = (9:00-9:30)
        System.out.println("\nTest Case: " + "(9:00-9:30) minus (9:30-15:00) = \t\t(9:00-9:30)" );
        substractedIntervals = Arrays.asList(new TimeInterval(9.00, 9.30));
        substractionIntervals = Arrays.asList(new TimeInterval(9.30, 15.00));
        finalResult = calculationEngine.substractSetOfIntervals(substractedIntervals, substractionIntervals);

//      4. (9:00-9:30, 10:00-10:30) “minus” (9:15-10:15) = (9:00-9:15, 10:15-10:30)
        System.out.println(
                "\nTest Case: " + "(9:00-9:30, 10:00-10:30) minus (9:15-10:15) = \n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t(9:00-9:15, 10:15-10:30)"
        );
        substractedIntervals = Arrays.asList(new TimeInterval(9.00, 9.30), new TimeInterval(10.00, 10.30));
        substractionIntervals = Arrays.asList(new TimeInterval(9.15, 10.15));
        finalResult = calculationEngine.substractSetOfIntervals(substractedIntervals, substractionIntervals);

//      5. (9:00-11:00, 13:00-15:00) “minus” (9:00-9:15, 10:00-10:15, 12:30-16:00) = (9:15-10:00, 10:15-11:00)
        System.out.println(
                "\nTest Case: " + "(9:00-11:00, 13:00-15:00) minus (9:00-9:15, 10:00-10:15, 12:30-16:00) = \n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t(9:15-10:00, 10:15-11:00)"
        );
        substractedIntervals = Arrays.asList(new TimeInterval(9.00, 11.00), new TimeInterval(13.00, 15.00));
        substractionIntervals = Arrays.asList(new TimeInterval(9.00, 9.15), new TimeInterval(10.00, 10.15),
                                new TimeInterval(12.30, 16.00));
        finalResult = calculationEngine.substractSetOfIntervals(substractedIntervals, substractionIntervals);


//      6. (9:15-11:00) "minus" (10:00-10:15) = (9:15-10:00, 10:15-11:00)
        System.out.println("\nSplit Case: " + "(9:15-11:00) \"minus\" (10:00-10:15) = \t(9:15-10:00, 10:15-11:00)" );
        substractedIntervals = Arrays.asList(new TimeInterval(9.15, 11.00));
        substractionIntervals = Arrays.asList(new TimeInterval(10.00, 10.15));
        finalResult = calculationEngine.substractSetOfIntervals(substractedIntervals, substractionIntervals);

    }
}
