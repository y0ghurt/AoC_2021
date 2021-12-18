package com.AoC.TwentyTwentyOne.Challenges.DayEighteen;

import com.AoC.TwentyTwentyOne.Challenges.DayEighteen.SnailfishCalculator.Pair;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DayEighteen {
    public static void dayEighteen() {

        File file = new File("resources/d18_input.txt");
        Scanner scanner;
        List<String> calculations = new ArrayList<>();

        try {
            scanner = new Scanner(file);
            while(scanner.hasNextLine()) {
                calculations.add(scanner.nextLine());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        int counter = 0;
        Pair pair = null;
        String calculation = "";
        while(counter < calculations.size()) {
            if(counter == 0) {
                calculation = calculations.get(counter);
            } else {
                calculation = "[" + calculation + "," + calculations.get(counter) + "]";
            }
            // Debug output.
            // System.out.println(calculation);
            pair = new Pair(1, null, calculation);

            calculate(pair);

            calculation = pair.toString();
            counter++;
        }

        System.out.println(calculation);

        long getMagnitude = 0;
        try {
            getMagnitude = pair.getMagnitude();
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }


        System.out.println();
        System.out.println();
        System.out.println("-= Day 18: First challenge =-");
        System.out.println("The magnitude of the calculation is: " + getMagnitude);


        long maxMagnitude = 0;
        for(int i = 0; i < calculations.size(); i++) {
            for(int j = 0; j < calculations.size(); j++) {
                if(i != j) {
                    calculation = "[" + calculations.get(i) + "," + calculations.get(j) + "]";
                    pair = new Pair(1, null, calculation);
                    calculate(pair);
                    long magnitude = pair.getMagnitude();
                    if(magnitude > maxMagnitude) {
                        maxMagnitude = magnitude;
                    }
                }
            }
        }
        System.out.println();
        System.out.println("-= Day 18: Second challenge =-");
        System.out.println("The maximum magnitude of any two additions is: " + maxMagnitude);
    }

    static void calculate(Pair pair) {
        while(pair.toString().matches(".*\\d\\d.*") || Pair.mD > 4) {
            while(Pair.mD > 4) {
                pair.reduceExplode();
                Pair.mD = 0;
                pair.updateMaxDepth();
            }
            pair.reduceSplit();
        }
    }
}
