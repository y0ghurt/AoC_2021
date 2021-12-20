package com.AoC.TwentyTwentyOne.Challenges.DayNineteen.BeaconScanner;

public class Beacon {


    public String parentName;
    public int x1;
    public int x2;
    public int x3;

    public Beacon(int x1, int x2, int x3, String parentName) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.parentName = parentName;
    }
    
    public Beacon getFacing(int facing) {
        return getFacing(facing, 0, 0, 0);
    }

    public Beacon getFacing(int facing, int x1Offset, int x2Offset, int x3Offset) {
        switch(facing) {
            // 1 front facing
            case 0:
                return new Beacon((x1 + x1Offset), (x2 + x2Offset), (x3 + x3Offset), parentName);
            case 1:
                return new Beacon((x1 + x1Offset), (x3*-1) + x3Offset, (x2 + x2Offset), parentName);
            case 2:
                return new Beacon((x1 + x1Offset), (x2*-1) + x2Offset, (x3*-1) + x3Offset, parentName);
            case 3:
                return new Beacon((x1 + x1Offset), (x3 + x3Offset), (x2*-1) + x2Offset, parentName);
            // 6 front facing
            case 4:
                return new Beacon((x1*-1) + x1Offset, (x3 + x3Offset), (x2 + x2Offset), parentName);
            case 5:
                return new Beacon((x1*-1) + x1Offset, (x2*-1) + x2Offset, (x3 + x3Offset), parentName);
            case 6:
                return new Beacon((x1*-1) + x1Offset, (x3*-1) + x3Offset, (x2*-1) + x2Offset, parentName);
            case 7:
                return new Beacon((x1*-1) + x1Offset, (x2 + x2Offset), (x3*-1) + x3Offset, parentName);
            // 2 front facing
            case 8:
                return new Beacon((x2 + x2Offset), (x3 + x3Offset), (x1 + x1Offset), parentName);
            case 9:
                return new Beacon((x2 + x2Offset), (x1*-1) + x1Offset, (x3 + x3Offset), parentName);
            case 10:
                return new Beacon((x2 + x2Offset), (x3*-1) + x3Offset, (x1*-1) + x1Offset, parentName);
            case 11:
                return new Beacon((x2 + x2Offset), (x1 + x1Offset), (x3*-1) + x3Offset, parentName);
            //  5 front facing
            case 12:
                return new Beacon((x2*-1) + x2Offset, (x1 + x1Offset), (x3 + x3Offset), parentName);
            case 13:
                return new Beacon((x2*-1) + x2Offset, (x3*-1) + x3Offset, (x1 + x1Offset), parentName);
            case 14:
                return new Beacon((x2*-1) + x2Offset, (x1*-1) + x1Offset, (x3*-1) + x3Offset, parentName);
            case 15:
                return new Beacon((x2*-1) + x2Offset, (x3 + x3Offset), (x1*-1) + x1Offset, parentName);
            // 3 front facing
            case 16:
                return new Beacon((x3 + x3Offset), (x1 + x1Offset), (x2 + x2Offset), parentName);
            case 17:
                return new Beacon((x3 + x3Offset), (x2*-1) + x2Offset, (x1 + x1Offset), parentName);
            case 18:
                return new Beacon((x3 + x3Offset), (x1*-1) + x1Offset, (x2*-1) + x2Offset, parentName);
            case 19:
                return new Beacon((x3 + x3Offset), (x2 + x2Offset), (x1*-1) + x1Offset, parentName);
            // 4 front facing
            case 20:
                return new Beacon((x3*-1) + x3Offset, (x2 + x2Offset), (x1 + x1Offset), parentName);
            case 21:
                return new Beacon((x3*-1) + x3Offset, (x1*-1) + x1Offset, (x2 + x2Offset), parentName);
            case 22:
                return new Beacon((x3*-1) + x3Offset, (x2*-1) + x2Offset, (x1*-1) + x1Offset, parentName);
            case 23:
                return new Beacon((x3*-1) + x3Offset, (x1 + x1Offset), (x2*-1) + x2Offset, parentName);
            // 1 front facing
            case 24:
                return new Beacon((x1 + x1Offset), (x3 + x3Offset), (x2 + x2Offset), parentName);
            case 25:
                return new Beacon((x1 + x1Offset), (x2 + x2Offset), (x3*-1) + x3Offset, parentName);
            case 26:
                return new Beacon((x1 + x1Offset), (x3*-1) + x3Offset, (x2*-1) + x2Offset, parentName);
            case 27:
                return new Beacon((x1 + x1Offset), (x2*-1) + x2Offset, (x3 + x3Offset), parentName);
            // 6 front facing
            case 28:
                return new Beacon((x1*-1) + x1Offset, (x2 + x2Offset), (x3 + x3Offset), parentName);
            case 29:
                return new Beacon((x1*-1) + x1Offset, (x3 + x3Offset), (x2*-1) + x2Offset, parentName);
            case 30:
                return new Beacon((x1*-1) + x1Offset, (x2*-1) + x2Offset, (x3*-1) + x3Offset, parentName);
            case 31:
                return new Beacon((x1*-1) + x1Offset, (x3*-1) + x3Offset, (x2 + x2Offset), parentName);
            // 2 front facing
            case 32:
                return new Beacon((x2 + x2Offset), (x1 + x1Offset), (x3 + x3Offset), parentName);
            case 33:
                return new Beacon((x2 + x2Offset), (x3 + x3Offset), (x1*-1) + x1Offset, parentName);
            case 34:
                return new Beacon((x2 + x2Offset), (x1*-1) + x1Offset, (x3*-1) + x3Offset, parentName);
            case 35:
                return new Beacon((x2 + x2Offset), (x3*-1) + x3Offset, (x1 + x1Offset), parentName);
            //  5 front facing
            case 36:
                return new Beacon((x2*-1) + x2Offset, (x3 + x3Offset), (x1 + x1Offset), parentName);
            case 37:
                return new Beacon((x2*-1) + x2Offset, (x1 + x1Offset), (x3*-1) + x3Offset, parentName);
            case 38:
                return new Beacon((x2*-1) + x2Offset, (x3*-1) + x3Offset, (x1*-1) + x1Offset, parentName);
            case 39:
                return new Beacon((x2*-1) + x2Offset, (x1*-1) + x1Offset, (x3 + x3Offset), parentName);
            // 3 front facing
            case 40:
                return new Beacon((x3 + x3Offset), (x2 + x2Offset), (x1 + x1Offset), parentName);
            case 41:
                return new Beacon((x3 + x3Offset), (x1 + x1Offset), (x2*-1) + x2Offset, parentName);
            case 42:
                return new Beacon((x3 + x3Offset), (x2*-1) + x2Offset, (x1*-1) + x1Offset, parentName);
            case 43:
                return new Beacon((x3 + x3Offset), (x1*-1) + x1Offset, (x2 + x2Offset), parentName);
            // 4 front facing
            case 44:
                return new Beacon((x3*-1) + x3Offset, (x1 + x1Offset), (x2 + x2Offset), parentName);
            case 45:
                return new Beacon((x3*-1) + x3Offset, (x2 + x2Offset), (x1*-1) + x1Offset, parentName);
            case 46:
                return new Beacon((x3*-1) + x3Offset, (x1*-1) + x1Offset, (x2*-1) + x2Offset, parentName);
            case 47:
                return new Beacon((x3*-1) + x3Offset, (x2*-1) + x2Offset, (x1 + x1Offset), parentName);
        }
        return null;
    }

    public String getPosition() {
        return ""+x1+","+x2+","+x3;
    }
}
