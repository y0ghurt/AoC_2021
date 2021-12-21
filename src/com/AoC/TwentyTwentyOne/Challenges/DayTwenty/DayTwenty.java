package com.AoC.TwentyTwentyOne.Challenges.DayTwenty;

import com.AoC.TwentyTwentyOne.Challenges.DayTwenty.ImageEnhancement.ImageEnhancer;

import java.io.File;
import java.util.*;

public class DayTwenty {
    public static void dayTwenty() {
        File file = new File("resources/d20_input.txt");
        Scanner scanner;
        Map<Integer, Map<Integer, Integer>> initialImage = new HashMap<>();
        Map<Integer, Boolean> enhancementAlgorithm = new HashMap<>();
        Integer infinitePadding = 0;
        Map<Integer, Integer> map = null;

        try {
            scanner = new Scanner(file);
            if(scanner.hasNextLine()) {
                String string = scanner.nextLine();
                for(int i = 0; i < string.length(); i++) {
                    enhancementAlgorithm.put(i, (string.charAt(i) == '#'));
                }
                int row = 0;
                String line = "";
                while(scanner.hasNextLine()) {
                    line = scanner.nextLine();
                    if(line.length() > 0) {
                        if (row == 0) {
                            map = new HashMap<>();
                            for (int column = 0; column < line.length() + 2; column++) {
                                map.put(column, infinitePadding);
                            }
                            initialImage.put(row, map);
                            row++;
                        }
                        map = new HashMap<>();
                        for (int column = 0; column < line.length() + 2; column++) {
                            if (column == 0 || column == line.length() + 1) {
                                map.put(column, infinitePadding);
                            } else {
                                if (line.charAt(column-1) == '#') {
                                    map.put(column, 1);
                                } else {
                                    map.put(column, 0);
                                }
                            }
                        }
                        initialImage.put(row, map);
                        row++;

                    }
                }
                map = new HashMap<>();
                for (int column = 0; column < line.length() + 2; column++) {
                    map.put(column, infinitePadding);
                }
                initialImage.put(row, map);
            }

            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(line.length() > 0) {

                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        Map<Integer, Map<Integer, Integer>> image = new HashMap<>();
        for(int r = 0; r < initialImage.size(); r++) {
            image.put(r, initialImage.get(r));
        }


        ImageEnhancer imageEnhancer = new ImageEnhancer(enhancementAlgorithm, infinitePadding);
        System.out.println();
        for(Integer row: image.keySet()) {
            StringBuilder stringBuilder = new StringBuilder("");
            for(Integer column: image.get(row).keySet()) {
                stringBuilder.append((image.get(row).get(column) == 0) ? "." : "#");
            }
            System.out.println(stringBuilder.toString());
        }
        image = imageEnhancer.enhanceImage(image);
        System.out.println();

        System.out.println();
        for(Integer row: image.keySet()) {
            StringBuilder stringBuilder = new StringBuilder("");
            for(Integer column: image.get(row).keySet()) {
                stringBuilder.append((image.get(row).get(column) == 0) ? "." : "#");
            }
            System.out.println(stringBuilder.toString());
        }
        System.out.println();
        image = imageEnhancer.enhanceImage(image);
        System.out.println();
        for(Integer row: image.keySet()) {
            StringBuilder stringBuilder = new StringBuilder("");
            for(Integer column: image.get(row).keySet()) {
                stringBuilder.append((image.get(row).get(column) == 0) ? "." : "#");
            }
            System.out.println(stringBuilder.toString());
        }
        System.out.println();

        int litPixels = 0;
        for(int row = 0; row < image.size(); row++) {
            for(int column = 0; column < image.get(row).size(); column++) {
                litPixels += image.get(row).get(column);
            }
        }

        System.out.println();
        System.out.println("-= Day 20: First challenge =-");
        System.out.println("The number of lit pixels after 2 iterations: " + litPixels);
        System.out.println();

        image = initialImage;

        for(int i = 0; i < 50; i++) {
            image = imageEnhancer.enhanceImage(image);
        }

        litPixels = 0;
        for(int row = 0; row < image.size(); row++) {
            for(int column = 0; column < image.get(row).size(); column++) {
                litPixels += image.get(row).get(column);
            }
        }

        System.out.println();
        System.out.println("-= Day 20: Second challenge =-");
        System.out.println("The number of lit pixels after 50 iterations: " + litPixels);
        System.out.println();

    }
}
