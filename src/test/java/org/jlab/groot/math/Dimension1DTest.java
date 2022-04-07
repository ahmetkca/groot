package org.jlab.groot.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Dimension1DTest {

    @Test
    void getDimensionTicks() {
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

    @Test
    void contains() {
        Dimension1D dimension1D = new Dimension1D();
        dimension1D.setMinMax(-10.85, 1.27);
        assertTrue(dimension1D.contains(-10.75));
        assertFalse(dimension1D.contains(-12.75));
        assertTrue(dimension1D.contains(0.75));
        assertFalse(dimension1D.contains(3.3));
    }

    @Test
    void test_toString() {
        Dimension1D dimension1D = new Dimension1D();
        dimension1D.setMinMax(-10.75, 233.9999);
        assertEquals(String.format("Dimension1D :  %8.4f  %8.4f", -10.75, 233.9999), dimension1D.toString());
    }
}