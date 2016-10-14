package com.ryry;

import java.util.Arrays;

public class Board {

    public static final Board EMPTY_BOARD = new Board(new String[]{
            "-", "-", "-",
            "-", "-", "-",
            "-", "-", "-"
    });

    private final String[] positions;

    public Board(String[] positions) {
        this.positions = positions;
    }

    public boolean hasPlayed(int position) {
        return !positions[position].equals("-");
    }

    public void playMoveAt(int position, Player player) {
        positions[position] = player.name();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Board board = (Board) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(positions, board.positions);

    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(positions);
    }
}
