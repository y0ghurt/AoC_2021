package com.AoC.TwentyTwentyOne.Challenges.DaySix;

import com.AoC.TwentyTwentyOne.Challenges.DaySix.CountingLanternFish.LanternFish;
import com.AoC.TwentyTwentyOne.Challenges.DaySix.CountingLanternFish.LanternFishGenerations;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DaySix {
    public static void daySix() {
        File file = new File("resources/d6_input.txt");
        List<LanternFish> lanternFishList = new LinkedList<>();

        System.out.println();

        // Day 6: First assignment
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()) {
                for(String fish: scanner.nextLine().split(",")) {
                    lanternFishList.add(new LanternFish(Integer.parseInt(fish)));
                }
            }

            for(int days = 0; days < 80; days++) {
                int newFishCounter = 0;
                for (LanternFish lanternFish : lanternFishList) {
                    if (lanternFish.doesTheNewDayBringNewChildren()) {
                        newFishCounter++;
                    }
                }

                for (int i = 0; i < newFishCounter; i++) {
                    lanternFishList.add(new LanternFish());
                }
            }

            System.out.println("-= Day 6: Second challenge =-");
            System.out.println("The amount of Lanternfish after 80 days is: " + lanternFishList.size());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        // Day 6: Second assignment
        try {
            Scanner scanner = new Scanner(file);
            List<Integer> fishList = new LinkedList<>();
            while(scanner.hasNextLine()) {
                for(String fish: scanner.nextLine().split(",")) {
                    fishList.add(Integer.parseInt(fish));
                }
            }

            LanternFishGenerations lanternFishGenerations = new LanternFishGenerations(fishList);
            for(int i = 0; i < 256; i++) {
                lanternFishGenerations.progressGenerations();
            }

            System.out.println("-= Day 6: Second challenge =-");
            System.out.println("The amount of Lanternfish after 256 days is: " + lanternFishGenerations.getTotalLanternFish());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
    }
}
