package com.AoC.TwentyTwentyOne.Challenges.DayTwenty.ImageEnhancement;

import java.util.HashMap;
import java.util.Map;

public class ImageEnhancer {
    Map<Integer, Map<Integer, Integer>> outputImage;
    Map<Integer, Boolean> enhancementAlgorithm;
    int infinitePadding = 0;


    public ImageEnhancer(Map<Integer, Boolean> enhancementAlgorithm, Integer infinitePadding) {
        this.enhancementAlgorithm = enhancementAlgorithm;
        this.infinitePadding = infinitePadding;
    }

    public Map<Integer, Map<Integer, Integer>> enhanceImage(Map<Integer, Map<Integer, Integer>> inputImage) {
        int evaluationPadding = infinitePadding;
        evaluateInfinitePadding();
        outputImage = new HashMap<>();
        Map<Integer, Integer> map;
        for(int row = 0; row < inputImage.size()+2; row++) {
            if(row == 0 || row == inputImage.size()+1) {
                map = new HashMap<>();
                for (int column = 0; column < inputImage.get(0).size() + 2; column++) {
                    map.put(column, infinitePadding);
                }
                outputImage.put(row, map);
                row++;

            }

            if(!(row > inputImage.size())) {
                map = new HashMap<>();
                for (int column = 0; column < inputImage.get(0).size() + 2; column++) {
                    if (column == 0 || column == inputImage.get(0).size() + 1) {
                        map.put(column, infinitePadding);

                    } else {
                        map.put(column, enhancePixel(inputImage, row - 1, column - 1, evaluationPadding));
                    }
                }
                outputImage.put(row, map);
            }
        }
        return outputImage;
    }

    private int enhancePixel(Map<Integer, Map<Integer, Integer>> inputImage, int row, int column, int infinitePadding) {
        int pixel = inputImage.get(row).get(column);

        String binaryValueAsString = "";
        // First row
        if(row-1 < 0 || column-1 < 0) {
            binaryValueAsString += infinitePadding;
        } else {
            binaryValueAsString += inputImage.get(row-1).get(column-1);
        }
        if(row-1 < 0) {
            binaryValueAsString += infinitePadding;
        } else {
            binaryValueAsString += inputImage.get(row-1).get(column);
        }
        if(row-1 < 0 || column+1 == inputImage.get(row-1).size()) {
            binaryValueAsString += infinitePadding;
        } else {
            binaryValueAsString += inputImage.get(row-1).get(column+1);
        }

        // Second row
        if(column-1 < 0) {
            binaryValueAsString += infinitePadding;
        } else {
            binaryValueAsString += inputImage.get(row).get(column-1);
        }

        binaryValueAsString += inputImage.get(row).get(column);

        if(column+1 == inputImage.get(row).size()) {
            binaryValueAsString += infinitePadding;
        } else {
            binaryValueAsString += inputImage.get(row).get(column+1);
        }

        // Third row
        if(row+1 == inputImage.size() || column-1 < 0) {
            binaryValueAsString += infinitePadding;
        } else {
            binaryValueAsString += inputImage.get(row+1).get(column-1);
        }
        if(row+1 == inputImage.size()) {
            binaryValueAsString += infinitePadding;
        } else {
            binaryValueAsString += inputImage.get(row+1).get(column);
        }
        if(row+1 == inputImage.size() || column+1 == inputImage.get(row+1).size()) {
            binaryValueAsString += infinitePadding;
        } else {
            binaryValueAsString += inputImage.get(row+1).get(column+1);
        }

        return enhancementAlgorithm.get(Integer.parseInt(binaryValueAsString, 2)) ? 1 : 0;
    }

    private void evaluateInfinitePadding() {
        if(infinitePadding == 0) {
            infinitePadding = enhancementAlgorithm.get(0) ? 1 : 0;
        } else {
            infinitePadding = enhancementAlgorithm.get(511) ? 1 : 0;
        }
    }

    public int getInfinitePadding() {
        return infinitePadding;
    }
}
