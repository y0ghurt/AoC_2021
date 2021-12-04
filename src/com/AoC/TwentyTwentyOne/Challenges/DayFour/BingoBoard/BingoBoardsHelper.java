package com.AoC.TwentyTwentyOne.Challenges.DayFour.BingoBoard;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BingoBoardsHelper {

    List<BingoBoard> boards;
    List<Integer> numbers;

    public BingoBoardsHelper(List<BingoBoard> boards, List<Integer> numbers) {
        this.boards = boards;
        this.numbers = numbers;
    }

    public int playBingo() {
        for(Integer number: numbers) {
            for(BingoBoard bingoBoard: boards) {
                if(bingoBoard.playNumber(number)) {
                    if(bingoBoard.checkBingo()) {
                        return bingoBoard.calculateScore();
                    }
                }
            }
        }
        return 0;
    }

    public int playBingoToLose() {
        List<BingoBoard> losingBoards = boards;
        for(Integer number: numbers) {
            List<Integer> winningBoards = new LinkedList<>();
            Iterator<BingoBoard> iterator = losingBoards.iterator();
            while(iterator.hasNext()) {
                BingoBoard bingoBoard = iterator.next();
                if(bingoBoard.playNumber(number)) {
                    if(bingoBoard.checkBingo()) {
                        if(losingBoards.size() > 1) {
//                            winningBoards.add(losingBoards.indexOf(bingoBoard));
                            iterator.remove();
                        } else {
                            return bingoBoard.calculateScore();
                        }
                    }
                }
            }
/*            for(Integer i: winningBoards) {
                losingBoards.remove(i);
            }*/
        }
        return 0;
    }

}
