package org.testing.interval;

import java.util.ArrayList;
import java.util.List;

public class IntervalCalculator {

    private List<TimeInterval> substractedIntervals;

    public IntervalCalculator() {
    }

    void setSubstractedIntervals(List<TimeInterval> substractedIntervals) {
        this.substractedIntervals = substractedIntervals;
    }

    // Substracting from the list of initial intervals
    List<TimeInterval> substractInterval(TimeInterval secondOperand) {

        List<TimeInterval> result = new ArrayList<>();

//        for (int i=0; i < resultSubstraction.size(); i++) {
//            TimeInterval nextMinuendInterval = resultSubstraction.get(i);
//        }

        // Looping results of each step substraction -> can split each substracted interval
        for (TimeInterval nextfirstOperand : substractedIntervals) {

            if (nextfirstOperand.equals(secondOperand) || nextfirstOperand.isContaining(secondOperand)) {
                //    ---       ---
                //        minus         => empty result
                //    ---      -----
                continue;
            }
            else if (!nextfirstOperand.overlaps(secondOperand)) {  // not overlapping
                //  ---
                //      minus           => no change
                //          -----
                result.add(nextfirstOperand);
                continue;
            }
            else if (nextfirstOperand.isInside(secondOperand)) {    // splitting to 2 intervals
                //  ------------
                //      minus           => splitting to 2 intervals
                //    ---
                // Result:
                //  --   -------
                TimeInterval firstResult = new TimeInterval(nextfirstOperand.getStart(), secondOperand.getStart());
                TimeInterval secondResult = new TimeInterval(secondOperand.getEnd(), nextfirstOperand.getEnd());
                result.add(firstResult);
                result.add(secondResult);
            }

            // Overlapping cases
            //  -------                 ----------
            //              minus
            //       -----             ------
            // Results:
            //  ----                         -----
            if (nextfirstOperand.getEnd() <= secondOperand.getEnd()) { // Case 1
                TimeInterval substractedResult = new TimeInterval(nextfirstOperand.getStart(), secondOperand.getStart());
                result.add(substractedResult);
            }
            else if (nextfirstOperand.getStart() >= secondOperand.getStart()) { // Case 2
                TimeInterval substractedResult = new TimeInterval(secondOperand.getEnd(), nextfirstOperand.getEnd());
                result.add(substractedResult);
            }

        }

        //System.out.println("Substract One from All result: " + result);
        return result;
    }

    public List<TimeInterval> substractSetOfIntervals(List<TimeInterval> substractedIntervals, List<TimeInterval> secondSetOfOperands) {
        setSubstractedIntervals(substractedIntervals);  // Initial substracted intervals
        List<TimeInterval> substractedResult = new ArrayList<>();
        for (TimeInterval substractionInterval : secondSetOfOperands) {
            substractedResult = substractInterval(substractionInterval);
            setSubstractedIntervals(substractedResult);
            //System.out.println("One step substraction result: " + substractedResult);
        }
        System.out.println("Final Substraction result: \t\t\t\t\t\t\t" + substractedResult);
        return substractedResult;
    }

}

