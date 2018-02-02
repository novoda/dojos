package com.bowling;

public class FrameFactory {

    public static FirstRoll roll(int roll) {
        return new FirstRoll(roll);
    }

    public static class FirstRoll {

        public FirstRoll(int roll) {

        }

        public Frame strike() {
            return new StrikeFrame();
        }

        public Frame spare() {
            return new SpareFrame();
        }

        public Frame nonStrikeOrSpare() {
            return new NonStrikeOrSpareFrame();
        }
    }
}
