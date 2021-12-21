package com.AoC.TwentyTwentyOne.Challenges.DayTwentyOne.DiracDice;

import java.util.ArrayList;
import java.util.List;

public class DiracDice {
    int playerOne = 0;
    int playerTwo = 0;
    int playerOneScore = 0;
    int playerTwoScore = 0;
    int diceRolls = 0;
    int diceState = 1;

    public DiracDice(int playerOne, int playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public long playWithDeterministicDice() {

        int roll;
        while(1 == 1) {
            // Roll for Player 1
            if(playerOneScore >= 1000 || playerTwoScore >= 1000) {
                break;
            }
            roll = 0;
            for(int i = 0; i < 3; i++) {
                roll += diceState;
                diceState++;
                diceRolls++;
            }
            playerOne += roll;
            while(playerOne > 10) {
                playerOne += -10;
            }
            playerOneScore += playerOne;

            // Roll for Player 2
            if(playerOneScore >= 1000 || playerTwoScore >= 1000) {
                break;
            }
            roll = 0;
            for(int i = 0; i < 3; i++) {
                roll += diceState;
                diceState++;
                diceRolls++;
            }
            playerTwo += roll;
            while(playerTwo > 10) {
                playerTwo += -10;
            }
            playerTwoScore += playerTwo;

        }

        return Math.min(playerOneScore, playerTwoScore) * diceRolls;
    }

    public long playWithQuantumDice() {

        List<GameState> games = new ArrayList<>();
        List<GameState> newGames = new ArrayList<>();

        games.add(new GameState(playerOne, playerOneScore, playerTwo, playerTwoScore, 1));


        while(1 == 1) {
            boolean isDone = true;
            newGames = new ArrayList<>();
            for (GameState gameState : games) {
                for(int i = 1; i < 4; i++) {
                    for (int j = 1; j < 4; j++) {
                        if (gameState.winner == 0) {
                            isDone = false;
                            GameState gS = null;
                            int playerOnePosition = gameState.playerOnePosition;
                            playerOneScore = gameState.playerOneScore;
                            long numberOfGames = gameState.numberOfGames;
                            playerOnePosition += i;
                            while (playerOnePosition > 10) {
                                playerOnePosition += -10;
                            }
                            playerOneScore += playerOnePosition;
                            if (playerOneScore >= 21) {
                                gS = new GameState(playerOnePosition, playerOneScore, gameState.playerTwoPosition, gameState.playerTwoScore, numberOfGames);
                                gS.winner = 1;
                            } else {

                                int playerTwoPosition = gameState.playerTwoPosition;
                                playerTwoScore = gameState.playerTwoScore;
                                playerTwoPosition += j;
                                while (playerTwoPosition > 10) {
                                    playerTwoPosition += -10;
                                }
                                playerTwoScore += playerTwoPosition;


                                gS = new GameState(playerOnePosition, playerOneScore, playerTwoPosition, playerTwoScore, numberOfGames);

                                if(playerTwoScore >= 21) {
                                    gS.winner = 2;
                                }

                            }
                            if (newGames.contains(gS)) {
                                newGames.get(newGames.indexOf(gS)).numberOfGames += numberOfGames;
                            } else {
                                newGames.add(gS);
                            }
                        } else {
                            if (newGames.contains(gameState)) {
                                newGames.get(newGames.indexOf(gameState)).numberOfGames += gameState.numberOfGames;
                            } else {
                                newGames.add(gameState);
                            }
                        }
                    }
                }
            }
            games = newGames;
            if(isDone) {
                break;
            }
        }
        long playerOneWins = 0;
        long playerTwoWins = 0;
        for(GameState gameState: games) {
            if(gameState.winner == 1) {
                playerOneWins += gameState.numberOfGames;
            } else {
                playerTwoWins += gameState.numberOfGames;
            }
        }

        System.out.println(playerOneWins);
        System.out.println(playerTwoWins);

        return Math.max(playerOneWins, playerTwoWins);
    }
}
