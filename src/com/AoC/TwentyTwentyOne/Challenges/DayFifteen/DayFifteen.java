package com.AoC.TwentyTwentyOne.Challenges.DayFifteen;

import com.AoC.TwentyTwentyOne.Challenges.DayFifteen.RiskAssessment.RiskAssessment;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DayFifteen {
    public static void dayFifteen() {

        // Day 15 - first challenge
        System.out.println();

        List<List<Integer>> riskMap = new ArrayList<>();
        List<List<Integer>> minimalTotalRisk = new ArrayList<>();

        try {
            File file = new File("resources/d15_input.txt");

            Scanner scanner = new Scanner(file);

            int row = 0;
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                riskMap.add(new ArrayList<>());
                minimalTotalRisk.add(new ArrayList<>());
                for(int column = 0; column < line.length(); column++) {
                    riskMap.get(row).add(Integer.parseInt(String.valueOf(line.charAt(column))));
                    minimalTotalRisk.get(row).add(Integer.MAX_VALUE);
                }
                row++;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        RiskAssessment.assessRisks(riskMap, minimalTotalRisk);

        // Visualization of best possible path.
        //for(List row: minimalTotalRisk) {
        //    System.out.println(row);
        //}

        System.out.println();
        System.out.println("-= Day 15: First challenge =-");
        System.out.println("The path with the least total risk has risk level: " + minimalTotalRisk.get(minimalTotalRisk.size()-1).get(minimalTotalRisk.get(minimalTotalRisk.size()-1).size()-1));
        System.out.println();









        // Day 15 - second challenge
        List<List<Integer>> extendedRiskMap = new ArrayList<>();
        List<List<Integer>> extendedMinimumRiskMap = new ArrayList<>();
        int maxValue = 9;

        for(int rowBonus = 0; rowBonus < 5; rowBonus++) {
            for(int row = 0; row < riskMap.size(); row++) {
                extendedRiskMap.add(new ArrayList<>());
                extendedMinimumRiskMap.add(new ArrayList<>());
                for(int columnBonus = 0; columnBonus < 5; columnBonus++) {
                    for(int column = 0; column < riskMap.get(row).size(); column++) {
                        int currValue = (riskMap.get(row).get(column)+rowBonus+columnBonus);
                        while(currValue > maxValue) {
                            currValue = currValue - maxValue;
                        }
                        extendedRiskMap.get(extendedRiskMap.size()-1).add(currValue);
                        extendedMinimumRiskMap.get(extendedMinimumRiskMap.size()-1).add(Integer.MAX_VALUE);
                    }
                }
            }
        }

        RiskAssessment.assessRisks(extendedRiskMap, extendedMinimumRiskMap);

        // Visualization of best possible path.
        //for(List row: extendedMinimumRiskMap) {
        //    System.out.println(row);
        //}

        System.out.println();
        System.out.println("-= Day 15: Second challenge =-");
        System.out.println("The path with the least total risk has risk level: " + extendedMinimumRiskMap.get(extendedMinimumRiskMap.size()-1).get(extendedMinimumRiskMap.get(extendedMinimumRiskMap.size()-1).size()-1));
        System.out.println();

    }
}

