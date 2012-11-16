package com.fizzbuzz;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FizzBuzzPrinterShould {

	@Test
	public void printInput(){
		assertEquals("1", new FizzBuzzPrinter().print(1));
	}
	
}
