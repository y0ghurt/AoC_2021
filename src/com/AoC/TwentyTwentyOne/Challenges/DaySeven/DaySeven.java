package com.AoC.TwentyTwentyOne.Challenges.DaySeven;

import com.AoC.TwentyTwentyOne.Challenges.DaySeven.CrabSubs.CrabFuelConsumption;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DaySeven {
    public static void daySeven() {
        File file = new File("resources/d7_input.txt");
        List<Integer> crabList = new LinkedList<>();
        CrabFuelConsumption crabFuelConsumption;

        System.out.println();

        // Day 7: First assignment
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()) {
                for(String crab: scanner.nextLine().split(",")) {
                    crabList.add(Integer.parseInt(crab));
                }
            }

            crabFuelConsumption = new CrabFuelConsumption(crabList);

            System.out.println("-= Day 7: First challenge =-");
            System.out.println("The lowest possible amount of fuel needed to align crabs is: " + crabFuelConsumption.findLowestFuelConsumption());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        // Day 7: Second assignment

        try {
            crabFuelConsumption = new CrabFuelConsumption(crabList);

            System.out.println("-= Day 7: Second challenge =-");
            System.out.println("The lowest possible amount of fuel needed to align crabs is: " + crabFuelConsumption.findActualLowestFuelConsumption());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
    }
}
