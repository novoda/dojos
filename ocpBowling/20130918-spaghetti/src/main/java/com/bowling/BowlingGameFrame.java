package com.bowling;

public abstract class BowlingGameFrame {
    private final int firstRoll;

    private final int secondRoll;

    public BowlingGameFrame(){
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
    }

    public int getSecondRoll() {
        return secondRoll;
    }

    public int getFirstRoll() {
        return firstRoll;
    }

    public abstract int getScore(BowlingGameFrame nextFrame);

}
