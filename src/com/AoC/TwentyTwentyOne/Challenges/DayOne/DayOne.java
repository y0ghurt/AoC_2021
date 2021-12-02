package com.AoC.TwentyTwentyOne.Challenges.DayOne;

import com.AoC.TwentyTwentyOne.Challenges.DayOne.Depth.DepthMeasurements;
import com.AoC.TwentyTwentyOne.Challenges.DayOne.Depth.SlidingWindow;

import java.io.File;
import java.util.Scanner;

public class DayOne {
    public static void dayOne() {
        // Day 1: First assignment
        DepthMeasurements depthMeasurements = new DepthMeasurements();
            try {
            File file = new File("resources/d1_input.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextInt()) {
                depthMeasurements.addMeasurement(scanner.nextInt());
            }
            System.out.println("The number of depth increases is: " + depthMeasurements.getTimesLarger());
            System.out.println("Total number of rows: " + depthMeasurements.getNumberOfMeasurements());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

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
                } catch(Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.println("The number of sliding window depth increases is: " + depthMeasurements.getTimesLarger());
            System.out.println("Total number of sliding windows: " + depthMeasurements.getNumberOfMeasurements());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
