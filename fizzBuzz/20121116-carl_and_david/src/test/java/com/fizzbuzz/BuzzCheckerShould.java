package com.fizzbuzz;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;

public class BuzzCheckerShould {

	@Test
	public void ensure_multiple_of_5_are_checked(){
		assertTrue(new BuzzChecker().check(5));
	}
}
