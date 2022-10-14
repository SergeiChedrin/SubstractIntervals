package org.testing.interval;

import java.text.DecimalFormat;

public class TimeInterval {

    private double start;
    private double end;

    public TimeInterval(double start, double end) {
//        assert start <= end : "start '" + start + "' must be less than end '" + end + "'!";

        this.start = start;
        this.end = end;

        validateInterval();
    }

    boolean validateInterval() {
        if (start > end) throw new IllegalArgumentException();
        return true;
    }

    public double getStart() {
        return start;
    }

    public double getEnd() {
        return end;
    }

//    public void setStart(double start) {
//        this.start = start;
//    }
//
//    public void setEnd(double end) {
//        this.end = end;
//    }

    public boolean overlaps(final TimeInterval other) {
        if (isBefore(other) || isAfter(other) ) return false;
        return true;
    }

    public boolean isInside(final TimeInterval other) {
        if ( (other.start > this.start) && (other.end < this.end) )return true;
        return false;
    }

    public boolean isContaining(final TimeInterval other) {
        if ( (this.start >= other.start) && (this.end <= other.end) )return true;
        return false;
    }

    private boolean isBefore(final TimeInterval other) {
        if (this.start >= other.end) return true;
        return false;
    }

    private boolean isAfter(final TimeInterval other) {
        if (this.end <= other.start) return true;
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimeInterval that)) return false;

        if (Double.compare(that.start, start) != 0) return false;
        return Double.compare(that.end, end) == 0;
    }

    @Override
    public String toString() {
        final DecimalFormat df = new DecimalFormat("0.00");
        return "(" + df.format(start) + "-" + df.format(end) + ')';
//        return "TimeInterval{" +
//                "start=" + df.format(start) +
//                ", end=" + df.format(end) +
//                '}';
    }

 }
