package com.sandpile;

import org.junit.Test;

import static org.junit.Assert.*;

public class PointShould {

    @Test
    public void confirm_two_points_are_equal(){
        assertEquals(new Point(3,2), new Point(3,2));
    }

    @Test
    public void confirm_two_points_are_not_equal(){
        assertNotSame(new Point(2, 1), new Point(3, 2));
    }

    @Test
    public void provide_the_point_above() {
        Point first = new Point(1, 4);
        assertEquals(first.above(), new Point(1,3));
    }

    @Test
    public void provide_the_point_below() {
        Point first = new Point(1, 3);
        assertEquals(first.below(), new Point(1,4));
    }

    @Test
    public void provide_the_point_to_its_right() {
        Point first = new Point(1, 3);
        assertEquals(first.right(), new Point(2, 3));
    }

    @Test
    public void provide_the_point_to_its_left() {
        Point first = new Point(2, 3);
        assertEquals(first.left(), new Point(1, 3));
    }

    @Test
    public void confirm_2_3_is_to_the_left_of_3_3() {
        Point first = new Point(2, 3);
        Point second = new Point(3,3);
        assertTrue(first.isToTheLeftOf(second));
    }

    @Test
    public void confirm_3_3_is_to_the_right_of_2_3() {
        Point first = new Point(3, 3);
        Point second = new Point(2,3);
        assertTrue(first.isToTheRightOf(second));
    }

    @Test
    public void confirm_4_1_is_above_4_2() {
        Point first = new Point(4, 1);
        Point second = new Point(4,2);
        assertTrue(first.isAbove(second));
    }

    @Test
    public void confirm_4_2_is_below_4_1() {
        Point first = new Point(4, 2);
        Point second = new Point(4,1);
        assertTrue(first.isBelow(second));
    }


}
