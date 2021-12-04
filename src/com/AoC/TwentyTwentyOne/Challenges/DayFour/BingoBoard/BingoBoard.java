package com.AoC.TwentyTwentyOne.Challenges.DayFour.BingoBoard;

import java.util.LinkedList;
import java.util.List;

public class BingoBoard {
        protected Integer[][] board;
        protected List<Integer> playedNumbers;
        protected boolean[][] hits;
        protected boolean bingo;
        protected int currentNumber = 0;

        public BingoBoard(Integer[][] board) {
            this.board = board;
            hits = new boolean[board.length][board[0].length];
            playedNumbers = new LinkedList<>();
            bingo = false;
        }

        public boolean playNumber(Integer number) {
            boolean numberExists = false;
            playedNumbers.add(number);
            currentNumber = number;

            for(int row = 0; row < board.length; row++) {
                for(int column = 0; column < board[0].length; column++) {
                    if(board[row][column] == number) {
                        hits[row][column] = true;
                        numberExists = true;
                    }
                }
            }

            return numberExists;
        }

        public boolean checkBingo() {
            boolean bingo = false;
            for(int row = 0; row < board.length && !bingo; row++) {
                bingo = true;
                for(int column = 0; column < board[0].length; column++) {
                    bingo = bingo & hits[row][column];
                }
            }

            for(int column = 0; column < board[0].length && !bingo; column++) {
                bingo = true;
                for(int row = 0; row < board.length; row++) {
                    bingo = bingo & hits[row][column];
                }
            }
            this.bingo = bingo;
            return bingo;
        }

        public int calculateScore() {
            int score = 0;
            if(bingo) {
                for(int row = 0; row < board.length; row++) {
                    for(int column = 0; column < board[0].length; column++) {
                        if(!hits[row][column]) {
                            score += board[row][column];
                        }
                    }
                }
            }
            return score * playedNumbers.get(playedNumbers.size()-1);
        }
}
