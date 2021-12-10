package com.AoC.TwentyTwentyOne.Challenges.DayTen.SyntaxScoring;

import java.util.LinkedList;
import java.util.List;

public class SyntaxLine {
    private String inputString;
    private String debugString = "";
    private int index = 0;

    public SyntaxLine(String inputString) {
        this.inputString = inputString;
    }

    public SyntaxChunk checkLineSimplified() {
        List<Character> remainingSyntax = new LinkedList<>();
        SyntaxChunk chunk;

        for(int i = 0; i < inputString.length(); i++) {
            char character = inputString.charAt(i);
            if (character == '(' || character == '{' || character == '<' || character == '[') {
                remainingSyntax.add(character);
            } else if (character == ')' || character == '}' || character == '>' || character == ']') {
                if(remainingSyntax.size() > 0) {
                    chunk =  new SyntaxChunk(remainingSyntax.get(remainingSyntax.size()-1));
                    if (character == chunk.getChunkType()) {
                        remainingSyntax.remove(remainingSyntax.size()-1);
                    } else {
                        chunk = new SyntaxChunk(character);
                        chunk.status = SyntaxChunk.ChunkStatus.CORRUPTED;
                        return chunk;
                    }
                }
            }
        }
        if(remainingSyntax.size() == 0) {
            chunk = new SyntaxChunk(' ');
            chunk.status = SyntaxChunk.ChunkStatus.OK;
            return chunk;
        } else {
            chunk = new SyntaxChunk(' ');
            chunk.status = SyntaxChunk.ChunkStatus.INCOMPLETE;
            chunk.calculateCompletionString(remainingSyntax);
            return chunk;
        }
    }
}
