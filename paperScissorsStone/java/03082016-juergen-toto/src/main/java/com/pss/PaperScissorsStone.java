package com.pss;

public class PaperScissorsStone {

    private final Gesture gesture1;
    private final Gesture gesture2;

    public PaperScissorsStone(Gesture gesture1, Gesture gesture2) {
        this.gesture1 = gesture1;
        this.gesture2 = gesture2;
    }

    public static PaperScissorsStone create(Gesture gesture1, Gesture gesture2) {
        return new PaperScissorsStone(gesture1, gesture2);
    }

    public Result play() {
        return gesture1.beats(gesture2);
    }

    public static abstract class Gesture {

        abstract Result beats(Gesture gesture);

    }
    public static class Paper extends Gesture {
        @Override
        Result beats(Gesture gesture) {
            if (gesture instanceof Paper) {
                return Result.TIE;
            }
            if (gesture instanceof Scissors) {
                return Result.LOSE;
            }
            return Result.WIN;
        }

    }
    public static class Stone extends Gesture {
        @Override
        Result beats(Gesture gesture) {
            if (gesture instanceof Stone) {
                return Result.TIE;
            }
            if (gesture instanceof Paper) {
                return Result.LOSE;
            }
            return Result.WIN;
        }

    }
    public static class Scissors extends Gesture {
        @Override
        Result beats(Gesture gesture) {
            if (gesture instanceof Scissors) {
                return Result.TIE;
            }
            if (gesture instanceof Stone) {
                return Result.LOSE;
            }
            return Result.WIN;
        }

    }


    public enum Result {
        WIN, LOSE, TIE
    }


}
