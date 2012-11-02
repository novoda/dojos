package com.sandpile;

import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class WorldShould {

    AvalancheDetector avalancheDetector = mock(AvalancheDetector.class);

    int boardSize = 5;
    Point topleftCorner = new Point(0, 0);
    Point bottomRightCorner = new Point(boardSize - 1, boardSize - 1);
    WorldEdgesValidator validator = new WorldEdgesValidator(topleftCorner, bottomRightCorner);

    World world = new World(avalancheDetector, validator);
    Point middle = new Point(boardSize / 2, boardSize / 2);

    private void dropGrains(int numberOfGrains, Point point) {
        for(int grain = 0; grain < numberOfGrains; grain++){
            world.dropGrain(point);
        }
    }

    @Test
    public void cause_two_avalanches_after_dropping_8_grains_of_sand_in_the_middle(){
        dropGrains(8, middle);

        verify(avalancheDetector, times(2)).newAvalanche(any(Point.class));
    }

    @Test
    public void cause_two_avalanches_after_dropping_4_grains_of_sand_in_the_middle_and_3_to_its_left_point(){
        dropGrains(4, middle);
        dropGrains(3, middle.left());

        verify(avalancheDetector, times(2)).newAvalanche(any(Point.class));
    }

    @Test
    public void not_cause_an_avalanche_when_grains_are_dropped_outside_the_world() {
        dropGrains(4, topleftCorner.above());

        verify(avalancheDetector, never()).newAvalanche(any(Point.class));
    }

}
