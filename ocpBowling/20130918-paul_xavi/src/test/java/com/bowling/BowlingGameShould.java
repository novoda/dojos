package com.bowling;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingGameShould {

    public static final int TOTAL_GAMES = 20;
    private BowlingGame game;

    @Before
    public void setUp() {
        game = BowlingGameFactory.newGame();
    }

    @Test
    public void scoreZeroForGutterGame() throws Exception {
        int score = 0;
        playTotalGamesWithScore(game, score);

        int totalScore = 0;
        assertEquals("Total score not zero.", game.getTotalScore(), totalScore);
    }

    @Test
    public void scoreTwentyForAllOnesGame() throws Exception {
        int score = 1;
        playTotalGamesWithScore(game, score);

        int totalScore = 20;
        assertEquals("Total score not " + totalScore, game.getTotalScore(), totalScore);

    }

    @Test
    public void scoreForSpareInOneFrame() {
        game.roll(4);
        game.roll(6);
        game.roll(3);
        assertEquals("Total score not 13", game.getTotalScore(), 13);

    }


    private void playTotalGamesWithScore(BowlingGame game, int score) {
        for (int i = 0; i < TOTAL_GAMES; i++) {
            game.roll(score);
        }
    }

}
