package com.bowling;

public class ScoreKeeper {

    private final BonusCalculator bonusCalculator;

    private int totalScore = 0;

    private int[] rolls = new int[21];
    private int index = 0;

    public ScoreKeeper(BonusCalculator bonusCalculator) {
        this.bonusCalculator = bonusCalculator;
    }

    public void registerRoll(int pins) {
        totalScore += pins;
        rolls[index++] = pins;
    }

    public int getScore() {
        return totalScore + bonusCalculator.getBonus(rolls);
    }
}
