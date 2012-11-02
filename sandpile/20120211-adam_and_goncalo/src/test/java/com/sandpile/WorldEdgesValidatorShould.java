package com.sandpile;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WorldEdgesValidatorShould {

    private int maxSize = 10;

    private Point topLeftCorner = new Point(0, 0);
    private Point bottomRightCorner = new Point(maxSize, maxSize);

    WorldEdgesValidator validator = new WorldEdgesValidator(topLeftCorner, bottomRightCorner);

    @Test
    public void validate_a_point(){
        assertTrue(validator.isInsideTheWorld(new Point(maxSize / 2, maxSize / 2)));
    }

    @Test
    public void invalidate_a_point_above_the_top_edge(){
        assertFalse(validator.isInsideTheWorld(topLeftCorner.above()));
    }

    @Test
    public void invalidate_a_point_to_the_left_of_the_left_edge(){
        assertFalse(validator.isInsideTheWorld(topLeftCorner.left()));
    }

    @Test
    public void invalidate_a_point_to_the_right_of_the_right_edge(){
        assertFalse(validator.isInsideTheWorld(bottomRightCorner.below()));
    }

    @Test
    public void invalidate_a_point_below_the_bottom_edge(){
        assertFalse(validator.isInsideTheWorld(bottomRightCorner.right()));
    }

}
