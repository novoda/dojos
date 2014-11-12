package com.novoda.calisthenics.tictactoe;

public class GameBoard {

    // What is this pattern called and why is it important?
    public void display(GameBoardDisplay display) {
        display.updateCell(null, null);
        display.updateCell(null, null);
        display.updateCell(null, null);
    }
}
