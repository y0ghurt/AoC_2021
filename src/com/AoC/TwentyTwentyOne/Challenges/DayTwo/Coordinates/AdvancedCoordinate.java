package com.AoC.TwentyTwentyOne.Challenges.DayTwo.Coordinates;

public class AdvancedCoordinate extends Coordinate {
    protected int aim = 0;

    public void travel(Direction direction, int distance) {
        switch(direction) {
            case forward:
                this.distance += distance;
                this.depth += (distance * aim);
                break;
            case up:
                this.aim -= distance;
                break;
            case down:
                this.aim += distance;
                break;
            default:
                System.out.println("Invalid input, direction was " + direction.toString());
        }
    }

    public int getAim() {
        return aim;
    }
}
