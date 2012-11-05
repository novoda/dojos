package com.sandpile;

import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class WorldCellAvalanchesIntegrationTest {

    @Test
    public void cause_two_avalanches_when_8_grains_were_dropped_on_it_of_which_3_are_from_other_avalanches() {
        AvalancheDetector mock = mock(AvalancheDetector.class);
        FakeWorld fakeworld = new FakeWorld(mock);

        fakeworld.dropGrain();
        fakeworld.dropGrain();
        fakeworld.dropGrain();
        fakeworld.dropGrain();
        fakeworld.dropGrain();

        verify(mock, times(2)).newAvalanche(any(Point.class));
    }

    static class FakeWorld implements AvalancheDetector {

        final AvalancheDetector avalancheDetector;
        final Cell cell;

        FakeWorld(AvalancheDetector avalancheDetector) {
            this.avalancheDetector = avalancheDetector;
            this.cell = new Cell(new Point(0, 0), this);
        }

        @Override
        public void newAvalanche(Point point) {
            avalancheDetector.newAvalanche(point);
            dropGrain();
            dropGrain();
            dropGrain();
        }

        void dropGrain() {
            cell.dropGrain();
        }
    }


}
