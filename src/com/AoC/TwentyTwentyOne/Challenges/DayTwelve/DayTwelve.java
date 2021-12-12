package com.AoC.TwentyTwentyOne.Challenges.DayTwelve;

import com.AoC.TwentyTwentyOne.Challenges.DayTwelve.PassagePathing.CaveNode;
import com.AoC.TwentyTwentyOne.Challenges.DayTwelve.PassagePathing.CavePath;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DayTwelve {
    public static void dayTwelve() {
        File file = new File("resources/d12_input.txt");
        List<CaveNode> caveNodes = new ArrayList<>();
        List<CavePath> cavePaths = new ArrayList<>();

        // Day 12: First assignment
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()) {
                String[] connection = scanner.nextLine().split("-");
                boolean firstExists = false;
                Integer firstIndex = null;
                boolean secondExists = false;
                Integer secondIndex = null;
                for(int i = 0; i < caveNodes.size(); i++) {
                    if(caveNodes.get(i).name.equals(connection[0])) {
                        firstExists = true;
                        firstIndex = i;
                    }
                    if(caveNodes.get(i).name.equals(connection[1])) {
                        secondExists = true;
                        secondIndex = i;
                    }
                }
                if(!firstExists) {
                    caveNodes.add(new CaveNode(connection[0]));
                    firstIndex = caveNodes.size() - 1;
                }
                if(!secondExists) {
                    caveNodes.add(new CaveNode(connection[1]));
                    secondIndex = caveNodes.size() - 1;
                }

                if(firstIndex != null) {
                    caveNodes.get(firstIndex).addConnection(connection[1]);
                }
                if(secondIndex != null) {
                    caveNodes.get(secondIndex).addConnection(connection[0]);
                }

            }

            cavePaths.add(new CavePath("start"));
            boolean traversalCompleted = false;
            while(!traversalCompleted) {
                traversalCompleted = true;
                for(int i = 0; i < cavePaths.size(); i++) {
                    CavePath cavePath = cavePaths.get(i);
                    String currentNode = cavePath.getCurrentCave();
                    if (!currentNode.equals("end")) {
                        List<String> potentialPaths = new ArrayList<>();
                        for (CaveNode caveNode : caveNodes) {
                            if (caveNode.name.equals(currentNode)) {
                                potentialPaths = caveNode.getConnections();
                                break;
                            }
                        }
                        for (int p = 0; p < potentialPaths.size() - 1; p++) {
                            CavePath cp = new CavePath(cavePath);
                            if (cp.moveToCave(potentialPaths.get(p))) {
                                cavePaths.add(cp);
                            }
                        }
                        if (!cavePath.moveToCave(potentialPaths.get(potentialPaths.size() - 1))) {
                            if (cavePath.getState() == CavePath.PathState.DEAD) {
                                cavePaths.remove(cavePath);
                            }
                        }
                    }
                    for (CavePath cp : cavePaths) {
                        if (cp.getState() == CavePath.PathState.RUNNING) {
                            traversalCompleted = false;
                        }
                    }
                }
            }



            System.out.println("-= Day 12: First challenge =-");
            System.out.println("Paths found: " + cavePaths.size());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        // Day 12: Second assignment
        caveNodes = new ArrayList<>();
        cavePaths = new ArrayList<>();

        // Day 12: First assignment
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()) {
                String[] connection = scanner.nextLine().split("-");
                boolean firstExists = false;
                Integer firstIndex = null;
                boolean secondExists = false;
                Integer secondIndex = null;
                for(int i = 0; i < caveNodes.size(); i++) {
                    if(caveNodes.get(i).name.equals(connection[0])) {
                        firstExists = true;
                        firstIndex = i;
                    }
                    if(caveNodes.get(i).name.equals(connection[1])) {
                        secondExists = true;
                        secondIndex = i;
                    }
                }
                if(!firstExists) {
                    caveNodes.add(new CaveNode(connection[0]));
                    firstIndex = caveNodes.size() - 1;
                }
                if(!secondExists) {
                    caveNodes.add(new CaveNode(connection[1]));
                    secondIndex = caveNodes.size() - 1;
                }

                if(firstIndex != null) {
                    caveNodes.get(firstIndex).addConnection(connection[1]);
                }
                if(secondIndex != null) {
                    caveNodes.get(secondIndex).addConnection(connection[0]);
                }

            }

            cavePaths.add(new CavePath("start"));
            boolean traversalCompleted = false;
            while(!traversalCompleted) {
                traversalCompleted = true;
                for(int i = 0; i < cavePaths.size(); i++) {
                    CavePath cavePath = cavePaths.get(i);
                    String currentNode = cavePath.getCurrentCave();
                    if (!currentNode.equals("end")) {
                        List<String> potentialPaths = new ArrayList<>();
                        for (CaveNode caveNode : caveNodes) {
                            if (caveNode.name.equals(currentNode)) {
                                potentialPaths = caveNode.getConnections();
                                break;
                            }
                        }
                        for (int p = 0; p < potentialPaths.size() - 1; p++) {
                            CavePath cp = new CavePath(cavePath);
                            if (cp.moveToCave(potentialPaths.get(p), true)) {
                                cavePaths.add(cp);
                            }
                        }
                        if (!cavePath.moveToCave(potentialPaths.get(potentialPaths.size() - 1), true)) {
                            if (cavePath.getState() == CavePath.PathState.DEAD) {
                                cavePaths.remove(cavePath);
                            }
                        }
                    }
                    for (CavePath cp : cavePaths) {
                        if (cp.getState() == CavePath.PathState.RUNNING) {
                            traversalCompleted = false;
                        }
                    }
                }
            }



            System.out.println("-= Day 12: Second challenge =-");
            System.out.println("Paths found: " + cavePaths.size());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

    }
}
