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
	
	@Test
	public void returnTrueIfBuzzNumber(){
		assertTrue(FizzBuzz.isBuzz(5));
	}
	
	@Test
	public void returnFalseIfNotBuzzNumber(){
		assertFalse(FizzBuzz.isBuzz(4));
	}
	
	@Test
	public void returnTrueIfFizzBuzzNumber(){
		assertTrue(FizzBuzz.isFizzBuzz(30));
	}
	
	@Test
	public void returnFalseIfNotFizzBuzzNumber(){
		assertFalse(FizzBuzz.isFizzBuzz(4));
	}
}
