package com.AoC.TwentyTwentyOne.Challenges.DaySixteen.PacketDecoder;

import java.util.ArrayList;
import java.util.List;

public class DataPacket {
    public int version;
    public int typeId;
    public int lengthTypeId;
    public int subDataPacketLength;
    public long payload;
    public List<DataPacket> subDataPackets = new ArrayList<>();

    public DataPacket() { }


}
