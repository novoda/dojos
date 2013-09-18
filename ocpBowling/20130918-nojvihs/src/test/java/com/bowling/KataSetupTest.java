package com.bowling;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class KataSetupTest {

    public static final int ROUNDS_TO_PLAY = 20;
    private Game game;

    @Before
    public void setUp() throws Exception {
        game = GameFactory.createGame();
    }

    @Test
    public void testIsSetup() throws Exception {
        KataSetup kataSetup = new KataSetup();

        boolean setup = kataSetup.isSetup();

        assertThat(setup).isTrue();
    }

    @Test
    public void scoreZeroForGutterGame() {
        playGameWithEveryRoundScoring(0);

        assertEquals(game.getScore(), 0);
    }

    @Test
    public void scoreTwentyForAllOnesGame() throws Exception {
        playGameWithEveryRoundScoring(1);

        assertEquals(game.getScore(), 20);
    }

    private void playGameWithEveryRoundScoring(int score) {
        for (int i = 0; i < ROUNDS_TO_PLAY; i++) {
            game.bowl(score);
        }
    }
}
