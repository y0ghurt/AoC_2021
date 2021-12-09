package com.AoC.TwentyTwentyOne.Challenges.DayNine;

import com.AoC.TwentyTwentyOne.Challenges.DayNine.CaveLowPoints.LowPointFinder;

import java.io.File;
import java.util.*;

public class DayNine {
    public static void dayNine() {
        File file = new File("resources/d9_input.txt");
        LowPointFinder lowPointFinder;
        List<List<Integer>> heightMap = new ArrayList<>();
        System.out.println();

        // Day 9: First assignment
        try {
            Scanner scanner = new Scanner(file);
            List<Integer> heightMapRow;
            while(scanner.hasNextLine()) {
                heightMapRow = new ArrayList<>();
                char[] line = scanner.nextLine().toCharArray();
                for(char c: line) {
                    heightMapRow.add(Integer.parseInt(String.valueOf(c)));
                }
                heightMap.add(heightMapRow);
            }

            lowPointFinder = new LowPointFinder(heightMap);
            List<Integer> lowPoints = lowPointFinder.findLowPoints();

            int lowPointsSummed = lowPoints.size();
            for(Integer i: lowPoints) {
                lowPointsSummed += i;
            }

            System.out.println("-= Day 9: First challenge =-");
            System.out.println("The combined risk level of the low points is: " + lowPointsSummed);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        // Day 9: Second assignment

        try {

            lowPointFinder = new LowPointFinder(heightMap);
            List<Integer> basins = lowPointFinder.findBasins();

            Collections.sort(basins);

            System.out.println("-= Day 9: Second challenge =-");
            System.out.println("The answer is: " + (basins.get(0) * basins.get(1) * basins.get(2)));
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }


        System.out.println();

    }
}
