package com.AoC.TwentyTwentyOne.Challenges.DayFour;

import com.AoC.TwentyTwentyOne.Challenges.DayFour.BingoBoard.BingoBoard;
import com.AoC.TwentyTwentyOne.Challenges.DayFour.BingoBoard.BingoBoardsHelper;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DayFour {
    public static void dayFour() {
        File file = new File("resources/d4_input.txt");
        List<BingoBoard> boards = new LinkedList();
        List<Integer> numbers = new LinkedList();
        BingoBoardsHelper bingoBoardsHelper;

        System.out.println();

        // Day 4: First assignment
        try {
            Scanner scanner = new Scanner(file);
            for(String s: scanner.nextLine().split(",")) {
                numbers.add(Integer.parseInt(s));
            }
            String boardString;
            int counter = 0;
            Integer[][] board = new Integer[5][5];
            while (scanner.hasNextLine()) {
                boardString = scanner.nextLine();
                if(boardString.length() > 0) {
                    int i = 0;
                    String[] values = boardString.trim().split("\s+");
                    for(String value : values) {
                        board[counter][i] = Integer.parseInt(value);
                        i++;
                    }
                    counter++;
                } else {
                    if(counter == 5) {
//                        bingoBoard = new BingoBoard(board);
                        boards.add(new BingoBoard(board));
                        board = new Integer[5][5];
                    }
                    counter = 0;
                }
            }

            bingoBoardsHelper = new BingoBoardsHelper(boards, numbers);

            System.out.println("-= Day 4: First challenge =-");
            System.out.println("The score of the winning Bingo Board is: " + bingoBoardsHelper.playBingo());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        // Day 4: Second assignment
        try {
            Scanner scanner = new Scanner(file);
            for(String s: scanner.nextLine().split(",")) {
                numbers.add(Integer.parseInt(s));
            }
            String boardString;
            int counter = 0;
            Integer[][] board = new Integer[5][5];
            while (scanner.hasNextLine()) {
                boardString = scanner.nextLine();
                if(boardString.length() > 0) {
                    int i = 0;
                    String[] values = boardString.trim().split("\s+");
                    for(String value : values) {
                        board[counter][i] = Integer.parseInt(value);
                        i++;
                    }
                    counter++;
                } else {
                    if(counter == 5) {
//                        bingoBoard = new BingoBoard(board);
                        boards.add(new BingoBoard(board));
                        board = new Integer[5][5];
                    }
                    counter = 0;
                }
            }

            bingoBoardsHelper = new BingoBoardsHelper(boards, numbers);

            System.out.println("-= Day 4: Second challenge =-");
            System.out.println("The score of the losing Bingo Board is: " + bingoBoardsHelper.playBingoToLose());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
