package com.AoC.TwentyTwentyOne.Challenges.DayTwentyOne;

import com.AoC.TwentyTwentyOne.Challenges.DayTwentyOne.DiracDice.DiracDice;

import java.io.File;
import java.util.Scanner;

public class DayTwentyOne {
    public static void dayTwentyOne() {


        File file = new File("resources/d21_input.txt");
        Scanner scanner;
        Integer[] players = new Integer[2];

        try {
            scanner = new Scanner(file);
            int playerCounter = 0;
            while(scanner.hasNextLine()) {
                String string = scanner.nextLine();
                string = string.substring(string.length()-1);
                players[playerCounter] = Integer.parseInt(string);
                playerCounter++;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("-= Day 21: First challenge =-");
        System.out.println("An arbitrary number representing the losing score multiplied by the number of dice rolls: " + new DiracDice(players[0], players[1]).playWithDeterministicDice());


        long winningUniverses = new DiracDice(players[0], players[1]).playWithQuantumDice();

        System.out.println();
        System.out.println("-= Day 21: Second challenge =-");
        System.out.println("The most universy winny guy wins in: " + winningUniverses + " universes");
        System.out.println();
    }
}
