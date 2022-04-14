package org.jlab.groot.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Dimension1D03Test {

    @Test
    void test_toString() {
        Dimension1D dimension1D = new Dimension1D();
        dimension1D.setMinMax(-10.75, 233.9999);
        assertEquals(String.format("Dimension1D :  %8.4f  %8.4f", -10.75, 233.9999), dimension1D.toString());
    }
}
