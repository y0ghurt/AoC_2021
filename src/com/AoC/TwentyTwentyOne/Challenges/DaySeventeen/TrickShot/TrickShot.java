package com.AoC.TwentyTwentyOne.Challenges.DaySeventeen.TrickShot;

import java.util.Collections;

public class TrickShot {
    public static boolean trickShot(int x, int y, Target target) {
        int height = 0;
        int distance = 0;
        int xSpeed = x;
        int ySpeed = y;

        while (distance <= Collections.max(target.getXAsList())
                && (ySpeed <= 0 && height >= Collections.min(target.getYAsList())) || ySpeed > 0) {
            distance += xSpeed;
            height += ySpeed;
            if (xSpeed > 0) {
                xSpeed += -1;
            } else if (xSpeed < 0) {
                xSpeed++;
            }
            ySpeed += -1;


            if (distance <= Collections.max(target.getXAsList())
                    && distance >= Collections.min(target.getXAsList())) {
                if (height <= Collections.max(target.getYAsList())
                        && height >= Collections.min(target.getYAsList())) {
                    return true;
                }
            }
        }
        return false;
    }
}
