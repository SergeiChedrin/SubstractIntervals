package org.testing.interval;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IntervalCalculatorTest {

    IntervalCalculator calculationEngine;
    List<TimeInterval> substractedIntervals;
    List<TimeInterval> substractionIntervals;
    List<TimeInterval> finalResult;

    @BeforeEach
    void setUp() {
        calculationEngine = new IntervalCalculator();
    }

    @Test
    void splitInterval() {
////      6. (9:15-11:00) "minus" (10:00-10:15) = (9:15-10:00, 10:15-11:00)
//        System.out.println("\nSplit Case: " + "(9:15-11:00) \"minus\" (10:00-10:15) = \t(9:15-10:00, 10:15-11:00)" );
        substractedIntervals = Arrays.asList(new TimeInterval(9.15, 11.00));
        substractionIntervals = Arrays.asList(new TimeInterval(10.00, 10.15));
        finalResult = calculationEngine.substractSetOfIntervals(substractedIntervals, substractionIntervals);
        assertEquals(2, finalResult.size());
    }

    @Test
    void emptyIntervalRsult1() {
        substractedIntervals = Arrays.asList(new TimeInterval(9.15, 11.00));
        substractionIntervals = Arrays.asList(new TimeInterval(9.15, 11.00));
        finalResult = calculationEngine.substractSetOfIntervals(substractedIntervals, substractionIntervals);
        assertEquals(0, finalResult.size());
    }

    @Test
    void emptyIntervalRsult11() {
        substractedIntervals = Arrays.asList(new TimeInterval(9.15, 11.00));
        finalResult = calculationEngine.substractSetOfIntervals(substractedIntervals, substractedIntervals);
        assertEquals(0, finalResult.size());
    }

    @Test
    void emptyIntervalRsult2() {
        substractedIntervals = Arrays.asList(new TimeInterval(9.15, 11.00));
        substractionIntervals = Arrays.asList(new TimeInterval(9.15, 12.00));
        finalResult = calculationEngine.substractSetOfIntervals(substractedIntervals, substractionIntervals);
        assertEquals(0, finalResult.size());
    }

    @Test
    void emptyIntervalRsult3() {
        substractedIntervals = Arrays.asList(new TimeInterval(9.15, 11.00));
        substractionIntervals = Arrays.asList(new TimeInterval(8.15, 11.00));
        finalResult = calculationEngine.substractSetOfIntervals(substractedIntervals, substractionIntervals);
        assertEquals(0, finalResult.size());
    }

    @Test
    void emptyIntervalRsult4() {
        substractedIntervals = Arrays.asList(new TimeInterval(9.15, 11.00));
        substractionIntervals = Arrays.asList(new TimeInterval(8.15, 12.00));
        finalResult = calculationEngine.substractSetOfIntervals(substractedIntervals, substractionIntervals);
        assertEquals(0, finalResult.size());
    }

    @Test
    void severalIntervalsMinusSeveral() {
        substractedIntervals = Arrays.asList(new TimeInterval(9.00, 11.00), new TimeInterval(13.00, 15.00));
        substractionIntervals = Arrays.asList(new TimeInterval(9.00, 9.15), new TimeInterval(10.00, 10.15),
                new TimeInterval(12.30, 16.00));
        finalResult = calculationEngine.substractSetOfIntervals(substractedIntervals, substractionIntervals);
        List<TimeInterval> expectedResult = Arrays.asList(new TimeInterval(9.15, 10.00),
                new TimeInterval(10.15, 11.00));
        assertEquals(expectedResult, finalResult);
    }

}