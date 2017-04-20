package com.bowling;

public class DefaultGame implements Game {
    private ScoreKeeper scoreKeeper;

    public DefaultGame(ScoreKeeper scoreKeeper) {
        this.scoreKeeper = scoreKeeper;
    }

    @Override
    public void bowl(int pinsHit) {
        scoreKeeper.addScore(pinsHit);
    }

    @Override
    public int getScore() {
        return scoreKeeper.getScore();
    }
}
