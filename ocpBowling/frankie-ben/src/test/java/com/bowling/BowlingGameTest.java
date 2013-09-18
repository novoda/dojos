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

    @Test
    public void oneSpare() throws Exception {
        rollSpare();
        rollMany(18, 1);

        assertThat(bowlingGame.score()).isEqualTo(29);
    }

    @Test
    public void oneSpareAtTheEnd() throws Exception {
        rollMany(18, 1);
        rollSpare();
        rollMany(1, 1);

        assertThat(bowlingGame.score()).isEqualTo(30);
    }

    @Test
    public void oneStrike() throws Exception {
        rollStrike();
        rollMany(18, 1);

        assertThat(bowlingGame.score()).isEqualTo(30);
    }

    private void rollStrike() {
        bowlingGame.roll(10);
    }

    private void rollSpare() {
        bowlingGame.roll(6);
        bowlingGame.roll(4);
    }

    private void rollMany(int count, int pins) {
        for (int i = 0; i < count; i++) {
            bowlingGame.roll(pins);
        }
    }
}
