package com.bowling;

public class SpareBonusCalculator {

    private int totalBonus = 0;

    public int getBonus(int[] rolls) {
        for (int i = 0; i < rolls.length -1; i = i + 2) {
            addSpareBonusIfNeeded(rolls, i);
        }
        return totalBonus;
    }

    private void addSpareBonusIfNeeded(int[] rolls, int i) {
        if (isSpare(rolls, i)) {
            totalBonus = rolls[i + 2];
        }
    }

    private boolean isSpare(int[] rolls, int i) {
        return rolls[i] + rolls[i+1] == 10;
    }
}
