package com.bowling;

import java.util.ArrayList;

public class BowlingGame {
    public static final int MAX_FRAMES_NUMBER = 10;

    private final BowlingGameFrameGenerator generator;
    private final ArrayList<BowlingGameFrame> frames;

    public BowlingGame(){
        generator = new BowlingGameFrameGenerator();
        frames = generator.initGame();
    }

    public void roll(int pins){
        BowlingGameFrame currentFrame = generator.roll(pins);
        if (currentFrame != null) {
            frames.add(currentFrame);
        }
    }

    public boolean isEnded() {
        // TODO roll after strike as a
        return true;
    }

    public int getScore() {
        return 0;
    }
}
