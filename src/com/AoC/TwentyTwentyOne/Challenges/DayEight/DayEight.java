package com.AoC.TwentyTwentyOne.Challenges.DayEight;

import com.AoC.TwentyTwentyOne.Challenges.DayEight.DecodeScreens.ScreenConfiguration;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DayEight {
    public static void dayEight() {
        File file = new File("resources/d8_input.txt");
        List<ScreenConfiguration> screenConfigurations = new LinkedList<>();
        List<List<Integer>> outputList = new LinkedList<>();

        System.out.println();

        // Day 8: First assignment
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split("\s\\|\s");
                screenConfigurations.add(new ScreenConfiguration(line[0].split("\s"), line[1].split("\s")));
            }

            for(ScreenConfiguration screenConfiguration: screenConfigurations) {
                outputList.add(screenConfiguration.decodeDigits());
            }

            int counter = 0;

            for(List<Integer> output: outputList) {
                for(Integer value: output) {
                    if(value == 1 || value == 4 || value == 7 || value == 8) {
                        counter++;
                    }
                }
            }

            System.out.println("-= Day 8: First challenge =-");
            System.out.println("The number of occurences of numbers 1, 4, 7 and 8 is: " + counter);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        // Day 8: Second assignment


        try {
            int sum = 0;
            for(ScreenConfiguration screenConfiguration: screenConfigurations) {
                sum += screenConfiguration.decodeValue();
            }

            System.out.println("-= Day 8: Second challenge =-");
            System.out.println("The sum of all decoded values is: " + sum);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }


        System.out.println();
    }
}
