package com.bowling;

import java.util.ArrayList;

public class BowlingGameFrameGenerator {

    int firstRoll;
    int secondRoll;

    public BowlingGameFrameGenerator() {

    }

    private void resetState() {
        firstRoll = -1;
        secondRoll = -1;
    }

    public BowlingGameFrame roll(int pins) {
        if (firstRoll == -1) {
            firstRoll = pins;
            if (firstRoll == 10) {
                return new StrikeFrame();
            }
        }
        else{
            secondRoll = pins;


        }
        return null;
    }

    public ArrayList<BowlingGameFrame> initGame(){
        return new ArrayList<BowlingGameFrame>();
    }



}
