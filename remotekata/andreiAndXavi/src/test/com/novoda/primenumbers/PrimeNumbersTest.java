package com.novoda.primenumbers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class PrimeNumbersTest {

    @Test
    public void testOne() {
        assertThat(list(), is(PrimeNumbers.generate(1)));
    }

    @Test
    public void testTwoHasPrimeFactorTwo() {
        assertThat(list(2), is(PrimeNumbers.generate(2)));
    }

    private List<Integer> list() {
        return new ArrayList<Integer>();
    }

    private List<Integer> list(Integer number) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(number);
        return list;
    }

}