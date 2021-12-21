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
        /*
        1           2           3
        1   2   3   1   2   3   1   2   3
        123 123 123 123 123 123 123 123 123
        345 456 567 456 567 678 567 678 789

        3 444 555555 6666666 777777 888 9
        */
        List<GameState> gSs = null;
        while(1 == 1) {
            boolean isDone = true;
            newGames = new ArrayList<>();
            for (GameState gameState : games) {
                gSs = new ArrayList<>();
                if (gameState.winner == 0) {
                    isDone = false;

                    gSs.add(progressPlayerOneGameState(gameState, 3, 1));
                    gSs.add(progressPlayerOneGameState(gameState, 4, 3));
                    gSs.add(progressPlayerOneGameState(gameState, 5, 6));
                    gSs.add(progressPlayerOneGameState(gameState, 6, 7));
                    gSs.add(progressPlayerOneGameState(gameState, 7, 6));
                    gSs.add(progressPlayerOneGameState(gameState, 8, 3));
                    gSs.add(progressPlayerOneGameState(gameState, 9, 1));

                    for (GameState gS : gSs) {
                        if (newGames.contains(gS)) {
                            newGames.get(newGames.indexOf(gS)).numberOfGames += gS.numberOfGames;
                        } else {
                            newGames.add(gS);
                        }
                    }
                } else {
                    if (newGames.contains(gameState)) {
                        newGames.get(newGames.indexOf(gameState)).numberOfGames += gameState.numberOfGames;
                    } else {
                        newGames.add(gameState);
                    }
                }
            }
            games = newGames;

            newGames = new ArrayList<>();
            for (GameState gameState : games) {
                gSs = new ArrayList<>();
                if (gameState.winner == 0) {
                    isDone = false;

                    gSs.add(progressPlayerTwoGameState(gameState, 3, 1));
                    gSs.add(progressPlayerTwoGameState(gameState, 4, 3));
                    gSs.add(progressPlayerTwoGameState(gameState, 5, 6));
                    gSs.add(progressPlayerTwoGameState(gameState, 6, 7));
                    gSs.add(progressPlayerTwoGameState(gameState, 7, 6));
                    gSs.add(progressPlayerTwoGameState(gameState, 8, 3));
                    gSs.add(progressPlayerTwoGameState(gameState, 9, 1));

                    for (GameState gS : gSs) {
                        if (newGames.contains(gS)) {
                            newGames.get(newGames.indexOf(gS)).numberOfGames += gS.numberOfGames;
                        } else {
                            newGames.add(gS);
                        }
                    }
                } else {
                    if (newGames.contains(gameState)) {
                        newGames.get(newGames.indexOf(gameState)).numberOfGames += gameState.numberOfGames;
                    } else {
                        newGames.add(gameState);
                    }
                }
            }
            games = newGames;
            if (isDone) {
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

        return Math.max(playerOneWins, playerTwoWins);
    }

    private GameState progressPlayerOneGameState(GameState gameState, int steps, int growthFactor) {
        GameState gS = new GameState(gameState.playerOnePosition, gameState.playerOneScore, gameState.playerTwoPosition, gameState.playerTwoScore, gameState.numberOfGames);

        gS.playerOnePosition += steps;
        while(gS.playerOnePosition > 10) {
            gS.playerOnePosition += -10;
        }

        gS.playerOneScore += gS.playerOnePosition;
        if(gS.playerOneScore >= 21) {
            gS.winner = 1;
        }

        gS.numberOfGames = gS.numberOfGames * growthFactor;

        return gS;
    }

    private GameState progressPlayerTwoGameState(GameState gameState, int steps, int growthFactor) {
        GameState gS = new GameState(gameState.playerOnePosition, gameState.playerOneScore, gameState.playerTwoPosition, gameState.playerTwoScore, gameState.numberOfGames);

        gS.playerTwoPosition += steps;
        while(gS.playerTwoPosition > 10) {
            gS.playerTwoPosition += -10;
        }

        gS.playerTwoScore += gS.playerTwoPosition;
        if(gS.playerTwoScore >= 21) {
            gS.winner = 2;
        }

        gS.numberOfGames = gS.numberOfGames * growthFactor;

        return gS;
    }
}
