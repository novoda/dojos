package com.bowling;

public class StrikeBonusCalculator implements BonusCalculator {

    private int totalBonus = 0;
    private int frameIndex = 0;

    @Override
    public int getBonus(int[] rolls) {
        for (int i = 0; i < rolls.length -1; i++) {
            addStrikeBonusIfNeeded(rolls, i);
        }
        return totalBonus;
    }

    private void addStrikeBonusIfNeeded(int[] rolls, int position) {
        if (isStrike(rolls, position) ) {
            if (! (position + 2 > rolls.length)) {
            totalBonus = rolls[position + 1] + rolls[position + 2];
            }
        }
    }

    private boolean isStrike(int[] rolls, int position) {
        return rolls[position] == 10;
    }
}
