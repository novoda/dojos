package com.novoda.primenumbers;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PrimeNumbersTest {

    Integer[] ONE = {};
    Integer[] TWO = {2};
    Integer[] THREE = {3};
    Integer[] FOUR = {2, 2};
    Integer[] SIX = {2, 3};

    @Test
    public void testOneHasNoPrimitives() {
        assertThat(list(ONE), is(PrimeNumbers.generate(1)));
    }

    @Test
    public void testTwoHasPrimeFactorTwo() {
        assertThat(list(TWO), is(PrimeNumbers.generate(2)));
    }

    @Test
    public void testThreeHasPrimeFactorThree() {
        assertThat(list(THREE), is(PrimeNumbers.generate(3)));
    }

    @Test
    public void testFourHasPrimeFactorTwoAndTwo() {
        assertThat(list(FOUR), is(PrimeNumbers.generate(4)));
    }

//    @Test
//    public void testSixHasPrimeFactorThreeAndTwo() {
//        assertThat(list(SIX), is(PrimeNumbers.generate(6)));
//    }

    private List<Integer> list(Integer[] number) {
        return Arrays.asList(number);
    }

}