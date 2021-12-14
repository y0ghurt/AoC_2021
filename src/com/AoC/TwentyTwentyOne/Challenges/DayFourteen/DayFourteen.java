package com.AoC.TwentyTwentyOne.Challenges.DayFourteen;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayFourteen {
    public static void dayFourteen() {
        File file = new File("resources/d14_input.txt");
        String polymer = "";
        List<String[]> insertionRules = new ArrayList<>();
        StringBuilder polymerBuilder;
        long result = 0;
        Map<Character, Long> elementChart = new HashMap<>();


        // Day 14: First assignment
        try {
            Scanner scanner = new Scanner(file);

            if (scanner.hasNextLine()) {
                polymer = scanner.nextLine();
            }
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.length() > 0) {
                    insertionRules.add(line.split("\s->\s"));
                }
            }

            for (int i = 0; i < 10; i++) {
                polymerBuilder = new StringBuilder((polymer.length() * 2) - 1);
                for (int stringIterator = 0; stringIterator < polymer.length() - 1; stringIterator++) {
                    String pair = polymer.substring(stringIterator, stringIterator + 2);
                    for (String[] insertionRule : insertionRules) {
                        if (insertionRule[0].equals(pair)) {
                            polymerBuilder.append(pair.charAt(0));
                            polymerBuilder.append(insertionRule[1]);
                        }
                    }
                }
                polymerBuilder.append(polymer.charAt(polymer.length() - 1));
                polymer = polymerBuilder.toString();
            }

            List<Character> elements = new ArrayList<>();
            for (int i = 0; i < polymer.length(); i++) {
                if (!elements.contains(polymer.charAt(i))) {
                    elements.add(polymer.charAt(i));
                }
            }

            for (Character element : elements) {
                long counter = 0;
                Pattern pattern = Pattern.compile(element.toString());
                Matcher matcher = pattern.matcher(polymer);
                while (matcher.find()) {
                    counter++;
                }
                elementChart.put(element, counter);
            }

            Character maxElement = Collections.max(elementChart.entrySet(), Map.Entry.comparingByValue()).getKey();
            Character minElement = Collections.min(elementChart.entrySet(), Map.Entry.comparingByValue()).getKey();

            result = (elementChart.get(maxElement) - elementChart.get(minElement));

            System.out.println("-= Day 14: First challenge =-");
            System.out.println("Most common minus least common element occurrence after 10 steps: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println();


        // Day 14: Second assignment

        Map<String, Character> rules = new HashMap<>();
        Map<String, Long> pairs = new HashMap<>();
        Map<String, Long> tempPairs = new HashMap<>();
        Map<Character, Long> counter = new HashMap<>();

        try {

            // Preparation
            Scanner scanner = new Scanner(file);

            if (scanner.hasNextLine()) {
                polymer = scanner.nextLine();
            }
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.length() > 0) {
                    String[] rule = line.split("\s->\s");
                    rules.put(rule[0], rule[1].charAt(0));
                    pairs.put(rule[0], 0L);
                    tempPairs.put(rule[0], 0L);
                }
            }
            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Add initial pairs
        for(int i = 0; i < polymer.length() - 1; i++) {
            String tempPolymer = polymer.substring(i, i+2);
            pairs.put(tempPolymer, pairs.get(tempPolymer) + 1);
        }

        // Iterate through pairs and add elements according to rules
        for(int i = 0; i < 40; i++) {
            for(String pairKey: pairs.keySet()) {
                if(pairs.get(pairKey) > 0) {
                    String p1 = "" + pairKey.charAt(0) + rules.get(pairKey);
                    String p2 = "" + rules.get(pairKey) + pairKey.charAt(1);

                    tempPairs.put(p1, tempPairs.get(p1) + pairs.get(pairKey));
                    tempPairs.put(p2, tempPairs.get(p2) + pairs.get(pairKey));
                }
            }
            for(String key : tempPairs.keySet()) {
                pairs.put(key, tempPairs.get(key));
                tempPairs.put(key, 0L);
            }
        }

        // Add final element of original polymer to counter
        counter.put(polymer.charAt(polymer.length() - 1), 1L);

        // Count pairs
        for(String key: pairs.keySet()) {
            counter.putIfAbsent(key.charAt(0), 0L);
            counter.put(key.charAt(0), counter.get(key.charAt(0)) + pairs.get(key));
        }

        // Get the final result
        long newResult = Collections.max(counter.values()) - Collections.min(counter.values());

        System.out.println("-= Day 14: Second challenge =-");
        System.out.println("Most common minus least common element occurrence after 40 steps: " + newResult);


        System.out.println();

    }
}