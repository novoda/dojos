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

    private List<Integer> list() {
        return new ArrayList<Integer>();
    }

}