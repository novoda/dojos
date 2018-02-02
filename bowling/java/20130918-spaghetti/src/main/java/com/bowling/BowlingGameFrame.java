package com.bowling;

public abstract class BowlingGameFrame {
    private final int firstRoll;

    private final int secondRoll;

    public BowlingGameFrame(){
        this.firstRoll = 0;
        this.secondRoll = 1;
    }

    public int getSecondRoll() {
        return secondRoll;
    }

    public int getFirstRoll() {
        return firstRoll;
    }

    public abstract int getScore(BowlingGameFrame nextFrame);

}
