package com.bowling;

public class GameFactory {
    public static Game createGame() {
        return new DefaultGame(new AccumulatingScoreKeeper());
    }
}
