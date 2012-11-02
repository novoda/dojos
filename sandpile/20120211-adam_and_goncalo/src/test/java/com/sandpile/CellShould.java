package com.sandpile;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class CellShould {

    AvalancheDetector avalancheDetector = mock(AvalancheDetector.class);
    final Cell cell = new Cell(new Point(1,2), avalancheDetector);

    @Test
    public void cause_an_avalanche_after_dropping_4_grains_are_dropped() {
        dropGrains(4);
        verify(avalancheDetector).newAvalanche(any(Point.class));
    }

    @Test
    public void not_cause_an_avalanche_after_when_1_grain_is_dropped() {
        dropGrains(1);
        verify(avalancheDetector, never()).newAvalanche(any(Point.class));
    }

    @Test
    public void not_cause_an_avalanche_after_when_2_grains_are_dropped() {
        dropGrains(2);
        verify(avalancheDetector, never()).newAvalanche(any(Point.class));
    }

    @Test
    public void not_cause_an_avalanche_after_when_3_grains_are_dropped() {
        dropGrains(3);
        verify(avalancheDetector, never()).newAvalanche(any(Point.class));
    }

    @Test
    public void cause_an_avalanche_after_dropping_8_grains_are_dropped() {
        dropGrains(8);
        verify(avalancheDetector, times(2)).newAvalanche(any(Point.class));
    }

    @Test
    public void cause_an_avalanche_after_dropping_12_grains_are_dropped() {
        dropGrains(12);
        verify(avalancheDetector, times(3)).newAvalanche(any(Point.class));
    }

    @Test
    public void cause_an_avalanche_after_dropping_16_grains_are_dropped() {
        dropGrains(16);
        verify(avalancheDetector, times(4)).newAvalanche(any(Point.class));
    }

    private void dropGrains(int numberOfGrains) {
        for(int grain = 0; grain < numberOfGrains; grain++){
            cell.dropGrain();
        }
    }

}
