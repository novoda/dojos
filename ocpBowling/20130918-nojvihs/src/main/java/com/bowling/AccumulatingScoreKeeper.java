package com.bowling;

public class AccumulatingScoreKeeper implements ScoreKeeper {

    private int score;

    @Override
    public void addScore(int pinsHit) {
        score += pinsHit;
    }

    @Override
    public int getScore() {
        return score;
    }
}
