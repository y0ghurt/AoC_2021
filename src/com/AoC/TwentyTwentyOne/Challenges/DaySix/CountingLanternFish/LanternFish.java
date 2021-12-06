package com.AoC.TwentyTwentyOne.Challenges.DaySix.CountingLanternFish;

public class LanternFish {
    int daysUntilReproduction;

    public LanternFish() {
        daysUntilReproduction = 8;
    }

    public LanternFish(int daysUntilReproduction) {
        this.daysUntilReproduction = daysUntilReproduction;
    }

    public boolean doesTheNewDayBringNewChildren() {
        boolean doesTheNewDayBringNewChildren = false;

        if(daysUntilReproduction == 0) {
            daysUntilReproduction = 6;
            doesTheNewDayBringNewChildren = true;
        } else {
            daysUntilReproduction += (-1);
        }

        return doesTheNewDayBringNewChildren;
    }
}
