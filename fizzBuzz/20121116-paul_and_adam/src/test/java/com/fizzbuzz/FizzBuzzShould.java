package com.fizzbuzz;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FizzBuzzShould {

	@Test
	public void returnTrueIfFizzNumber(){
		assertTrue(FizzBuzz.isFizz(3));
	}
	
	@Test
	public void returnFalseIfNotFizzNumber(){
		assertFalse(FizzBuzz.isFizz(4));
	}
	
}
