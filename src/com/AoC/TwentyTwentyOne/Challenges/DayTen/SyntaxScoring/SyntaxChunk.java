package com.AoC.TwentyTwentyOne.Challenges.DayTen.SyntaxScoring;

import java.util.List;

public class SyntaxChunk {
    private char chunkType;
    public String syntaxCompletion = "";
    public ChunkStatus status = ChunkStatus.UNKNOWN;

    public SyntaxChunk(char chunkType) {
        this.chunkType = chunkType;
    }

    public char getChunkType() {
        if (chunkType == '<') {
            return '>';
        } else if (chunkType == '(') {
            return ')';
        } else if (chunkType == '[') {
            return ']';
        } else if (chunkType == '{') {
            return '}';
        }
        return chunkType;
    }

    public void calculateCompletionString(List<Character> remainingSyntax) {
        for(int i = 1; remainingSyntax.size()-i >= 0; i++) {
            chunkType = remainingSyntax.get(remainingSyntax.size()-i);
            syntaxCompletion += getChunkType();
        }
    }

    public enum ChunkStatus {
        OK,
        CORRUPTED,
        INCOMPLETE,
        UNKNOWN
    }
}
