package com.AoC.TwentyTwentyOne.Challenges.DayEighteen.SnailfishCalculator;

public class Pair {
    public static int mD = 0;
    int depth;
    Object leftSide;
    Object rightSide;
    Pair parent;

    public Pair(int depth, Pair parent, String data) {
        this.depth = depth;
        this.parent = parent;

        int position = 1;
        int stringDepth = depth;
        if(depth > mD) {
            mD = depth;
        }
        if(data.length() < 5) {
            System.out.println(parent.toString());
        }
        while(1 == 1) {
            if(data.charAt(position) == ',' && stringDepth == depth) {
                if(position > 3) {
                    String string =  data.substring(1, position);
                    leftSide = new Pair(depth+1, this, string);
                } else {
                    String integer;
                    if(data.substring(1, 3).matches(".*\\d\\d.*")) {
                        integer = data.substring(1, 3);
                    } else {
                        integer = data.substring(1, 2);
                    }
                    leftSide = Integer.parseInt(integer);
                }
                if(position < data.length()-3 && !data.substring(data.length()-3, data.length()-1).matches(".*\\d\\d.*")) {
                    String string = data.substring(position+1, data.length()-1);
                    rightSide = new Pair(depth+1, this, string);
                } else {
                    String integer;
                    if(data.substring(data.length()-3, data.length()-1).matches(".*\\d\\d.*")) {
                        integer = data.substring(data.length() - 3, data.length()-1);
                    } else {
                        integer = data.substring(data.length() - 2, data.length() - 1);
                    }
                    rightSide = Integer.parseInt(integer);
                }
                break;
            }
            if(data.charAt(position) == '[') {
                stringDepth++;
            } else if(data.charAt(position) == ']') {
                stringDepth += -1;
            }
            position++;
        }
    }

    public void updateMaxDepth() {
        if(depth > mD) {
            mD = depth;
        }
        if(leftSide instanceof Pair) {
            ((Pair) leftSide).updateMaxDepth();
        }
        if(rightSide instanceof Pair) {
            ((Pair) rightSide).updateMaxDepth();
        }
    }

    public int reduceExplode() {
        if(leftSide instanceof Pair) {
            Pair left = (Pair) leftSide;
            if(left.reduceExplode() == 1) {
                return 1;
            }
        }
        if(rightSide instanceof Pair) {
            Pair right = (Pair) rightSide;
            if(right.reduceExplode() == 1) {
                return 1;
            }
        }
        if(depth > 4 && rightSide instanceof Integer) {
            parent.explode(this);
            return 1;
        }
        return 0;
    }

    public int reduceSplit() {
        if(leftSide instanceof Integer) {
            if((Integer) leftSide > 9) {
                leftSide = new Pair(depth + 1, this, split((Integer) leftSide));
                return 1;
            }
        } else {
            Pair left = (Pair) leftSide;
            if(left.reduceSplit() == 1) {
                return 1;
            }
        }
        if(rightSide instanceof Integer) {
            if((Integer) rightSide > 9) {
                rightSide = new Pair(depth + 1, this, split((Integer) rightSide));
                return 1;
            }
        } else {
            Pair right = (Pair) rightSide;
            if(right.reduceSplit() == 1) {
                return 1;
            }
        }
        return 0;
    }

    private String split(Integer integer) {
        String string = "[" + (integer-(integer%2))/2 + "," + (integer+(integer%2))/2 + "]";
        return string;
    }

    public void explode(Pair pair) {
        if(pair.equals(leftSide)) {
            parent.passLeftDown(this, (Integer) pair.leftSide);
            if(rightSide instanceof Integer) {
                Integer integer = (Integer) pair.rightSide + (Integer) rightSide;
                rightSide = integer;
            } else {
                Pair right = (Pair) rightSide;
                right.passRightUp((Integer) pair.rightSide);
            }
            leftSide = (Integer) 0;
        } else if(pair.equals(rightSide)) {
            parent.passRightDown(this, (Integer) pair.rightSide);
            if(leftSide instanceof Integer) {
                Integer integer = (Integer) pair.leftSide + (Integer) leftSide;
                leftSide = integer;
            } else {
                Pair left = (Pair) leftSide;
                left.passLeftUp((Integer) pair.leftSide);
            }
            rightSide = (Integer) 0;
        }
    }

    public void passLeftDown(Pair pair, Integer leftDown) {
        if(pair.equals(rightSide)) {
            if(leftSide instanceof Integer) {
                Integer integer = (Integer) leftSide + leftDown;
                leftSide =  integer;
            } else {
                Pair leftPair = (Pair) leftSide;
                leftPair.passLeftUp(leftDown);
            }
        } else if(pair.equals(leftSide)) {
            if(depth > 1) {
                parent.passLeftDown(this, leftDown);
            }
        }
    }

    public void passLeftUp(Integer leftUp) {
        if(rightSide instanceof Integer) {
            Integer integer = (Integer) rightSide + leftUp;
            rightSide = integer;
        } else {
            Pair pair = (Pair) rightSide;
            pair.passLeftUp(leftUp);
        }
    }

    public void passRightDown(Pair pair, Integer rightDown) {
        if(pair.equals(leftSide)) {
            if(rightSide instanceof Integer) {
                Integer integer = (Integer) rightSide + rightDown;
                rightSide =  integer;
            } else {
                Pair rightPair = (Pair) rightSide;
                rightPair.passRightUp(rightDown);
            }
        } else if(pair.equals(rightSide)) {
            if(depth > 1) {
                parent.passRightDown(this, rightDown);
            }
        }
    }

    public void passRightUp(Integer rightUp) {
        if(leftSide instanceof Integer) {
            Integer integer = (Integer) leftSide + rightUp;
            leftSide = integer;
        } else {
            Pair pair = (Pair) leftSide;
            pair.passRightUp(rightUp);
        }
    }

    public long getMagnitude() {
        long magnitude = 0;

        if(leftSide instanceof Integer) {
            magnitude += (Integer) leftSide * 3;
        } else {
            magnitude += ((Pair) leftSide).getMagnitude() * 3;
        }

        if(rightSide instanceof Integer) {
            magnitude += (Integer) rightSide * 2;
        } else {
            magnitude += ((Pair) rightSide).getMagnitude() * 2;
        }

        return magnitude;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("[");
        if(leftSide instanceof Pair) {
            Pair pair = (Pair) leftSide;
            stringBuilder.append(pair.toString());
        } else {
            Integer integer = (Integer) leftSide;
            stringBuilder.append(integer);
        }
        stringBuilder.append(",");
        if(rightSide instanceof Pair) {
            Pair pair = (Pair) rightSide;
            stringBuilder.append(pair.toString());
        } else {
            Integer integer = (Integer) rightSide;
            stringBuilder.append(integer);
        }
        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}
