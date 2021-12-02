package com.AoC.TwentyTwentyOne.Challenges.DayOne;

import com.AoC.TwentyTwentyOne.Challenges.DayOne.Depth.DepthMeasurements;
import com.AoC.TwentyTwentyOne.Challenges.DayOne.Depth.SlidingWindow;

import java.io.File;
import java.util.Scanner;

public class DayOne {
    public static void dayOne() {

        System.out.println();

        // Day 1: First assignment
        DepthMeasurements depthMeasurements = new DepthMeasurements();
            try {
            File file = new File("resources/d1_input.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextInt()) {
                depthMeasurements.addMeasurement(scanner.nextInt());
            }
            System.out.println("-= Day 1: First challenge =-");
            System.out.println("Total number of rows: " + depthMeasurements.getNumberOfMeasurements());
            System.out.println("The number of depth increases (and thus the answer to the first challenge) is: " + depthMeasurements.getTimesLarger());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        // Day 1: Second assignment
        SlidingWindow slidingWindow = new SlidingWindow(3);
            depthMeasurements.reset();
            try {
            File file = new File("resources/d1_input.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextInt()) {
                slidingWindow.addNumber(scanner.nextInt());
                try {
                    depthMeasurements.addMeasurement(slidingWindow.getWindow());
                } catch(UnsupportedOperationException uoe) {
                    // Do nothing.
                } catch(Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.println("-= Day 2: Second challenge =-");
            System.out.println("Total number of sliding windows: " + depthMeasurements.getNumberOfMeasurements());
            System.out.println("The number of sliding window depth increases (answer) is: " + depthMeasurements.getTimesLarger());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
