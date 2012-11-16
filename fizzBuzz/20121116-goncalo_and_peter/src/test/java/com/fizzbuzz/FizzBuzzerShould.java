package com.fizzbuzz;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class FizzBuzzerShould {

    private final FizzBuzzer fizzBuzzer = new FizzBuzzer();

    @Test
    public void print_one_as_a_number() {
        assertEquals("1", fizzBuzzer.fizzBuzz(1));
    }

    @Test
    public void print_two_as_a_number() {
        assertEquals("2", fizzBuzzer.fizzBuzz(2));
    }

    @Test
    public void print_three_as_FIZZ() {
        assertEquals(FizzBuzzer.FIZZ, fizzBuzzer.fizzBuzz(3));
    }

    @Test
    public void print_four_as_a_number() {
        assertEquals("4", fizzBuzzer.fizzBuzz(4));
    }

    @Test
    public void print_five_as_Buzz() {
        assertEquals(FizzBuzzer.BUZZ, fizzBuzzer.fizzBuzz(5));
    }

    @Test
    public void print_six_as_FIZZ() {
        assertEquals(FizzBuzzer.FIZZ, fizzBuzzer.fizzBuzz(6));
    }

    @Test
    public void print_ten_as_Buzz() {
        assertEquals(FizzBuzzer.BUZZ, fizzBuzzer.fizzBuzz(10));
    }

    @Test
    public void print_fiftteen_as_Buzz() {
        assertEquals(FizzBuzzer.FIZZBUZZ, fizzBuzzer.fizzBuzz(15));
    }

    @Test
    public void print_thirty_as_FizzBuzz() {
        assertEquals(FizzBuzzer.FIZZBUZZ, fizzBuzzer.fizzBuzz(30));
    }
}
