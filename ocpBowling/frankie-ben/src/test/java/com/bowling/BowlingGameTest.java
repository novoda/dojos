package com.bowling;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class BowlingGameTest {

    @Test
    public void gutterGameIsZero() throws Exception {

        BowlingGameFactory bowlingGameFactory = new BowlingGameFactory();

        BowlingGame bowlingGame = bowlingGameFactory.getBowlingGame();

        for (int i = 0; i < 20; i++) {
            bowlingGame.roll(0);
        }

        assertThat(bowlingGame.score()).isEqualTo(0);
    }

    @Test
    public void allOnesIsTwenty() throws Exception {

        BowlingGameFactory bowlingGameFactory = new BowlingGameFactory();

        BowlingGame bowlingGame = bowlingGameFactory.getBowlingGame();

        for (int i = 0; i < 20; i++) {
            bowlingGame.roll(1);
        }

        assertThat(bowlingGame.score()).isEqualTo(20);
    }
}
