package com.AoC.TwentyTwentyOne.Challenges.DayFive.HydroThermalVents;

import java.util.Arrays;
import java.util.List;

public class HydroThermalVentMap {
    public int[][] ventMap;

    public HydroThermalVentMap() {
        ventMap = new int[1000][1000];
        for (int[] array: ventMap) {
            Arrays.fill(array, 0);
        }
    }

    public void addCoordinate(List<Integer> coordinate) {
        ventMap[coordinate.get(0)][coordinate.get(1)] += 1;
    }

    public void addCoordinates(List<List<Integer>> coordinates) {
        for(List<Integer> coordinate: coordinates) {
            addCoordinate(coordinate);
        }
    }

    public int getDangerousCoordinateCount() {
        int dangerousCoordinateCount = 0;
        for(int row = 0; row < ventMap.length; row++) {
            for(int column = 0; column < ventMap[0].length; column++) {
                if(ventMap[row][column] > 1) {
                    dangerousCoordinateCount++;
                }
            }
        }
        return dangerousCoordinateCount;
    }
}
