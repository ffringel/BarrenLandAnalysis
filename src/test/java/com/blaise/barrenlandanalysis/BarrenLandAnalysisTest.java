package com.blaise.barrenlandanalysis;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BarrenLandAnalysisTest {

    Land myLand = new Land();

    @Test
    public void testClearLandCells() {
        int result = 0, land = 0;
        BarrenLandAnalysis.clearLandCells(myLand);
        int[][] farmLand = myLand.getFarmLand();

        for (int i = 0; i < myLand.X_MAX; i++)
            for (int j = 0; j < myLand.Y_MAX; j++)
                if (farmLand[i][j] != 0)
                    land++;

        assertEquals(result, land);
    }

    @Test
    public void testFillLandCells() {
        String input = new String("{“0 292 399 307”}");
        int result = 6400, land = 0;

        try {
            ReadInput.processInput(input, myLand);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        BarrenLandAnalysis.fillLandCells(myLand);
        int[][] farmLand = myLand.getFarmLand();

        for (int i = 0; i < myLand.X_MAX; i++)
            for (int j = 0; j < myLand.Y_MAX; j++)
                if (farmLand[i][j] != 0)
                    land++;

        assertEquals(result, land);
    }

    @Test
    public void testFillLandCellsMulti() {
        String input = new String("{“48 192 351 207”, “48 392 351 407”, “120 52 135 547”, “260 52 275 547”}");
        int result = 24576, land = 0;

        try {
            ReadInput.processInput(input, myLand);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        BarrenLandAnalysis.fillLandCells(myLand);
        int[][] farmLand = myLand.getFarmLand();

        for (int i = 0; i < myLand.X_MAX; i++)
            for (int j = 0; j < myLand.Y_MAX; j++)
                if (farmLand[i][j] != 0)
                    land++;

        assertEquals(result, land);
    }

    @Test
    public void testCalculateFertileArea1() {
        myLand = new Land();
        String result = "240000";
        String input = new String("");

        try {
            ReadInput.processInput(input, myLand);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        BarrenLandAnalysis.clearLandCells(myLand);
        BarrenLandAnalysis.fillLandCells(myLand);
        BarrenLandAnalysis.calculateFertileAreas(myLand);
        BarrenLandAnalysis.printOutput(myLand);

        assertEquals(result, BarrenLandAnalysis.printOutput(myLand));
    }

    @Test
    public void testCalculateFertileArea2() {
        myLand = new Land();
        String result = "116800 116800";
        String input = new String("{“0 292 399 307”}");

        try {
            ReadInput.processInput(input, myLand);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        BarrenLandAnalysis.clearLandCells(myLand);
        BarrenLandAnalysis.fillLandCells(myLand);
        BarrenLandAnalysis.calculateFertileAreas(myLand);
        BarrenLandAnalysis.printOutput(myLand);

        assertEquals(result, BarrenLandAnalysis.printOutput(myLand));
    }

    @Test
    public void testCalculatefertileArea3() {
        myLand = new Land();
        String result = "22816 192608";
        String input = new String("{“48 192 351 207”, “48 392 351 407”, “120 52 135 547”, “260 52 275 547”}");

        try {
            ReadInput.processInput(input, myLand);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        BarrenLandAnalysis.clearLandCells(myLand);
        BarrenLandAnalysis.fillLandCells(myLand);
        BarrenLandAnalysis.calculateFertileAreas(myLand);
        BarrenLandAnalysis.printOutput(myLand);

        assertEquals(result, BarrenLandAnalysis.printOutput(myLand));
    }
}
