package com.fizzbuzz;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class BuzzCheckerShould {

	@Test
	public void ensure_multiple_of_5_are_checked(){
		assertTrue(new BuzzChecker().check(5));
	}

	@Test
	public void return_false_if_not_multiple_of_5(){
		assertFalse(new BuzzChecker().check(4));
	}
}
