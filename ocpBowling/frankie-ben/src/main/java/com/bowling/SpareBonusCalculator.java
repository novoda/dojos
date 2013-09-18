package com.bowling;

public class SpareBonusCalculator {

    private int totalBonus = 0;

    public int getBonus(int[] rolls) {
        for (int i = 0; i < rolls.length -1; i = i + 2) {
            if (rolls[i] + rolls[i+1] == 10) {
                totalBonus = rolls[i + 2];
            }
        }
        return totalBonus;
    }
}
