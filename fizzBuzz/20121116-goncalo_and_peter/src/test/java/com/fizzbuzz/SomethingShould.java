package com.fizzbuzz;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class SomethingShould {

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
        assertEquals("Fizz", fizzBuzz(3));
    }

    @Test
    public void print_four_as_a_number() {
        assertEquals("4", fizzBuzz(4));
    }

    @Test
    public void print_five_as_Buzz() {
        assertEquals("Buzz", fizzBuzz(5));
    }

    @Test
    public void print_six_as_FIZZ() {
        assertEquals("Fizz", fizzBuzz(6));
    }

    private String fizzBuzz(int i) {
        if (i % 3 == 0) {
            return "Fizz";
        } else if (i == 5) {
            return "Buzz";
        } else {
            return "" + i;
        }
    }
}
