package com.AoC.TwentyTwentyOne.Challenges.DaySeventeen.TrickShot;

import java.util.ArrayList;
import java.util.List;

public class Target {
    public int x1 = 0;
    public int x2 = 0;
    public int y1 = 0;
    public int y2 = 0;

    public Target() { }

    public List<Integer> getXAsList() {
        List list = new ArrayList();
        list.add(x1);
        list.add(x2);
        return list;
    }
    public List<Integer> getYAsList() {
        List list = new ArrayList();
        list.add(y1);
        list.add(y2);
        return list;
    }
}
