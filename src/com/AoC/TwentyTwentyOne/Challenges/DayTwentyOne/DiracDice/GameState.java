package com.AoC.TwentyTwentyOne.Challenges.DayTwentyOne.DiracDice;

public class GameState {
    public int playerOnePosition;
    public int playerOneScore;
    public int playerTwoPosition;
    public int playerTwoScore;
    public long numberOfGames = 0;
    public int winner = 0;

    public GameState(int playerOnePosition, int playerOneScore, int playerTwoPosition, int playerTwoScore, long numberOfGames) {
        this.playerOnePosition = playerOnePosition;
        this.playerOneScore = playerOneScore;
        this.playerTwoPosition = playerTwoPosition;
        this.playerTwoScore = playerTwoScore;
        this.numberOfGames = numberOfGames;
    }

    @Override
    public boolean equals(Object o) {

        if(o == this) {
            return true;
        }

        if(!(o instanceof GameState)) {
            return false;
        }

        if(playerOnePosition == ((GameState)o).playerOnePosition
        && playerTwoPosition == ((GameState)o).playerTwoPosition
        && playerOneScore == ((GameState)o).playerOneScore
        && playerTwoScore == ((GameState)o).playerTwoScore
        && winner == ((GameState)o).winner) {
            return true;
        }

        return false;
    }
}
