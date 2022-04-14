package org.jlab.groot.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Dimension2DTest {

    @Test
    public void test_grow_of_Dimension2D()
    {
        Dimension2D dimension2D_1 = new Dimension2D();
        dimension2D_1.set(-35, -20, 15, 30);

        Dimension2D dimension2D_2 = new Dimension2D();
        dimension2D_2.set(-25, -15, -3, 11);

        assertEquals(-35, dimension2D_1.getDimension(0).getMin(), String.format("dimension2D_1 first dimension min value expected is %d", -35));
        System.out.println("first dimension min val successfully set to -35");
        assertEquals(-20,dimension2D_1.getDimension(0).getMax(), String.format("dimension2D_1 first dimension max value expected is %d", -20));
        System.out.println("first dimension max val successfully set to -20");
        assertEquals(15, dimension2D_1.getDimension(1).getMin(), String.format("dimension2D_1 second dimension min value expected is %d", 15));
        System.out.println("second dimension min val successfully set to 15");
        assertEquals(30, dimension2D_1.getDimension(1).getMax(), String.format("dimension2D_1 second dimension max value expected is %d", 30));
        System.out.println("second dimension max val successfully set to 30");

        dimension2D_1.grow(dimension2D_2);
        assertEquals(-35, dimension2D_1.getDimension(0).getMin());
        assertEquals(-15, dimension2D_1.getDimension(0).getMax());
        assertEquals(-3, dimension2D_1.getDimension(1).getMin());
        assertEquals(30, dimension2D_1.getDimension(1).getMax());

    }

}