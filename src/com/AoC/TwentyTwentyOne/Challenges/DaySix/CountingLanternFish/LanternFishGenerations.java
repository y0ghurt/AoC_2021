package com.AoC.TwentyTwentyOne.Challenges.DaySix.CountingLanternFish;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LanternFishGenerations {

    private int currentGeneration = 0;
    private List<LanternFishGeneration> lanternFishGenerations = new LinkedList<>();

    public LanternFishGenerations(List<Integer> originalGenerations) {
        int[] originalFishies = new int[7];
        for(Integer integer: originalGenerations) {
            originalFishies[integer]++;
        }
        int index = 0;
        while(index < originalFishies.length) {
            lanternFishGenerations.add(new LanternFishGeneration(originalFishies[index], index));
            index++;
        }
    }

    public void progressGenerations() {
        long nextGeneration = 0;
        for(LanternFishGeneration lanternFishGeneration: lanternFishGenerations) {
            nextGeneration += lanternFishGeneration.progressGeneration();
        }
        lanternFishGenerations.add(new LanternFishGeneration(nextGeneration, 8));
        currentGeneration++;
    }

    public int getCurrentGeneration() {
        return currentGeneration;
    }

    public long getTotalLanternFish() {
        long totalLanternFish = 0;
        for(LanternFishGeneration lanternFishGeneration: lanternFishGenerations) {
            totalLanternFish += lanternFishGeneration.getPopulation();
        }
        return totalLanternFish;
    }
}
