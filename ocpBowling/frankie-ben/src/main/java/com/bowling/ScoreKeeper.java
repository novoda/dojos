package com.bowling;

public class ScoreKeeper {

    private int totalScore = 0;

    public void registerRoll(int pins) {
        totalScore += pins;
    }

    public int getScore() {
        return totalScore;
    }
}
