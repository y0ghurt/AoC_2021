package com.AoC.TwentyTwentyOne.Challenges.DayThree.Diagnostics;

import java.util.List;

public class PowerConsumption {
    protected int dataLength;
    protected int[] ones;
    protected int[] zeroes;

    public PowerConsumption(int dataLength) {
        this.dataLength = dataLength;
        ones = new int[dataLength];
        zeroes = new int[dataLength];
    }

    public void countNumbers(List<String> inputData) {
        int counter;
        for (String s: inputData) {
            counter = 0;
            while(counter < dataLength) {
                if(s.charAt(counter) == '1') {
                    ones[counter]++;
                } else {
                    zeroes[counter]++;
                }
                counter++;
            }
        }
    }

    public String getCommonData() {
        String commonData = "";
        int counter = 0;
        while(counter < dataLength) {
            if(ones[counter] > zeroes[counter]) {
                commonData += "1";
            } else {
                commonData += "0";
            }
            counter++;
        }
        return commonData;
    }

    public String getUnCommonData() {
        String unCommonData = "";
        int counter = 0;
        while(counter < dataLength) {
            if(ones[counter] < zeroes[counter]) {
                unCommonData += "1";
            } else {
                unCommonData += "0";
            }
            counter++;
        }
        return unCommonData;
    }

}
