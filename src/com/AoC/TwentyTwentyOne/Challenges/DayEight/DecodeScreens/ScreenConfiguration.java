package com.AoC.TwentyTwentyOne.Challenges.DayEight.DecodeScreens;

import java.util.*;

public class ScreenConfiguration {
    String[] scrambledDigits;
    String[] decodedDigits = new String[10];
    String[] output;
    Map<Character, Character> positionMapping = new HashMap();

    public ScreenConfiguration(String[] scrambledDigits, String[] output) {
        this.scrambledDigits = scrambledDigits;
        this.output = output;
    }

    public List<Integer> decodeDigits() {
        // Decode one.
        for(String s: scrambledDigits) {
            if(s.length() == 2) {
                decodedDigits[1] = s;
                break;
            }
        }

        // Decode seven and a.
        for(String s: scrambledDigits) {
            if(s.length() == 3) {
                decodedDigits[7] = s;
                for (char c : s.toCharArray()) {
                    if(!decodedDigits[1].contains(String.valueOf(c))) {
                        positionMapping.put('a', c);
                        break;
                    }
                }
                break;
            }
        }

        // Decode four.
        for(String s: scrambledDigits) {
            if(s.length() == 4) {
                decodedDigits[4] = s;
                break;
            }
        }

        // Decode eight.
        for(String s: scrambledDigits) {
            if(s.length() == 7) {
                decodedDigits[8] = s;
                break;
            }
        }

        // Decode six, c and f.
        for(String s: scrambledDigits) {
            if(s.length() == 6) {
                for (char c : decodedDigits[1].toCharArray()) {
                    if(!s.contains(String.valueOf(c))) {
                        positionMapping.put('c', c);
                        for(char ctwo : decodedDigits[1].toCharArray()) {
                            if(ctwo != c) {
                                positionMapping.put('f', ctwo);
                            }
                        }
                        decodedDigits[6] = s;
                    }
                }
            }
        }

        // Decode two and b.
        for(String s: scrambledDigits) {
            if(s.length() == 5) {
                if(!s.contains(String.valueOf(positionMapping.get('f')))) {
                    decodedDigits[2] = s;
                    for(char c : decodedDigits[8].toCharArray()) {
                        if(!s.contains(String.valueOf(c))) {
                            if (positionMapping.get('f') != c) {
                                positionMapping.put('b', c);
                                break;
                            }
                        }
                    }
                }
            }
        }

        // Decode nine and e.
        for(String s: scrambledDigits) {
            if(s.length() == 6) {
                for(char c : decodedDigits[8].toCharArray()) {
                    if(!s.contains(String.valueOf(c))) {
                        if(!decodedDigits[4].contains(String.valueOf(c))) {
                            decodedDigits[9] = s;
                            positionMapping.put('e', c);
                        }
                    }
                }
            }
        }

        // Decode zero and d.
        for(String s: scrambledDigits) {
            if(s.length() == 6) {
                for(char c : decodedDigits[8].toCharArray()) {
                    if(!s.contains(String.valueOf(c))) {
                        if(c != positionMapping.get('c') && c!= positionMapping.get('e')) {
                            decodedDigits[0] = s;
                            positionMapping.put('d', c);
                        }
                    }
                }
            }
        }

        // Decode g.
        for(char c: decodedDigits[8].toCharArray()) {
            char[] mapIterator = new char[] {'a', 'b', 'c', 'd', 'e', 'f'};
            int notFound = 0;
            for(int i = 0; i < mapIterator.length; i++) {
                if(positionMapping.get(mapIterator[i]) != c) {
                    notFound++;
                }
            }
            if(notFound == mapIterator.length) {
                positionMapping.put('g', c);
                break;
            }
        }

        // Decode Three and Five
        for(String s : scrambledDigits) {
            if(s.length() == 5) {
                if (s.contains(String.valueOf(positionMapping.get('a')))
                        && s.contains(String.valueOf(positionMapping.get('c')))
                        && s.contains(String.valueOf(positionMapping.get('d')))
                        && s.contains(String.valueOf(positionMapping.get('f')))
                        && s.contains(String.valueOf(positionMapping.get('g')))) {
                    decodedDigits[3] = s;
                } else if (s.contains(String.valueOf(positionMapping.get('a')))
                        && s.contains(String.valueOf(positionMapping.get('b')))
                        && s.contains(String.valueOf(positionMapping.get('d')))
                        && s.contains(String.valueOf(positionMapping.get('f')))
                        && s.contains(String.valueOf(positionMapping.get('g')))) {
                    decodedDigits[5] = s;
                }
            }
        }

        List<Integer> outputNumbers = new ArrayList<>();

        for(String outputString: output) {
            for(int index = 0; index < 10; index++) {
                if (decodedDigits[index] != null) {
                    if (sortString(outputString).equals(sortString(decodedDigits[index]))) {
                        outputNumbers.add(index);
                        break;
                    }
                }
            }
        }
        return outputNumbers;
    }

    public int decodeValue() {
        List<Integer> list = decodeDigits();
        String value = "";
        for(Integer integer : list) {
            value += integer;
        }
        return Integer.parseInt(value);
    }

    private String sortString(String string) {
        String returnString = "";
        if(string.contains(String.valueOf(positionMapping.get('a')))) {
            returnString += positionMapping.get('a');
        }
        if(string.contains(String.valueOf(positionMapping.get('b')))) {
            returnString += positionMapping.get('b');
        }
        if(string.contains(String.valueOf(positionMapping.get('c')))) {
            returnString += positionMapping.get('c');
        }
        if(string.contains(String.valueOf(positionMapping.get('d')))) {
            returnString += positionMapping.get('d');
        }
        if(string.contains(String.valueOf(positionMapping.get('e')))) {
            returnString += positionMapping.get('e');
        }
        if(string.contains(String.valueOf(positionMapping.get('f')))) {
            returnString += positionMapping.get('f');
        }
        if(string.contains(String.valueOf(positionMapping.get('g')))) {
            returnString += positionMapping.get('g');
        }

        return returnString;
    }
}
