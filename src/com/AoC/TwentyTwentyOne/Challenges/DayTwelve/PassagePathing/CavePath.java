package com.AoC.TwentyTwentyOne.Challenges.DayTwelve.PassagePathing;

import java.util.ArrayList;
import java.util.List;

public class CavePath {
    List<String> path = new ArrayList<>();
    boolean finished = false;
    boolean deadEnd = false;
    boolean doubleDip = false;

    public CavePath(String startingPoint) {
        path.add(startingPoint);
    }

    public CavePath(CavePath originalPath) {
        for(String node : originalPath.path) {
            path.add(node);
        }
        this.doubleDip = originalPath.doubleDip;
    }

    public String getCurrentCave() {
        return path.get(path.size() - 1);
    }

    public PathState getState() {
        if(finished) {
            return PathState.FINISHED;
        } else if (deadEnd) {
            return PathState.DEAD;
        } else {
            return PathState.RUNNING;
        }
    }

    public boolean moveToCave(String cave) {
        return moveToCave(cave, false);
    }

    public boolean moveToCave(String cave, boolean activateDoubleDipping) {
        if(finished || deadEnd) {
            return false;
        }
        if(cave.equals("start")) {
            deadEnd = true;
            return false;
        }
        if(cave.matches("[a-z]+")) {
            for (String node : path) {
                if (node.equals(cave)) {
                    if(!activateDoubleDipping || doubleDip) {
                        deadEnd = true;
                        return false;
                    } else if (!doubleDip) {
                        doubleDip = true;
                    }
                }
            }
        }
        if (cave.equals("end")) {
            finished = true;
        }
        path.add(cave);

        return true;
    }

    public enum PathState {
        RUNNING,
        FINISHED,
        DEAD
    }
}
