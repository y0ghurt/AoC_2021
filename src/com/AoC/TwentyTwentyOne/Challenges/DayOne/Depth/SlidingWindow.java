package com.AoC.TwentyTwentyOne.Challenges.DayOne.Depth;

import java.util.LinkedList;
import java.util.List;

public class SlidingWindow {
    private int windowSize = 1;
    private List<Integer> windowBuffer = new LinkedList();

    public SlidingWindow(int bufferSize) {
        this.windowSize = bufferSize;
    }

    public void addNumber(int currValue) {
        if(windowBuffer.size() >= windowSize) {
            windowBuffer.remove(0);
        }
        windowBuffer.add(currValue);
    }

    public int getWindow() throws Exception {
        int window = 0;

        if(windowBuffer.size() == windowSize) {
            for (int value: windowBuffer) {
                window += value;
            }
        } else {
            throw (new UnsupportedOperationException("Not enough values in buffer"));
        }

        return window;
    }
}
