package com.AoC.TwentyTwentyOne.Challenges.DayTwo;

import com.AoC.TwentyTwentyOne.Challenges.DayTwo.Coordinates.AdvancedCoordinate;
import com.AoC.TwentyTwentyOne.Challenges.DayTwo.Coordinates.Coordinate;
import com.AoC.TwentyTwentyOne.Challenges.DayTwo.Coordinates.Direction;

import java.io.File;
import java.util.Scanner;

public class DayTwo {
    public static void dayTwo() {
        // Day 2: First assignment
        Coordinate coordinate = new Coordinate();
        try {
            File file = new File("resources/d2_input.txt");
            Scanner scanner = new Scanner(file);
            String[] array;
            while (scanner.hasNextLine()) {
                array = scanner.nextLine().split("\s");
                coordinate.travel(Direction.valueOf(array[0]), Integer.parseInt(array[1]));
            }
            System.out.println("The current depth is: " + coordinate.getDepth());
            System.out.println("The current distance travelled is: " + coordinate.getDistance());
            System.out.println("The answer to the first task (depth * distance) is: " + (coordinate.getDepth() * coordinate.getDistance()));
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        System.out.println();
        System.out.println();

        // Day 2: Second assignment
        AdvancedCoordinate advancedCoordinate = new AdvancedCoordinate();
        try {
            File file = new File("resources/d2_input.txt");
            Scanner scanner = new Scanner(file);
            String[] array;
            while (scanner.hasNextLine()) {
                array = scanner.nextLine().split("\s");
                advancedCoordinate.travel(Direction.valueOf(array[0]), Integer.parseInt(array[1]));
            }
            System.out.println("The current aim is: " + advancedCoordinate.getAim());
            System.out.println("The current depth is: " + advancedCoordinate.getDepth());
            System.out.println("The current distance travelled is: " + advancedCoordinate.getDistance());
            System.out.println("The answer to the second task (depth * distance) is: " + (advancedCoordinate.getDepth() * advancedCoordinate.getDistance()));
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
