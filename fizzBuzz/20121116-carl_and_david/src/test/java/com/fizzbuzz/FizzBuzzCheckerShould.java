package com.fizzbuzz;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class FizzBuzzCheckerShould {

	@Test
	public void print_fizz() {

		FizzBuzz fb = new FizzBuzz();
		assertEquals(fb.print(1), "1");
	}
}
