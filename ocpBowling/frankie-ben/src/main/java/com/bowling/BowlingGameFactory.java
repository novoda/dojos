package com.bowling;

public class BowlingGameFactory {

    public BowlingGame getBowlingGame() {
        return new BowlingGame(new ScoreKeeper(new SpareBonusCalculator()));
    }
}
