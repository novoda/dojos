package com.bowling;

public class BowlingGame {

    private final ScoreKeeper scoreKeeper;

    public BowlingGame(ScoreKeeper scoreKeeper) {
        this.scoreKeeper = scoreKeeper;
    }

    public void roll(int pins) {
       scoreKeeper.registerRoll(pins);
    }

    public int score() {
        return scoreKeeper.getScore();
    }
}
