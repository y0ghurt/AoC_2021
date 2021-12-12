package com.AoC.TwentyTwentyOne.Challenges.DayEleven;

import com.AoC.TwentyTwentyOne.Challenges.DayEleven.DumboOctopus.Coordinate;
import com.AoC.TwentyTwentyOne.Challenges.DayEleven.DumboOctopus.DumboOctopus;
import com.AoC.TwentyTwentyOne.Challenges.DayEleven.DumboOctopus.FlashCoordinates;

import java.io.File;
import java.util.*;

public class DayEleven {
    public static void dayEleven() {
        File file = new File("resources/d11_input.txt");
        List<DumboOctopus> octopi;
        List<List<DumboOctopus>> dumboOctopusList = new ArrayList<>();
        List<List<Coordinate>> flashListList;
        long flashCounter = 0;

        // Day 11: First assignment
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()) {
                octopi = new ArrayList<>();
                for(char c : scanner.nextLine().toCharArray()) {
                    octopi.add(new DumboOctopus(Integer.parseInt(String.valueOf(c))));
                }
                dumboOctopusList.add(octopi);
            }

            flashListList = new ArrayList<>();
            for(int step = 0; step < 100; step++) {
                for(int row = 0; row < dumboOctopusList.size(); row++) {
                    for(int column = 0; column < dumboOctopusList.get(row).size(); column++) {
                        if(dumboOctopusList.get(row).get(column).increaseEnergy()) {
                            flashListList.add(FlashCoordinates.flashCoordinates(row, column));
                            flashCounter++;
                        }
                    }
                }

                List<List<Coordinate>> nextFlashList = new ArrayList<>();
                while(flashListList.size() > 0) {
                    for(List<Coordinate> coordinateList: flashListList) {
                        for (Coordinate coordinate : coordinateList) {
                            if(dumboOctopusList.get(coordinate.row).get(coordinate.column).flashEnergy()) {
                                nextFlashList.add(FlashCoordinates.flashCoordinates(coordinate.row, coordinate.column));
                                flashCounter++;
                            }
                        }
                    }
                    flashListList = nextFlashList;
                    nextFlashList = new ArrayList<>();
                }
            }

            System.out.println("-= Day 11: First challenge =-");
            System.out.println("Flashes in 100 steps: " + flashCounter);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        // Day 11: Second assignment
        try {
            dumboOctopusList = new ArrayList<>();
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()) {
                octopi = new ArrayList<>();
                for(char c : scanner.nextLine().toCharArray()) {
                    octopi.add(new DumboOctopus(Integer.parseInt(String.valueOf(c))));
                }
                dumboOctopusList.add(octopi);
            }

            int megaFlashStep;
            flashListList = new ArrayList<>();
            for(int step = 0; 1 == 1; step++) {
                for(int row = 0; row < dumboOctopusList.size(); row++) {
                    for(int column = 0; column < dumboOctopusList.get(row).size(); column++) {
                        if(dumboOctopusList.get(row).get(column).increaseEnergy()) {
                            flashListList.add(FlashCoordinates.flashCoordinates(row, column));
                            flashCounter++;
                        }
                    }
                }

                List<List<Coordinate>> nextFlashList = new ArrayList<>();
                while(flashListList.size() > 0) {
                    for(List<Coordinate> coordinateList: flashListList) {
                        for (Coordinate coordinate : coordinateList) {
                            if(dumboOctopusList.get(coordinate.row).get(coordinate.column).flashEnergy()) {
                                nextFlashList.add(FlashCoordinates.flashCoordinates(coordinate.row, coordinate.column));
                                flashCounter++;
                            }
                        }
                    }
                    flashListList = nextFlashList;
                    nextFlashList = new ArrayList<>();
                }

                boolean megaFlash = true;
                for(int row = 0; row < dumboOctopusList.size(); row++) {
                    for(int column = 0; column < dumboOctopusList.get(row).size(); column++) {
                        if(dumboOctopusList.get(row).get(column).getEnergyLevel() != 0) {
                            megaFlash = false;
                        }
                    }
                }
                if(megaFlash) {
                    megaFlashStep = step + 1;
                    break;
                }
            }

            System.out.println("-= Day 11: Second challenge =-");
            System.out.println("Steps until first synchronized flash: " + megaFlashStep);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

    }
}
