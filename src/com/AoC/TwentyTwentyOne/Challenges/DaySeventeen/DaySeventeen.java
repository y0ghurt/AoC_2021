package com.AoC.TwentyTwentyOne.Challenges.DaySeventeen;

import com.AoC.TwentyTwentyOne.Challenges.DaySeventeen.TrickShot.Target;
import com.AoC.TwentyTwentyOne.Challenges.DaySeventeen.TrickShot.TrickShot;

import java.io.File;
import java.util.Collections;
import java.util.Scanner;

public class DaySeventeen {
    public static void daySeventeen() {
        File file = new File("resources/d17_input.txt");
        Scanner scanner;
        Target target = new Target();

        try {
            scanner = new Scanner(file);
            if(scanner.hasNextLine()) {
                String temp = scanner.nextLine().split(": ")[1];
                String[] temp2 = temp.split(", ");
                String[] temp3 = temp2[0].substring(2).split("\\.\\.");
                target.x1 = Integer.parseInt(temp3[0]);
                target.x2 = Integer.parseInt(temp3[1]);
                temp3 = temp2[1].substring(2).split("\\.\\.");
                target.y1 = Integer.parseInt(temp3[0]);
                target.y2 = Integer.parseInt(temp3[1]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        // Maximum y velocity for a negative y axis target area is always [lowest target y value inverted - 1]
        int y = Collections.min(target.getYAsList());
        y++;
        y *= -1;
        int x = 0;
        while(!TrickShot.trickShot(x, y, target)) {
            x++;
        }

        int maxHeight = 0;

        if(y%2 == 0) {
            maxHeight = y * (y/2) + y/2;
        } else {
            maxHeight = y * ((y-1)/2) + y;
        }


        System.out.println();
        System.out.println();
        System.out.println("-= Day 17: First challenge =-");
        System.out.println("Highest possible trick shot will reach height: " + maxHeight);

        int velocities = 0;
        for(int secondX = 0; secondX <= Collections.max(target.getXAsList()); secondX++) {
            for(int secondY = (Collections.min(target.getYAsList())+1)*-1; secondY >= Collections.min(target.getYAsList()); secondY += -1) {
                if(TrickShot.trickShot(secondX, secondY, target)) {
                    velocities++;
                }
            }
        }

        System.out.println();
        System.out.println("-= Day 17: Second challenge =-");
        System.out.println("The number of possible hit configurations is: " + velocities);
    }
}
