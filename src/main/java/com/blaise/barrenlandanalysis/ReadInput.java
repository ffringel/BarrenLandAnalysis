package com.blaise.barrenlandanalysis;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;


public class ReadInput {

    public static void readInputFromIO(Land myLand) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Input Coordinates in format shown below");
        System.out.println("{\" X11 Y11 X21 Y21\",\" X12 Y12 X22 Y22\", ........}");
        String st = reader.readLine();
        processInput(st, myLand);
    }

    /**
     * Takes a set of rectangles as a string from STDIN input
     * and creates a Land object
     * @param sts
     * @param myLand
     * @throws Exception
     */
    public static void processInput(String sts, Land myLand) throws Exception {
        LinkedList<Integer[]> barrenLands = new LinkedList<Integer[]>();
        String[] parts = sts.split(",");

        for(String s : parts){
            s = s.replace("\"", "");
            s = s.replaceAll("“|”", "");
            s = s.replaceAll("\\{|\\}", "");
            s = s.replaceAll("^ ", "");

            if(!s.isEmpty()){
                String[] coord = s.split(" ");
                if(coord.length < 4){
                    throw new ArrayIndexOutOfBoundsException("");
                }

                int x1 = parseVal(coord[0]), x2 = parseVal(coord[2]);
                int y1 = parseVal(coord[1]), y2 = parseVal(coord[3]);
                if( x1 >= 0 && y1 >= 0 && x2 >= 0  && y2 >= 0 && x1 < myLand.X_MAX &&
                        x2 < myLand.X_MAX && y1 < myLand.Y_MAX && y2 < myLand.Y_MAX) {
                    Integer[] point = {x1, y1, x2, y2};
                    barrenLands.add(point);
                } else{
                    throw new Exception("Barren Land OutOfBound \n");
                }
            }
        }
        myLand.setBarrenLands(barrenLands);
    }

    public static Integer parseVal(String st) {
        try {
            return Integer.parseInt(st);
        } catch (NumberFormatException ex) {
            throw new NumberFormatException("Land Coordinates not integers \n");
        }
    }
}
