package com.AoC.TwentyTwentyOne.Challenges.DayThree.Diagnostics;

import java.util.LinkedList;
import java.util.List;

public class OxygenCotwo {
    protected List<String> inputData;
    protected int dataLength;

    public OxygenCotwo(List<String> inputData, int dataLength) {
        this.inputData = inputData;
        this.dataLength = dataLength;
    }

    public int mostCommonNumberOnIndex(List<String> data, int index) {
        int ones = 0;
        int zeroes = 0;
        for (String s : data) {
            if (s.charAt(index) == '1') {
                ones++;
            } else {
                zeroes++;
            }
        }
        if(ones >= zeroes) {
            return 1;
        } else {
            return 0;
        }
    }

    public int mostUncommonNumberOnIndex(List<String> data, int index) {
        int ones = 0;
        int zeroes = 0;
        for (String s : data) {
            if (s.charAt(index) == '1') {
                ones++;
            } else {
                zeroes++;
            }
        }
        if(ones < zeroes) {
            return 1;
        } else {
            return 0;
        }
    }

    public List<String> filterValues(List<String> data, int filterValue, int index) {
        List<String> filteredData = new LinkedList();
        for(String s : data) {
            if(s.charAt(index) == Integer.toString(filterValue).charAt(0)) {
                filteredData.add(s);
            }
        }
        return filteredData;
    }

    public int findCommon() {
        List<String> commonList = inputData;

        int counter = 0;
        int commonValue;
        while(counter < dataLength) {
            commonValue = mostCommonNumberOnIndex(commonList, counter);
            commonList = filterValues(commonList, commonValue, counter);
            counter++;
            if(commonList.size() == 1) {
                return Integer.parseInt(commonList.get(0), 2);
            }
        }

        return Integer.parseInt(commonList.get(0), 2);
    }

    public int findUncommon() {
        List<String> uncommonList = inputData;

        int counter = 0;
        int uncommonValue;
        while(counter < dataLength) {
            uncommonValue = mostUncommonNumberOnIndex(uncommonList, counter);
            uncommonList = filterValues(uncommonList, uncommonValue, counter);
            if(uncommonList.size() == 1) {
                return Integer.parseInt(uncommonList.get(0), 2);
            }
            counter++;
        }

        return Integer.parseInt(uncommonList.get(0), 2);
    }

}
