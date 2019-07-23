package com.blaise.barrenlandanalysis;

import java.util.*;

public class BarrenLandAnalysis {

    public static void main(String[] args) {
        Land myLand = new Land();

        try {
            ReadInput.readInputFromIO(myLand);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.exit(1);
        }

        clearLandCells(myLand);
        fillLandCells(myLand);
        calculateFertileAreas(myLand);
        System.out.println(printOutput(myLand));
    }

    /**
     * @param myLand
     * This sets all the cells in our Land grid to 0,
     * where 0 represents a fertile piece of land.
     */
    public static void clearLandCells(Land myLand) {
        int[][] farmLand = myLand.getFarmLand();
        for (int i = 0; i < myLand.X_MAX;  i++)
            for (int j = 0; j < myLand.Y_MAX; j++)
                farmLand[i][j] = 0;
    }

    /**
     * @param myLand
     * Looks for barren areas in the land and set it to 1.
     */
    public static void fillLandCells(Land myLand) {
        ListIterator<Integer[]> iterator = myLand.getBarrenLands().listIterator();
        int[][] farmLand = myLand.getFarmLand();

        while (iterator.hasNext()) {
            Integer[] coord = iterator.next();
            for (int i = coord[0]; i <= coord[2]; i++)
                for (int j = coord[1]; j <= coord[3]; j++)
                    farmLand[i][j] = 1;
        }
    }

    /**
     * @param myLand
     * This is where the magic of BFS occurs :)
     *
     */
    public static void calculateFertileAreas(Land myLand) {
       int[][] farmLand = myLand.getFarmLand();
       LinkedList<Integer[]> queue = myLand.getQueue();
       HashMap<Integer, Integer> areasMap = myLand.getAreasMap();

       int land = 1, i = 0, j = 0;
       while (i < myLand.X_MAX && j < myLand.Y_MAX) {
           if (queue.isEmpty()) {
               Integer[] node = {i, j};

               if (farmLand[i][j] == 0) {
                   land++;
                   areasMap.put(land, 0);
                   queue.add(node);
               }

               if (i == (myLand.X_MAX - 1)) {
                   i = 0;
                   j++;
               } else {
                   i++;
               }
           }

           if (!queue.isEmpty()) {
               Integer[] node = queue.pop();
               int x = node[0];
               int y = node[1];

               if (farmLand[x][y] == 0) {
                   if (x > 0)
                       addQueue(x - 1, y, myLand);
                   if (x < (myLand.X_MAX - 1))
                       addQueue(x + 1, y, myLand);
                   if (y > 0)
                       addQueue(x, y - 1, myLand);
                   if (y < (myLand.Y_MAX - 1))
                       addQueue(x, y + 1, myLand);

                   farmLand[x][y] = land;
                   areasMap.put(land, areasMap.get(land) + 1);
               }
           }
       }
    }

    /**
     * @param i
     * @param j
     * @param myLand
     * Queue used during BFS of fertile land.
     */
    private static void addQueue(int i, int j, Land myLand) {
        LinkedList<Integer[]> queue = myLand.getQueue();
        int[][] farmLand = myLand.getFarmLand();

        if (farmLand[i][j] == 0)
            queue.add(new Integer[] {i, j});
    }

    public static String printOutput(Land myLand) {
        HashMap<Integer, Integer> areasMap = myLand.getAreasMap();
        int[] result = new int[areasMap.values().size()];

        int i = 0;
        for (Map.Entry<Integer, Integer> entry : areasMap.entrySet()) {
            result[i] = entry.getValue();
            i++;
        }

        Arrays.sort(result);
        return (Arrays.toString(result)).replaceAll("\\[|\\]|,", "");
    }
}
