package com.AoC.TwentyTwentyOne.Challenges.DayFifteen.RiskAssessment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RiskAssessment {
    public static void assessRisks(List<List<Integer>> riskMap, List<List<Integer>> minimalTotalRisk) {
        boolean somethingChanged = true;
        while(somethingChanged) {
            somethingChanged = false;
            for (int row = 0; row < riskMap.size(); row++) {
                for (int column = 0; column < riskMap.get(row).size(); column++) {

                    List<Integer> surroundingRisks = new ArrayList<>();
                    if (row > 0) {
                        surroundingRisks.add(minimalTotalRisk.get(row - 1).get(column));
                    }
                    if (row < minimalTotalRisk.size() - 1) {
                        surroundingRisks.add(minimalTotalRisk.get(row + 1).get(column));
                    }
                    if (column > 0) {
                        surroundingRisks.add(minimalTotalRisk.get(row).get(column - 1));
                    }
                    if (column < minimalTotalRisk.get(row).size() - 1) {
                        surroundingRisks.add(minimalTotalRisk.get(row).get(column + 1));
                    }
                    int lowestSurroundingRisk = Collections.min(surroundingRisks);
                    int totalMinimalRisk = lowestSurroundingRisk + riskMap.get(row).get(column);
                    if (row == 0 && column == 0) {
                        minimalTotalRisk.get(row).set(column, 0);
                    } else if(totalMinimalRisk < minimalTotalRisk.get(row).get(column)) {
                        somethingChanged = true;
                        minimalTotalRisk.get(row).set(column, totalMinimalRisk);
                    }
                }
            }
        }
    }
}
