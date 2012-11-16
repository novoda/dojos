package com.fizzbuzz;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FizzBuzzShould {

	private static final int FIZZ = 3;

	@Test
	public void returnTrueIfFizzNumber(){
		assertTrue(isFizz(3));
	}
	
	@Test
	public void returnFalseIfNotFizzNumber(){
		assertFalse(isFizz(4));
	}

	private boolean isFizz(int number) {
		return MultipleHelper.isMultipleOf(FIZZ, number);
	}
	
}
