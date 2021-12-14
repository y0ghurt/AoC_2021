package com.AoC.TwentyTwentyOne.Challenges.DayThirteen;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DayThirteen {
    public static void dayThirteen() {
        File file = new File("resources/d13_input.txt");
        List<Integer[]> dots = new ArrayList<>();
        List<String[]> folds = new ArrayList<>();

        // Day 13: First assignment
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(line.matches("[\\d]+,[\\d]+")) {
                    String[] dotString = line.split(",");
                    Integer[] dot = new Integer[2];
                    dot[0] = Integer.parseInt(dotString[0]);
                    dot[1] = Integer.parseInt(dotString[1]);
                    dots.add(dot);
                } else if( line.matches("[a-z\\s]+=[\\d]+")) {
                    String[] fold = line.split("=");
                    fold[0] = fold[0].substring(fold[0].length()-1);
                    folds.add(fold);
                }

            }
            int first = 0;
            for(String[] fold : folds) {
                byte direction = 2;
                int foldLine = Integer.parseInt(fold[1]);

                if(fold[0].equals("x")) {
                    direction = 0;
                } else if(fold[0].equals("y")) {
                    direction = 1;
                }

                for(Integer[] dot : dots) {
                    if(dot[direction] > foldLine) {
                        int movement = dot[direction] - foldLine;
                        dot[direction] = foldLine - movement;
                    }
                }
                boolean inconsistencyFound = false;
                while(1 == 1) {
                    for (int checker = 0; checker < dots.size(); checker++) {
                        for (int iterator = 0; iterator < dots.size(); iterator++) {
                            if (dots.get(checker)[0].equals(dots.get(iterator)[0])) {
                                if (dots.get(checker)[1].equals(dots.get(iterator)[1])) {
                                    if (checker != iterator) {
                                        dots.remove(checker);
                                        inconsistencyFound = true;
                                    }
                                }
                            }
                        }
                    }
                    if(inconsistencyFound) {
                        inconsistencyFound = false;
                    } else {
                        break;
                    }
                }

                if(first == 0) {
                    first = dots.size();
                }

            }

            System.out.println("-= Day 13: First challenge =-");
            System.out.println("Visible dots after first fold: " + first);


            System.out.println("");
            System.out.println("-= Day 13: Second challenge =-");
            System.out.println("Eight letter code: ");
            visualize(dots);
            System.out.println("");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

    }

    private static void visualize(List<Integer[]> dots) {
        int height = 0;
        int width = 0;
        char[][] drawMap;
        int inconsistencies = 0;
        for(Integer[] dot : dots) {
            if(dot[0] > width)
                width = dot[0];
            if(dot[1] > height)
                height = dot[1];
        }
        drawMap = new char[height+1][width+1];
        for (char[] array : drawMap) {
            Arrays.fill(array, ' ');
        }

        for(Integer[] dot : dots) {
            if(drawMap[dot[1]][dot[0]] == ' ')
                drawMap[dot[1]][dot[0]] = '#';
            else {
                drawMap[dot[1]][dot[0]] = '?';
                System.out.println("Inconsistency: " + dot[0] + "," + dot[1]);
                inconsistencies++;
            }
        }
        System.out.println("");
        for(char[] line: drawMap) {
            System.out.println(line);
        }
        System.out.println("");
        System.out.println("Inconsistencies: " + inconsistencies);
        System.out.println("");
    }
}
