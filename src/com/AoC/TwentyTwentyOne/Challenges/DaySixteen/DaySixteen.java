package com.AoC.TwentyTwentyOne.Challenges.DaySixteen;

import com.AoC.TwentyTwentyOne.Challenges.DaySixteen.PacketDecoder.DataPacket;
import com.AoC.TwentyTwentyOne.Challenges.DaySixteen.PacketDecoder.PacketDecoder;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class DaySixteen {
    public static void daySixteen() {
        File file = new File("resources/d16_input.txt");
        Scanner scanner;
        String hexString = "";
        String binaryString = "";

        try {
            scanner = new Scanner(file);
            if(scanner.hasNextLine()) {
                hexString = scanner.nextLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        for(int i = 0; i < hexString.length(); i++) {
            String stringToAdd = Integer.toBinaryString(Integer.parseInt(String.valueOf(hexString.charAt(i)), 16));
            for(int j = 0 + stringToAdd.length(); j < 4; j++) {
                stringToAdd = "0" + stringToAdd;
            }
            binaryString += stringToAdd;
        }

        PacketDecoder packetDecoder = new PacketDecoder(binaryString);
        List<DataPacket> dataPackets = packetDecoder.decodePacket();


        System.out.println();
        System.out.println();
        System.out.println("-= Day 16: First challenge =-");
        System.out.println("The summed up versions in the string is: " + packetDecoder.getVersionsSummed());


        long answer = 0;

        for(DataPacket dataPacket: dataPackets) {
            answer += packetDecoder.calculateAnswer(dataPacket);
        }

        System.out.println();
        System.out.println("-= Day 16: Second challenge =-");
        System.out.println("The expression evaluates to: " + answer);
    }
}
