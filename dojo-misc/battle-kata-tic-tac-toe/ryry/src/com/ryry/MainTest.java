package com.ryry;

import junit.framework.TestCase;

public class MainTest extends TestCase {

    public void testThatGivenIPlayAtAPositionWhenCheckingThatPositionThenItHasBeenPlayed() throws Exception {
        Board emptyBoard = Board.EMPTY_BOARD;
        emptyBoard.playMoveAt(0, Player.PLAYER_ONE);
        boolean hasPlayed = emptyBoard.hasPlayed(0);

        assertTrue(hasPlayed);
    }
}