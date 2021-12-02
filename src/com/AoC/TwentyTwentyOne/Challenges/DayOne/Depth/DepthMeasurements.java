package com.AoC.TwentyTwentyOne.Challenges.DayOne.Depth;

public class DepthMeasurements {
    private int lastValue = 0;
    private int timesLarger = 0;
    private int timesSmaller = 0;
    private int numberOfMeasurements = 0;

    public DepthMeasurements() {}

    public void addMeasurement(int currValue) {
        if(numberOfMeasurements > 0) {
            if (currValue > lastValue) {
                timesLarger++;
            } else if (currValue < lastValue) {
                timesSmaller++;
            }
        }
        lastValue = currValue;
        numberOfMeasurements++;
    }

    public int getTimesLarger() {
        return timesLarger;
    }

    public int getTimesSmaller() {
        return timesSmaller;
    }

    public int getNumberOfMeasurements() {
        return numberOfMeasurements;
    }

    public void reset() {
        lastValue = 0;
        timesLarger = 0;
        timesSmaller = 0;
        numberOfMeasurements = 0;
    }
}
