package com.AoC.TwentyTwentyOne.Challenges.DaySeven.CrabSubs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CrabFuelConsumption {
    protected List<Integer> crabList;

    public CrabFuelConsumption(List<Integer> crabList) {
        this.crabList = crabList;
    }

    public int findLowestFuelConsumption() {
        List<Integer> fuelConsumptions = new ArrayList<>();
        int min = Collections.min(crabList);
        int max = Collections.max(crabList);
        int currentConsumption;
        for(int i = min; i < max; i++) {
            currentConsumption = 0;
            for(Integer crab: crabList) {
                if(crab < i) {
                    currentConsumption += i-crab;
                } else {
                    currentConsumption += crab-i;
                }
            }
            fuelConsumptions.add(currentConsumption);
        }

        return Collections.min(fuelConsumptions);
    }

    public long findActualLowestFuelConsumption() {
        List<Long> fuelConsumptions = new ArrayList<>();
        int min = Collections.min(crabList);
        int max = Collections.max(crabList);
        long currentConsumption;
        for(long i = min; i < max; i++) {
            currentConsumption = 0;
            for(Integer crab: crabList) {
                if(crab < i) {
                    currentConsumption += adjustFuelConsumption(i-crab);
                } else {
                    currentConsumption += adjustFuelConsumption(crab-i);
                }
            }
            fuelConsumptions.add(currentConsumption);
        }

        return Collections.min(fuelConsumptions);
    }

    private long adjustFuelConsumption(long input) {
        long output = 0;

        for(long i = input; i > 0; i += (-1)) {
            output += i;
        }

        return output;
    }
}
