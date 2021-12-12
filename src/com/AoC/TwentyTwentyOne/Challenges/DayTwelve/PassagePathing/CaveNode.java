package com.AoC.TwentyTwentyOne.Challenges.DayTwelve.PassagePathing;

import java.util.ArrayList;
import java.util.List;

public class CaveNode {
    List<String> connections = new ArrayList<>();
    public final boolean isLarge;
    public final boolean isStart;
    public final boolean isEnd;
    public final String name;

    public CaveNode(String name) {
        this.name = name;

        if(name.equals("start")) {
            isLarge = false;
            isStart = true;
            isEnd = false;
        } else if(name.equals("end")) {
            isLarge = false;
            isStart = false;
            isEnd = true;
        } else if(name.matches("[A-Z]+")) {
            isLarge = true;
            isStart = false;
            isEnd = false;
        } else {
            isLarge = false;
            isStart = false;
            isEnd = false;
        }
    }

    public void addConnection(String connection) {
        connections.add(connection);
    }

    public List<String> getConnections() {
        return connections;
    }
}
