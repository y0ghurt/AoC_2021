package com.AoC.TwentyTwentyOne.Challenges.DayEleven.DumboOctopus;

public class DumboOctopus {
    private int energyLevel;

    public DumboOctopus(int energyLevel) {
        this.energyLevel = energyLevel;
    }

    public boolean increaseEnergy() {
        energyLevel++;
        if(energyLevel == 10) {
            energyLevel += (-10);
            return true;
        }
        return false;
    }

    public boolean flashEnergy() {
        if(energyLevel != 0) {
            return increaseEnergy();
        }
        return false;
    }

    public int getEnergyLevel() {
        return energyLevel;
    }
}
