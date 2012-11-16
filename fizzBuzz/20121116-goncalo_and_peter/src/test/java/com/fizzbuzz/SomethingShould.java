package com.fizzbuzz;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class SomethingShould {

    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";

    @Test
    public void print_one_as_a_number() {
        assertEquals("1", fizzBuzz(1));
    }

    @Test
    public void print_two_as_a_number() {
        assertEquals("2", fizzBuzz(2));
    }

    @Test
    public void print_three_as_FIZZ() {
        assertEquals(FIZZ, fizzBuzz(3));
    }

    @Test
    public void print_four_as_a_number() {
        assertEquals("4", fizzBuzz(4));
    }

    @Test
    public void print_five_as_Buzz() {
        assertEquals(BUZZ, fizzBuzz(5));
    }

    @Test
    public void print_six_as_FIZZ() {
        assertEquals(FIZZ, fizzBuzz(6));
    }

    @Test
    public void print_ten_as_Buzz() {
        assertEquals(BUZZ, fizzBuzz(10));
    }

    @Test
    public void print_fiftteen_as_Buzz() {
        assertEquals(FIZZ+BUZZ, fizzBuzz(15));
    }

    private String fizzBuzz(int i) {
        if (i % 3 == 0 && i % 5 == 0) {
            return FIZZ + BUZZ;
        } else if (i % 3 == 0) {
            return FIZZ;
        } else if (i % 5 == 0) {
            return BUZZ;
        } else {
            return "" + i;
        }
    }
}
