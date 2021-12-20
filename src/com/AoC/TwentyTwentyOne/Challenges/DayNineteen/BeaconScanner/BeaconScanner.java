package com.AoC.TwentyTwentyOne.Challenges.DayNineteen.BeaconScanner;

import java.util.ArrayList;
import java.util.List;

public class BeaconScanner {
    String name = "";
    int runningNumber = 0;
    public boolean matched = false;
    public int matchedFacing = 0;
    public String matchedOffset = "0,0,0";
    List<Beacon> beacons = new ArrayList<>();

    public BeaconScanner(String name) {
        this.name = name;
    }

    public boolean addBeacons(List<String[]> beacons) {

        try {
            for (String[] beacon : beacons) {
                this.beacons.add(new Beacon(Integer.parseInt(beacon[0]), Integer.parseInt(beacon[1]), Integer.parseInt(beacon[2]), "" + name + "-Beacon_" + runningNumber));
                runningNumber++;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public List<Beacon> getBeacons () {
        return getBeacons(0);
    }

    public List<Beacon> getBeacons (int facing) {
        return getBeacons(facing, 0, 0, 0);
    }

    public List<Beacon> getBeacons(int facing, int x1Offset, int x2Offset, int x3Offset) {
        List<Beacon> facingBeacons = new ArrayList<>();
        for(Beacon beacon: beacons) {
            facingBeacons.add(beacon.getFacing(facing, x1Offset, x2Offset, x3Offset));
        }
        return facingBeacons;
    }
}
