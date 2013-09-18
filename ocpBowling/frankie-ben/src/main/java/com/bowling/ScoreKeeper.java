package com.bowling;

public class ScoreKeeper {

    private final SpareBonusCalculator spareBonusCalculator;

    private int totalScore = 0;

    private int[] rolls = new int[23];
    private int index = 0;

    public ScoreKeeper(SpareBonusCalculator spareBonusCalculator) {
        this.spareBonusCalculator = spareBonusCalculator;
    }

    public void registerRoll(int pins) {
        totalScore += pins;
        rolls[index++] = pins;
    }

    public int getScore() {
        return totalScore + spareBonusCalculator.getBonus(rolls);
    }
}
