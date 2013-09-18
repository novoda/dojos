package com.bowling;

public class TotalBonusCalculator implements BonusCalculator {

    private final SpareBonusCalculator spareBonusCalculator;
    private final StrikeBonusCalculator strikeBonusCalculator;

    public TotalBonusCalculator(SpareBonusCalculator spareBonusCalculator, StrikeBonusCalculator strikeBonusCalculator) {
        this.spareBonusCalculator = spareBonusCalculator;
        this.strikeBonusCalculator = strikeBonusCalculator;
    }

    @Override
    public int getBonus(int[] rolls) {
        return spareBonusCalculator.getBonus(rolls) + strikeBonusCalculator.getBonus(rolls);
    }
}
