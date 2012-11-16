package com.fizzbuzz;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FizzBuzzPrinterShould {

	@Test
	public void printInput(){
		assertEquals("1", new FizzBuzzPrinter().print(1));
	}
	
	@Test
	public void printFizzIfInputIsAFizz(){
		assertEquals("Fizz", new FizzBuzzPrinter().print(FizzBuzz.FIZZ));
	}
	
	@Test
	public void printBuzzIfInputIsABuzz(){
		assertEquals("Buzz", new FizzBuzzPrinter().print(FizzBuzz.BUZZ));
	}
	
	@Test
	public void printFizzBuzzIfInputIsAFizzBuzz(){
		assertEquals("FizzBuzz", new FizzBuzzPrinter().print(35));
	}
}
