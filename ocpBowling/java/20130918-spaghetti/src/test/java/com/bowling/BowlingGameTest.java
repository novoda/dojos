package com.bowling;

import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.assertEquals;

public class BowlingGameTest {

    @Test
    public void scoreZeroForGutterGame() {
        BowlingGame game = BowlingGameFactory.createBowlingGame();

        while (!game.isEnded()){
            game.roll(0);
        }

        assertEquals(game.getScore(), 0);
    }

    @Ignore
    @Test
    public void scoreTwentyForAllOnesGame() {
        BowlingGame game = BowlingGameFactory.createBowlingGame();

        while (!game.isEnded()){
            game.roll(1);
        }

        assertEquals(game.getScore(), 20);
    }
}
