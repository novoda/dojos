package com.bowling;

public class BowlingGame {
    private int totalScore;

    public BowlingGame(){
        totalScore = 0;
    }

    public void roll(int score) {
        totalScore += score;
    }

    public int getTotalScore() {
        return totalScore;
    }
}
