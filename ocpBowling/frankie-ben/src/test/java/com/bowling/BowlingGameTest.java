package com.bowling;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class BowlingGameTest {

    private BowlingGame bowlingGame = new BowlingGameFactory().getBowlingGame();

    @Test
    public void gutterGameIsZero() throws Exception {
        rollMany(20, 0);

        assertThat(bowlingGame.score()).isEqualTo(0);
    }

    @Test
    public void allOnesIsTwenty() throws Exception {
        rollMany(20, 1);

        assertThat(bowlingGame.score()).isEqualTo(20);
    }

    private void rollMany(int count, int pins) {
        for (int i = 0; i < count; i++) {
            bowlingGame.roll(pins);
        }
    }
}
