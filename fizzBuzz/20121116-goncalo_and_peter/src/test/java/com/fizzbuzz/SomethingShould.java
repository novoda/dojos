package com.fizzbuzz;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class SomethingShould{

    @Test
    public void print_one_as_a_number() {
        assertEquals("1", fizzBuzz(1));
    }

    @Test
    public void print_two_as_a_number() {
        assertEquals("2", fizzBuzz(2));
    }

    private String fizzBuzz(int i) {
        return ""+i;  //To change body of created methods use File | Settings | File Templates.
    }
}
