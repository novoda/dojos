package com.bowling;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class GameShould {

    private static final int MAX_GAME_ROLL = 20;

    @Test
    public void return_a_score_of_0() {
        Game game = GameFactory.newGame();

        for (int i = 0; i < MAX_GAME_ROLL; i++) {
            game.roll(0);
        }

        assertThat(game.getScore(), is(0));
    }

    @Test
    public void return_a_score_of_20_when_1_pin_has_been_knocked() throws Exception {
        Game game = GameFactory.newGame();
        for (int i = 0; i < MAX_GAME_ROLL; i++) {
            game.roll(1);
        }
        assertThat(game.getScore(), is(20));
    }

}
