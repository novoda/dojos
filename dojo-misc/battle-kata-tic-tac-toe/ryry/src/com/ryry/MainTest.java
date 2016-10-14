package com.ryry;

import junit.framework.TestCase;

public class MainTest extends TestCase {

    public void testgiven() throws Exception {
        Board board = new Board();

        board.playMoveAt(0, Player.PLAYER_ONE);
        boolean hasPlayed = board.hasPlayed(0);

        assertTrue(hasPlayed);
    }
}