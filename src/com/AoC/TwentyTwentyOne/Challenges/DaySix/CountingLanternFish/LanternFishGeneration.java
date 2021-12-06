package com.AoC.TwentyTwentyOne.Challenges.DaySix.CountingLanternFish;

public class LanternFishGeneration {
    private long population;
    private int daysUntilReproduction;

    public LanternFishGeneration(long population, int daysUntilReproduction) {
        this.population = population;
        this.daysUntilReproduction = daysUntilReproduction;
    }

    public long progressGeneration() {
        if(daysUntilReproduction == 0) {
            daysUntilReproduction = 6;
            return population;
        } else {
            daysUntilReproduction += (-1);
            return 0;
        }
    }

    public long getPopulation() {
        return population;
    }
}
