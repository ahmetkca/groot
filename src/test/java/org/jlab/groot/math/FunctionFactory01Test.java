package org.jlab.groot.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionFactory01Test {

    @Test
    void asin() {
        assertEquals(1.5708,(double)Math.round( FunctionFactory.asin(1)* 100000d) / 100000d);
    }
}
