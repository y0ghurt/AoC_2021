package com.AoC.TwentyTwentyOne.Challenges.DayThree;

import com.AoC.TwentyTwentyOne.Challenges.DayThree.Diagnostics.OxygenCotwo;
import com.AoC.TwentyTwentyOne.Challenges.DayThree.Diagnostics.PowerConsumption;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DayThree {
    public static void dayThree() {

        System.out.println();

        // Day 3: First assignment
        try {
            File file = new File("resources/d3_input.txt");
            Scanner scanner = new Scanner(file);
            List<String> data = new LinkedList();
            while (scanner.hasNextLine()) {
                data.add(scanner.nextLine());
            }

            PowerConsumption powerConsumption = new PowerConsumption(12);
            powerConsumption.countNumbers(data);

            System.out.println("-= Day 3: First challenge =-");
            System.out.println("Gamma value:   " + Integer.parseInt(powerConsumption.getCommonData(), 2));
            System.out.println("Epsilon value: " + Integer.parseInt(powerConsumption.getUnCommonData(), 2));
            System.out.println("The answer to the first task (Gamma * Epsilon) is: " +
                    (Integer.parseInt(powerConsumption.getCommonData(), 2) * Integer.parseInt(powerConsumption.getUnCommonData(), 2)));
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        // Day 3: Second assignment
        try {
            File file = new File("resources/d3_input.txt");
            Scanner scanner = new Scanner(file);
            List<String> data = new LinkedList();
            while (scanner.hasNextLine()) {
                data.add(scanner.nextLine());
            }

            OxygenCotwo oxygenCotwo = new OxygenCotwo(data, 12);

            System.out.println("-= Day 3: Second challenge =-");
            System.out.println("O2 value:  " + oxygenCotwo.findCommon());
            System.out.println("CO2 value: " + oxygenCotwo.findUncommon());
            System.out.println("Life support rating: " + (oxygenCotwo.findCommon() * oxygenCotwo.findCommon()));
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
