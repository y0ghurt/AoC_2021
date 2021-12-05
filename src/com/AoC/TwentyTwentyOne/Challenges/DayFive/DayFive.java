package com.AoC.TwentyTwentyOne.Challenges.DayFive;

import com.AoC.TwentyTwentyOne.Challenges.DayFive.HydroThermalVents.HydroThermalVent;
import com.AoC.TwentyTwentyOne.Challenges.DayFive.HydroThermalVents.HydroThermalVentMap;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DayFive {
    public static void dayFive() {
        File file = new File("resources/d5_input.txt");
        List<HydroThermalVent> hydroThermalVents = new LinkedList<>();
        HydroThermalVentMap hydroThermalVentMap = new HydroThermalVentMap();

        System.out.println();

        // Day 5: First assignment
        try {
            Scanner scanner = new Scanner(file);
            List<Integer> firstCoordinate;
            List<Integer> secondCoordinate;
            String[] string;
            while(scanner.hasNextLine()) {
                firstCoordinate = new ArrayList<>();
                secondCoordinate = new ArrayList<>();
                string = scanner.nextLine().split("\s->\s");
                for(String s: string[0].split(",")) {
                    firstCoordinate.add(Integer.parseInt(s));
                }
                for(String s: string[1].split(",")) {
                    secondCoordinate.add(Integer.parseInt(s));
                }
                hydroThermalVents.add(new HydroThermalVent(firstCoordinate, secondCoordinate));
            }

            for(HydroThermalVent hydroThermalVent: hydroThermalVents) {
                hydroThermalVentMap.addCoordinates(hydroThermalVent.getStraightCoordinates());
            }

            System.out.println("-= Day 5: First challenge =-");
            System.out.println("The number of straight hydrothermal vent overlaps is: " + hydroThermalVentMap.getDangerousCoordinateCount());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        // Day 5: Second assignment
        try {
            for(HydroThermalVent hydroThermalVent: hydroThermalVents) {
                hydroThermalVentMap.addCoordinates(hydroThermalVent.getDiagonalCoordinates());
            }

            System.out.println("-= Day 5: First challenge =-");
            System.out.println("The number of straight and diagonal hydrothermal vent overlaps is: " + hydroThermalVentMap.getDangerousCoordinateCount());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
    }
}
