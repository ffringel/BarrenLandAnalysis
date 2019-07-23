package com.blaise.barrenlandanalysis;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ReadInputTest {
    Land myLand;

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

    @Test
    public void testMultipleCoords() {
        myLand = new Land();
        String input = new String("{“10 10 20 20”, “20 20 30 30”, “5 20 10 30”, “10 30 20 40”}");
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
