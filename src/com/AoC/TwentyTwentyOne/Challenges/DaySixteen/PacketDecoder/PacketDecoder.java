package com.AoC.TwentyTwentyOne.Challenges.DaySixteen.PacketDecoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PacketDecoder {
    private String binaryPacket;
    private int tracker = 0;
    private long versionsSummed = 0;

    public PacketDecoder(String binaryPacket) {
        this.binaryPacket = binaryPacket;
    }

    public List<DataPacket> decodePacket() {
        List<DataPacket> dataPackets = new ArrayList<>();

        while(tracker < binaryPacket.length()-3) {
            dataPackets.add(decodeValue());

        }
        return dataPackets;
    }

    private DataPacket decodeValue() {
        return decodeValue(new DataPacket());
    }

    private DataPacket decodeValue(DataPacket dataPacket) {
        dataPacket.version = Integer.parseInt(binaryPacket.substring(tracker, tracker + 3), 2);
        versionsSummed += dataPacket.version;
        tracker += 3;
        dataPacket.typeId = Integer.parseInt(binaryPacket.substring(tracker, tracker + 3), 2);
        tracker += 3;
        if(dataPacket.typeId == 4) {
            boolean hasMore = true;
            String binaryPayload = "";
            while(hasMore) {
                if(binaryPacket.substring(tracker, tracker + 1).equals("0")) {
                    hasMore = false;
                }
                tracker++;
                binaryPayload += binaryPacket.substring(tracker, tracker + 4);
                tracker += 4;
            }
            dataPacket.payload = Long.parseLong(binaryPayload, 2);
        } else {
            if(binaryPacket.substring(tracker, tracker + 1).equals("0")) {
                dataPacket.lengthTypeId = 0;
                tracker++;
                dataPacket.subDataPacketLength = Integer.parseInt(binaryPacket.substring(tracker, tracker + 15), 2);
                tracker += 15;
                int payloadEndsAt = tracker + dataPacket.subDataPacketLength;
                while(tracker < payloadEndsAt) {
                    dataPacket.subDataPackets.add(decodeValue());
                }

            } else {
                dataPacket.lengthTypeId = 1;
                tracker++;
                dataPacket.subDataPacketLength = Integer.parseInt(binaryPacket.substring(tracker, tracker + 11), 2);
                tracker += 11;
                for(int i = 0; i < dataPacket.subDataPacketLength; i++) {
                    dataPacket.subDataPackets.add(decodeValue());
                }
            }
        }
        return dataPacket;
    }

    public long getVersionsSummed() {
        return versionsSummed;
    }

    public long calculateAnswer(DataPacket dataPacket) {
        long answer = 0;
        switch(dataPacket.typeId) {
            case 0:
                for(DataPacket dp: dataPacket.subDataPackets) {
                    answer += calculateAnswer(dp);
                }
                break;

            case 1:
                long partialAnswer = 0;
                for(int i = 0; i < dataPacket.subDataPackets.size(); i++) {
                    if(i == 0) {
                        partialAnswer += calculateAnswer(dataPacket.subDataPackets.get(i));
                    } else {
                        partialAnswer = partialAnswer * calculateAnswer(dataPacket.subDataPackets.get(i));
                    }
                }
                answer += partialAnswer;
                break;

            case 2:
                List<Long> minList = new ArrayList<>();
                for(DataPacket dp: dataPacket.subDataPackets) {
                    if(dp.subDataPackets.size() > 0) {
                        minList.add(calculateAnswer(dp));
                    } else {
                        minList.add(dp.payload);
                    }
                }
                answer += Collections.min(minList);
                break;

            case 3:
                List<Long> maxList = new ArrayList<>();
                for(DataPacket dp: dataPacket.subDataPackets) {
                    if(dp.subDataPackets.size() > 0) {
                        maxList.add(calculateAnswer(dp));
                    } else {
                        maxList.add(dp.payload);
                    }
                }
                answer += Collections.max(maxList);
                break;

            case 4:
                answer += dataPacket.payload;
                break;

            case 5:
                long typeIdFiveFirstValue = calculateAnswer(dataPacket.subDataPackets.get(0));
                long typeIdFiveSecondValue = calculateAnswer(dataPacket.subDataPackets.get(1));
                if(typeIdFiveFirstValue > typeIdFiveSecondValue) {
                    answer++;
                }
                break;

            case 6:
                long typeIdSixFirstValue = calculateAnswer(dataPacket.subDataPackets.get(0));
                long typeIdSixSecondValue = calculateAnswer(dataPacket.subDataPackets.get(1));
                if(typeIdSixFirstValue < typeIdSixSecondValue) {
                    answer++;
                }
                break;

            case 7:
                long typeIdSevenFirstValue = calculateAnswer(dataPacket.subDataPackets.get(0));
                long typeIdSevenSecondValue = calculateAnswer(dataPacket.subDataPackets.get(1));
                if(typeIdSevenFirstValue == typeIdSevenSecondValue) {
                    answer++;
                }
                break;

            default:
                System.out.println("UNKNOWN TYPE ID: " + dataPacket.typeId);
                break;
        }
        return answer;
    }
}
