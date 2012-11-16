package com.fizzbuzz;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NewRequirementsShould {

	@Test
	public void returnTrueIf13IsFizz(){
		assertTrue(FizzBuzz.isFizz(13));
	}
	
	@Test
	public void returnTrueIf15IsBuzz(){
		assertTrue(FizzBuzz.isBuzz(15));
	}
	
	@Test
	public void returnTrueIf33IsFizz(){
		assertTrue(FizzBuzz.isFizz(33));
	}
	
	@Test
	public void returnTrueIf55IsBuzz(){
		assertTrue(FizzBuzz.isBuzz(55));
	}
	
}
