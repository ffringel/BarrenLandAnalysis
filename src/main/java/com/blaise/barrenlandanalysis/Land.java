package com.blaise.barrenlandanalysis;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter @Setter
public class Land {

    /*
    Use Lombok generate getters and setter methods for our Land Class
     */

    //Max coordinate values for the x and y coordinates
    public static final int X_MAX = 400;
    public static final int Y_MAX = 600;

    //List to store coordinates of barren land
    LinkedList<Integer[]> barrenLands = new LinkedList<>();

    //queue to hold coordinates while searching
    LinkedList<Integer[]> queue = new LinkedList<>();

    // map to hold fertile area against barren
    HashMap<Integer, Integer> areasMap = new HashMap<>();

    //grid representing farm land
    int[][] farmLand = new int[X_MAX][Y_MAX];
}
