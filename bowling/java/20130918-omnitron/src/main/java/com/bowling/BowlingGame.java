package com.bowling;

/**
* Created by acsia on 18/09/13.
*/
class BowlingGame implements Game {

    private ScoreCalculator calculator;

    @Override
    public int getScore() {
        return calculator.compute();
    }

    @Override
    public void roll(int pins) {

    }
}
