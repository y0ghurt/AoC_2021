package com.AoC.TwentyTwentyOne.Challenges.DayNineteen;

import com.AoC.TwentyTwentyOne.Challenges.DayNineteen.BeaconScanner.Beacon;
import com.AoC.TwentyTwentyOne.Challenges.DayNineteen.BeaconScanner.BeaconScanner;
import com.AoC.TwentyTwentyOne.Challenges.DayNineteen.BeaconScanner.CompareScanners;

import java.io.File;
import java.util.*;

public class DayNineteen {
    public static void dayNineteen() {

        File file = new File("resources/d19_test_input.txt");
        Scanner scanner;
        List<BeaconScanner> beaconScanners = new ArrayList<>();
        int scannerCounter = -1;
        Map<Integer, String> masterMap = new HashMap<>();

        System.out.println();
        System.out.println();

        try {
            scanner = new Scanner(file);
            List<String[]> beacons = new ArrayList<>();
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if(line.length() > 0) {
                    if(line.substring(0, 3).equals("---")) {
                        scannerCounter++;
                        beaconScanners.add(new BeaconScanner("Scanner_" + scannerCounter));
                    } else {
                        beacons.add(line.split(","));
                    }
                } else {
                    beaconScanners.get(scannerCounter).addBeacons(beacons);
                    beacons = new ArrayList<>();
                }
            }
            if(beaconScanners.get(scannerCounter).getBeacons().size() == 0) {
                beaconScanners.get(scannerCounter).addBeacons(beacons);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println("Found " + beaconScanners.size() + " scanners.");

        long rotations = 0;
        beaconScanners.get(0).matched = true;
        beaconScanners.get(0).matchedFacing = 0;
        boolean allScannersMatched = false;
        while(!allScannersMatched) {
            allScannersMatched = true;
            for (BeaconScanner beaconScanner : beaconScanners) {
                if (beaconScanner.matched) {
                    String[] offset = beaconScanner.matchedOffset.split(",");
                    for (Beacon beacon : beaconScanner.getBeacons(beaconScanner.matchedFacing, Integer.parseInt(offset[0]), Integer.parseInt(offset[1]), Integer.parseInt(offset[2]))) {
                        if (!masterMap.containsValue(beacon.getPosition())) {
                            int key;
                            if(masterMap.size() > 0) {
                                key = Collections.max(masterMap.keySet()) + 1;
                            } else {
                                key = 0;
                            }
                            masterMap.put(key, beacon.getPosition());
                        }
                    }
                } else {
                    allScannersMatched = false;
                    CompareScanners compareScanners = new CompareScanners();
                    compareScanners.compare(masterMap, beaconScanner);
                }
            }
            System.out.println("Rotations: " + rotations);
            rotations++;

            if(rotations > 20)
                break;
        }

        System.out.println("Number of beacons: " + masterMap.size());
        for(String position: masterMap.values()) {
            System.out.println(position);
        }
    }
}
