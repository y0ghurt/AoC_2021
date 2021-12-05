package com.AoC.TwentyTwentyOne.Challenges.DayFive.HydroThermalVents;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class HydroThermalVent {
    protected List<Integer> firstCoordinate;
    protected List<Integer> secondCoordinate;

    public HydroThermalVent(List<Integer> firstCoordinate, List<Integer> secondCoordinate) {
        this.firstCoordinate = firstCoordinate;
        this.secondCoordinate = secondCoordinate;
    }

    public List<List<Integer>> getStraightCoordinates() {
        List<List<Integer>> coordinates = new LinkedList<>();

        if(!firstCoordinate.get(0).equals(secondCoordinate.get(0)) && !firstCoordinate.get(1).equals(secondCoordinate.get(1))) {
            return coordinates;
        }
        if (!firstCoordinate.get(0).equals(secondCoordinate.get(0))) {
            if((int)firstCoordinate.get(0) > (int)secondCoordinate.get(0)) {
                coordinates = generateStraightCoordinates(secondCoordinate, firstCoordinate, 0);
            }
            if((int)firstCoordinate.get(0) < (int)secondCoordinate.get(0)) {
                coordinates = generateStraightCoordinates(firstCoordinate, secondCoordinate, 0);
            }
        } else if (!firstCoordinate.get(1).equals(secondCoordinate.get(1))) {
            if((int)firstCoordinate.get(1) > (int)secondCoordinate.get(1)) {
                coordinates = generateStraightCoordinates(secondCoordinate, firstCoordinate, 1);
            }
            if((int)firstCoordinate.get(1) < (int)secondCoordinate.get(1)) {
                coordinates = generateStraightCoordinates(firstCoordinate, secondCoordinate, 1);
            }
        } else {

        }
        return coordinates;
    }

    public List<List<Integer>> getDiagonalCoordinates() {
        List<List<Integer>> coordinates = new LinkedList<>();
        int firstDifference = firstCoordinate.get(0) - firstCoordinate.get(1);
        int secondDifference = secondCoordinate.get(1) - secondCoordinate.get(0);
        int firstOtherDifference = firstCoordinate.get(0) - firstCoordinate.get(1);
        int secondOtherDifference = secondCoordinate.get(0) - secondCoordinate.get(1);
        int firstSum = firstCoordinate.get(0) + firstCoordinate.get(1);
        int secondSum = secondCoordinate.get(0) + secondCoordinate.get(1);

        if(firstDifference == secondDifference || firstSum == secondSum || firstOtherDifference == secondOtherDifference) {
            if((int)firstCoordinate.get(0) > (int)secondCoordinate.get(0)) {
                coordinates = generateDiagonalCoordinates(secondCoordinate, firstCoordinate);
            } else {
                coordinates = generateDiagonalCoordinates(firstCoordinate, secondCoordinate);
            }
        }

        return coordinates;
    }

    private List<List<Integer>> generateStraightCoordinates(List<Integer> startingPoint, List<Integer> endPoint, int index) {

        List<List<Integer>> coordinates = new LinkedList();
        int i = 0;
        while(startingPoint.get(index)+i <= endPoint.get(index)) {
            if(index == 0) {
                coordinates.add(Arrays.asList(startingPoint.get(index)+i, startingPoint.get(1)));
            } else {
                coordinates.add(Arrays.asList(startingPoint.get(0), startingPoint.get(index)+i));
            }
            i++;
        }
        return coordinates;
    }

    private List<List<Integer>> generateDiagonalCoordinates(List<Integer> startingPoint, List<Integer> endPoint) {
        List<List<Integer>> coordinates = new LinkedList();
        //if(!startingPoint.get(0).equals(startingPoint.get(1)) || !endPoint.get(0).equals(endPoint.get(1))) {
        if(endPoint.get(0) > startingPoint.get(0) && endPoint.get(1) > startingPoint.get(1)) {
            for (int i = 0; startingPoint.get(0) + i <= endPoint.get(0); i++) {
                coordinates.add(Arrays.asList(startingPoint.get(0) + i, startingPoint.get(1) + i));
            }
        } else {
            for (int i = 0; startingPoint.get(0) + i <= endPoint.get(0); i++) {
                coordinates.add(Arrays.asList(startingPoint.get(0) + i, startingPoint.get(1) - i));
            }
        }
        return coordinates;
    }

}
