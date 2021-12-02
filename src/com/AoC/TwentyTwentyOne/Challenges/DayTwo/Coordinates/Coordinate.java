package com.AoC.TwentyTwentyOne.Challenges.DayTwo.Coordinates;

public class Coordinate {
    protected int depth = 0;
    protected int distance = 0;

    public Coordinate() {}

    public void travel(Direction direction, int distance) {
        switch(direction) {
            case forward:
                this.distance += distance;
                break;
            case up:
                this.depth -= distance;
                break;
            case down:
                this.depth += distance;
                break;
            default:
                System.out.println("Invalid input, direction was " + direction.toString());
        }
    }

    public int getDistance() {
        return distance;
    }

    public int getDepth() {
        return depth;
    }
}
