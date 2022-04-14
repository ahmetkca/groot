package org.jlab.groot.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Dimension1D02Test {

    @Test
    void contains() {
        Dimension1D dimension1D = new Dimension1D();
        dimension1D.setMinMax(-10.85, 1.27);
        assertTrue(dimension1D.contains(-10.75));
        assertFalse(dimension1D.contains(-12.75));
        assertTrue(dimension1D.contains(0.75));
        assertFalse(dimension1D.contains(3.3));
    }
}
