package com.blaise.barrenlandanalysis;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ReadInputTest {
    private Land myLand;

    // Test we get expected outcome when no input is given
    @Test
    public void testNoInputs() {
        myLand = new Land();
        String input = new String("");
        boolean fails = false;

        try {
            ReadInput.processInput(input, myLand);
        } catch (Exception ex) {
            fails = true;
            System.out.println(ex.getMessage());
        }

        assertEquals(0, myLand.getBarrenLands().size());
    }

    // test we get expected outcome and program fails if we input wrong type
    @Test
    public void testInvalidInputs() {
        myLand = new Land();
        String input = new String("{'0.2 -292 399 307'}");
        boolean fails = false;

        try {
            ReadInput.processInput(input, myLand);
        } catch (Exception ex) {
            fails = true;
        }

        assertTrue(fails);
    }

    // test size of barren land size is one when we input only one rectangle
    @Test
    public void testSingleCoord() {
        myLand = new Land();
        String input = new String("{“48 192 351 207”}");
        boolean fails = false;

        try {
            ReadInput.processInput(input, myLand);
        } catch (Exception ex) {
            fails = true;
            System.out.println(ex.getMessage());
        }

        assertEquals(1, myLand.getBarrenLands().size());
    }

    // test size of barren land is equal to the number of rectangle input
    @Test
    public void testMultipleCoords() {
        myLand = new Land();
        String input = new String("{“10 10 20 201”, “20 20 30 30”, “15 20 10 30”, “10 30 210 415”}");
        boolean fails = false;

        try {
            ReadInput.processInput(input, myLand);
        } catch (Exception ex) {
            fails = true;
            System.out.println(ex.getMessage());
        }

        assertEquals(4, myLand.getBarrenLands().size());
    }
}
