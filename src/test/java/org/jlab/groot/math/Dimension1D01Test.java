package org.jlab.groot.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Dimension1D01Test {

    @Test
    void test_getDimensionTicks() {
        Dimension1D dimension1D = new Dimension1D();
        dimension1D.setMinMax(-5, 5);
        int maxTicks = 10;
        assertTrue(dimension1D.getDimensionTicks(maxTicks).size() <= (maxTicks + 1));
        assertEquals(-5.0, dimension1D.getDimensionTicks(maxTicks).get(0));
        assertEquals(-4.0, dimension1D.getDimensionTicks(maxTicks).get(1));
        assertEquals(-3.0, dimension1D.getDimensionTicks(maxTicks).get(2));
        assertEquals(-2.0, dimension1D.getDimensionTicks(maxTicks).get(3));
        assertEquals(-1.0, dimension1D.getDimensionTicks(maxTicks).get(4));
        assertEquals(0.0, dimension1D.getDimensionTicks(maxTicks).get(5));
        assertEquals(1.0, dimension1D.getDimensionTicks(maxTicks).get(6));
        assertEquals(2.0, dimension1D.getDimensionTicks(maxTicks).get(7));
        assertEquals(3.0, dimension1D.getDimensionTicks(maxTicks).get(8));
        assertEquals(4.0, dimension1D.getDimensionTicks(maxTicks).get(9));
        assertEquals(5.0, dimension1D.getDimensionTicks(maxTicks).get(10));
    }
}
