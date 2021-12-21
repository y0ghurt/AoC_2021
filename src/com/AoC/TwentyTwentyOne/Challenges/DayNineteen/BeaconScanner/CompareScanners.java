package com.AoC.TwentyTwentyOne.Challenges.DayNineteen.BeaconScanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CompareScanners {
    public static boolean compare( Map<Integer, String> masterMap, BeaconScanner beaconScanner) {
        List<String> matchedPositions = new ArrayList<>();
        Integer x1Offset = 0;
        Integer x2Offset = 0;
        Integer x3Offset = 0;
        for(int facing = 0; facing < 24; facing++) {
            List<Beacon> facingBeacons = beaconScanner.getBeacons(facing);
            for (Beacon beacon : facingBeacons) {
                for(int i = 0; i < masterMap.size(); i++) {
                    matchedPositions = new ArrayList<>();
                    int matches = 0;
                    String[] offset = masterMap.get(i).split(",");
                    x1Offset = Integer.parseInt(offset[0]) - beacon.x1;
                    x2Offset = Integer.parseInt(offset[1]) - beacon.x2;
                    x3Offset = Integer.parseInt(offset[2]) - beacon.x3;
                    List<Beacon> offsetBeacons = beaconScanner.getBeacons(facing, x1Offset, x2Offset, x3Offset);
                    for (Beacon offsetBeacon : offsetBeacons) {
                        String offsetBeaconPosition = offsetBeacon.getPosition();

                        if (masterMap.containsValue(offsetBeacon.getPosition())) {
                            matchedPositions.add(offsetBeaconPosition);
                            matches++;
                        }
                        if (matches >= 12) {
                            // Debug
                            // System.out.println("WE HAVE A MATCH (or twelve)!!! (" + beaconScanner.name + ")");
                            beaconScanner.matchedFacing = facing;
                            beaconScanner.matched = true;
                            beaconScanner.matchedOffset = "" + x1Offset + "," + x2Offset + "," + x3Offset;
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static int getManhattanDistance(BeaconScanner b1, BeaconScanner b2) {
        String[] b1Offset = b1.matchedOffset.split(",");
        String[] b2Offset = b2.matchedOffset.split(",");
        int x1 = Integer.parseInt(b1Offset[0]);
        int x2 = Integer.parseInt(b2Offset[0]);
        int y1 = Integer.parseInt(b1Offset[1]);
        int y2 = Integer.parseInt(b2Offset[1]);
        int z1 = Integer.parseInt(b1Offset[2]);
        int z2 = Integer.parseInt(b2Offset[2]);
        int xOffSet = Math.max(x1, x2) - Math.min(x1, x2);
        if(xOffSet < 0) {
            xOffSet = xOffSet*-1;
        }
        int yOffSet = Math.max(y1, y2) - Math.min(y1, y2);
        if(yOffSet < 0) {
            yOffSet = yOffSet*-1;
        }
        int zOffSet = Math.max(z1, z2) - Math.min(z1, z2);
        if(zOffSet < 0) {
            zOffSet = zOffSet*-1;
        }
        return xOffSet+yOffSet+zOffSet;
    }
}
