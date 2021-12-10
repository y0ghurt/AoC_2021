package com.AoC.TwentyTwentyOne.Challenges.DayTen;

import com.AoC.TwentyTwentyOne.Challenges.DayTen.SyntaxScoring.SyntaxChunk;
import com.AoC.TwentyTwentyOne.Challenges.DayTen.SyntaxScoring.SyntaxLine;

import java.io.File;
import java.util.*;

public class DayTen {
    public static void dayTen() {
        File file = new File("resources/d10_input.txt");
        SyntaxLine syntaxLine;
        List<List<Integer>> heightMap = new ArrayList<>();
        System.out.println();
        int score = 0;

        // Day 10: First assignment
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()) {
                syntaxLine = new SyntaxLine(scanner.nextLine());
                SyntaxChunk chunk = syntaxLine.checkLineSimplified();
                if(chunk.status == SyntaxChunk.ChunkStatus.CORRUPTED) {
                    char c = chunk.getChunkType();
                    if(c == ')') {
                        score += 3;
                    } else if (c == ']') {
                        score += 57;
                    } else if (c == '}') {
                        score += 1197;
                    } else if (c == '>') {
                        score += 25137;
                    }
                }
            }

            System.out.println("-= Day 10: First challenge =-");
            System.out.println("Syntax Error Score is: " + score);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        // Day 10: Second assignment
        try {
            Scanner scanner = new Scanner(file);
            List<Long> inCompleteScores = new LinkedList<>();
            while(scanner.hasNextLine()) {
                syntaxLine = new SyntaxLine(scanner.nextLine());
                SyntaxChunk chunk = syntaxLine.checkLineSimplified();
                if(chunk.status == SyntaxChunk.ChunkStatus.INCOMPLETE) {

                    char c;
                    int charScore = 0;
                    String scoreString = chunk.syntaxCompletion;
                    long inCompleteScore = 0;
                    for(int i = 0; i < scoreString.length(); i++) {
                        c = scoreString.charAt(i);
                        if(c == ')') {
                            charScore = 1;
                        } else if (c == ']') {
                            charScore = 2;
                        } else if (c == '}') {
                            charScore = 3;
                        } else if (c == '>') {
                            charScore = 4;
                        }
                        inCompleteScore = inCompleteScore * 5;
                        inCompleteScore += charScore;
                    }
                    inCompleteScores.add(inCompleteScore);
                }
            }
            Collections.sort(inCompleteScores);
            int index = (inCompleteScores.size()-1)/2;
            System.out.println("-= Day 10: second challenge =-");
            System.out.println("Syntax Completion Score is: " + inCompleteScores.get(index));
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }


        System.out.println();

    }
}
