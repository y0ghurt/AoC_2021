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
                for(int j = 0; j < masterMap.size(); j++) {
                    matchedPositions = new ArrayList<>();
                    int matches = 0;
                    String[] offset = masterMap.get(j).split(",");
                    x1Offset = Integer.parseInt(offset[0]) - beacon.x1;
                    x2Offset = Integer.parseInt(offset[1]) - beacon.x2;
                    x3Offset = Integer.parseInt(offset[2]) - beacon.x3;
                    for (int i = 0; i < masterMap.size(); i++) {
                        List<Beacon> offsetBeacons = beaconScanner.getBeacons(facing, x1Offset, x2Offset, x3Offset);
                        for (Beacon offsetBeacon : offsetBeacons) {
                            String offsetBeaconPosition = offsetBeacon.getPosition();
                            String masterMapPosition = masterMap.get(i);
                            if (offsetBeaconPosition.equals(masterMapPosition)) {
                                matchedPositions.add(offsetBeaconPosition);
                                matches++;
/*
                                if(matches > 1) {
                                    System.out.println(matches);
                                }
*/
                            }
                            if (matches >= 12) {
                                System.out.println("WE HAVE A MATCH (or twelve)!!!");
                                beaconScanner.matchedFacing = facing;
                                beaconScanner.matched = true;
                                beaconScanner.matchedOffset = "" + x1Offset + "," + x2Offset + "," + x3Offset;
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
