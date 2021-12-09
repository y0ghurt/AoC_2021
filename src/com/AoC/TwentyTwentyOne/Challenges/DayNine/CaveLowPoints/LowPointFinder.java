package com.AoC.TwentyTwentyOne.Challenges.DayNine.CaveLowPoints;

import java.util.ArrayList;
import java.util.List;

public class LowPointFinder {
    List<List<Integer>> heightMap;
    List<int[]> lowPointCoordinates;
    List<int[]> foundBasinCoordinates;
    int currentBasinSize = 0;
    public LowPointFinder(List<List<Integer>> heightMap) {
        this.heightMap = heightMap;
    }

    public List<Integer> findLowPoints() {
        List<Integer> lowPoints = new ArrayList<>();
        this.lowPointCoordinates = new ArrayList<>();
        int adjacentPoints = 0;
        boolean isLowPoint = true;
        for(int row = 0; row < heightMap.size(); row++) {
            for(int column = 0; column < heightMap.get(row).size(); column++) {
                int currentValue = heightMap.get(row).get(column);
                if(row > 0) {
                    if(heightMap.get(row-1).get(column) <= heightMap.get(row).get(column)) {
                        isLowPoint = false;
                    }
                }
                if(row < heightMap.size()-1) {
                    if(heightMap.get(row+1).get(column) <= heightMap.get(row).get(column)) {
                        isLowPoint = false;
                    }
                }
                if(column > 0) {
                    if(heightMap.get(row).get(column-1) <= heightMap.get(row).get(column)) {
                        isLowPoint = false;
                    }
                }
                if(column < heightMap.get(row).size()-1) {
                    if(heightMap.get(row).get(column+1) <= heightMap.get(row).get(column)) {
                        isLowPoint = false;
                    }
                }
                if(isLowPoint) {
                    lowPoints.add(heightMap.get(row).get(column));
                    this.lowPointCoordinates.add(new int[]{row, column});
                }
                isLowPoint = true;
            }
        }

        return lowPoints;
    }

    public List<Integer> findBasins() {
        List<Integer> basins = new ArrayList<>();

        findLowPoints();

        for(int[] coordinate: lowPointCoordinates) {
            currentBasinSize = 0;

            evaluateCoordinate(coordinate[0], coordinate[1]);
            basins.add(currentBasinSize);
        }


        return basins;
    }

    private void evaluateCoordinate(int row, int column) {
        boolean isItTrue = false;
        foundBasinCoordinates = new ArrayList<>();
        int[] fu = new int[2];
        fu[0] = row;
        fu[1] = column;
        if (!foundBasinCoordinates.contains(fu)) {
            if (heightMap.get(row).get(column) != 9) {
                foundBasinCoordinates.add(fu);
                currentBasinSize++;


                if (row > 0) {
                    boolean add = true;
                    for(int[] coordinate : foundBasinCoordinates) {
                        if(coordinate[0] == row - 1 && coordinate[1] == column) {
                            add = false;
                        }
                    }
                    if (add) {
                        if (heightMap.get(row - 1).get(column) != 9) {
                            evaluateCoordinate(row - 1, column);
                        }
                    }
                }

                if (row < heightMap.size() - 1) {
                    boolean add = true;
                    for(int[] coordinate : foundBasinCoordinates) {
                        if(coordinate[0] == row + 1 && coordinate[1] == column) {
                            add = false;
                        }
                    }
                    if (add) {
                        if (heightMap.get(row + 1).get(column) != 9) {
                            evaluateCoordinate(row + 1, column);
                        }
                    }
                }
/*
                if (column > 0) {
                    boolean add = true;
                    for(int[] coordinate : foundBasinCoordinates) {
                        if(coordinate[0] == row && coordinate[1] == column - 1) {
                            add = false;
                        }
                    }
                    if (add) {
                        if (heightMap.get(row).get(column - 1) != 9) {
                            evaluateCoordinate(row, column - 1);
                        }
                    }
                }
                if (column < heightMap.get(row).size() - 1) {
                    boolean add = true;
                    for(int[] coordinate : foundBasinCoordinates) {
                        if(coordinate[0] == row && coordinate[1] == column + 1) {
                            add = false;
                        }
                    }
                    if (add) {
                        if (heightMap.get(row).get(column + 1) != 9) {
                            evaluateCoordinate(row, column + 1);
                        }
                    }
                }
            */
            }
        }
    }
}
