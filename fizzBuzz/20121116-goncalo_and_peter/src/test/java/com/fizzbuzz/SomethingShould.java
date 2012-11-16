package com.fizzbuzz;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class SomethingShould {

    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";
    private static final String FIZZBUZZ = "FizzBuzz";

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
        assertEquals(FIZZBUZZ, fizzBuzz(15));
    }

    private String fizzBuzz(int i) {
        if (multipleOfThree(i) && multipleOfFive(i)) {
            return FIZZBUZZ;
        } else if (multipleOfThree(i)) {
            return FIZZ;
        } else if (multipleOfFive(i)) {
            return BUZZ;
        } else {
            return "" + i;
        }
    }

    private boolean multipleOfFive(int i) {
        return i % 5 == 0;
    }

    private boolean multipleOfThree(int i) {
        return i % 3 == 0;
    }
}
