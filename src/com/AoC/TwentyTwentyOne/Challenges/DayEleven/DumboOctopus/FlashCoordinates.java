package com.AoC.TwentyTwentyOne.Challenges.DayEleven.DumboOctopus;

import java.util.ArrayList;
import java.util.List;

public class FlashCoordinates {
    public static List<Coordinate> flashCoordinates(int row, int column) {
        List<Coordinate> flashCoordinates = new ArrayList<>();
        boolean leftEdge, rightEdge, topEdge, bottomEdge;
        if (row == 0) {
            topEdge = true;
            bottomEdge = false;
        } else if (row == 9) {
            topEdge = false;
            bottomEdge = true;
        } else {
            topEdge = false;
            bottomEdge = false;
        }
        if (column == 0) {
            leftEdge = true;
            rightEdge = false;
        } else if (column == 9) {
            leftEdge = false;
            rightEdge = true;
        } else {
            leftEdge = false;
            rightEdge = false;
        }
        if (!topEdge) {
            if (!leftEdge) {
                flashCoordinates.add(new Coordinate(row - 1, column - 1));
            }
            flashCoordinates.add(new Coordinate(row - 1, column));
            if (!rightEdge) {
                flashCoordinates.add(new Coordinate(row - 1, column + 1));
            }
        }
        if (!leftEdge) {
            flashCoordinates.add(new Coordinate(row, column - 1));
        }
        if (!rightEdge) {
            flashCoordinates.add(new Coordinate(row, column + 1));
        }
        if (!bottomEdge) {
            if (!leftEdge) {
                flashCoordinates.add(new Coordinate(row + 1, column - 1));
            }
            flashCoordinates.add(new Coordinate(row + 1, column));
            if (!rightEdge) {
                flashCoordinates.add(new Coordinate(row + 1, column + 1));
            }
        }
        return flashCoordinates;
    }
}
