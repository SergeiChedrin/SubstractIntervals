package org.testing.interval;

import static org.junit.jupiter.api.Assertions.*;

class TimeIntervalTest {

    @org.junit.jupiter.api.Test
    void validateIllegalArgumentException() {
        assertThrows(
          IllegalArgumentException.class,
                () -> {
                    TimeInterval wrongInterval = new TimeInterval(12.00, 10.00);
                }
        );
    }

    @org.junit.jupiter.api.Test
    void overlapsYes() {
        TimeInterval firstInterval = new TimeInterval(10.00, 12.00);
        TimeInterval secondInterval = new TimeInterval(11.00, 13.10);
        assertTrue(firstInterval.overlaps(secondInterval));
    }

    @org.junit.jupiter.api.Test
    void overlapsFalse() {
        TimeInterval firstInterval = new TimeInterval(10.00, 12.00);
        TimeInterval secondInterval = new TimeInterval(13.00, 13.10);
        assertFalse(firstInterval.overlaps(secondInterval));
    }

    @org.junit.jupiter.api.Test
    void isInside() {
        TimeInterval firstInterval = new TimeInterval(10.00, 12.00);
        TimeInterval secondInterval = new TimeInterval(11.00, 11.10);
        assertTrue(firstInterval.overlaps(secondInterval));
    }

    @org.junit.jupiter.api.Test
    void isContaining() {
        TimeInterval firstInterval = new TimeInterval(11.00, 11.10);
        TimeInterval secondInterval = new TimeInterval(10.00, 12.00);
        assertTrue(firstInterval.overlaps(secondInterval));
    }
}