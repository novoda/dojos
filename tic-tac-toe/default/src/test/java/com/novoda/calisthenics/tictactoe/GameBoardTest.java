package com.novoda.calisthenics.tictactoe;

import org.junit.Test;

public class GameBoardTest {

    @Test
    public void showTheBoardOnADisplay() throws Exception {
        GameBoard board = new GameBoard();
        board.display(null);
    }
}
