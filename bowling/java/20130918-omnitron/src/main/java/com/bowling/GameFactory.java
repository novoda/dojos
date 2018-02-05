package com.bowling;

/**
 * Created by acsia on 18/09/13.
 */
public class GameFactory {

    public static Game newGame() {
        return new BowlingGame();
    }

}
