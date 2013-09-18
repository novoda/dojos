package com.bowling;

public class StrikeBonusCalculator implements BonusCalculator {

    private int totalBonus = 0;

    @Override
    public int getBonus(int[] rolls) {
        for (int i = 0; i < rolls.length -1; i++) {
            addStrikeBonusIfNeeded(rolls, i);
        }
        return totalBonus;
    }

    private void addStrikeBonusIfNeeded(int[] rolls, int i) {
        if (isStrike(rolls, i)) {
            totalBonus = rolls[i + 1] + rolls[i + 2];
        }
    }

    private boolean isStrike(int[] rolls, int i) {
        return rolls[i] == 10;
    }
}
