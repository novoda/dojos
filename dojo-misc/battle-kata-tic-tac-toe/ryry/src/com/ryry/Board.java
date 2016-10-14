package com.ryry;

import java.util.Arrays;
import java.util.List;

public class Board {

    private List<String> boardPositions = Arrays.asList(
            "-", "-", "-",
            "-", "-", "-",
            "-", "-", "-"
    );

    public boolean hasPlayed(int position) {
        return !boardPositions.get(position).equals("-");
    }

    public void playMoveAt(int position, Player player) {
        boardPositions.set(position, player.name());
    }

}
