package com.sandpile;

public class Cell {
    private static final int AVALANCHE = 4;
    private final Point point;
    private final AvalancheDetector avalancheDetector;
    private int grainCounter;

    public Cell(Point point, AvalancheDetector avalancheDetector) {
        this.point = point;
        this.avalancheDetector = avalancheDetector;
    }

    public void dropGrain() {
        grainCounter++;
        if (isAvalanche()) {
            grainCounter = 0;
            avalancheDetector.newAvalanche(point);
        }
    }

    private boolean isAvalanche() {
        return grainCounter == AVALANCHE;
    }
}