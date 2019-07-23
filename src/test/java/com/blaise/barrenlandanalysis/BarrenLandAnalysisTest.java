package com.blaise.barrenlandanalysis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BarrenLandAnalysisTest {

    BarrenLandAnalysis bla = new BarrenLandAnalysis();

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void testMain() {

    }

    @Test
    public void testCalculateFertileLand1() {
        String[] STDIN = {"0 292 399 307"};
        String STDOUT = "116800 116800";

        assertEquals(STDOUT, bla.calculateFertileLand(STDIN));

    }

    @Test
    public void testCalculateFertileLand2() {
        String[] STDIN = {"48 192 351 207", "48 392 351 407", "120 52 135 547", "260 52 275 547"};
        String STDOUT = "22816 192608";

        assertEquals(STDOUT, bla.calculateFertileLand(STDIN));
    }
}
