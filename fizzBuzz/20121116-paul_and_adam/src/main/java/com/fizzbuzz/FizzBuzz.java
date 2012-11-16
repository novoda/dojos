package com.fizzbuzz;

import static com.fizzbuzz.MultipleHelper.isMultipleOf;

public class FizzBuzz {

	private static final String FIZZ_STR = "3";
	private static final String BUZZ_STR = "5";
	static final int FIZZ = 3;
	private static final int BUZZ = 5;

	public static boolean isFizz(int number) {
		return Integer.toString(number).contains(FIZZ_STR) || isMultipleOf(FIZZ, number);
	}
	
	public static boolean isBuzz(int number) {
		return Integer.toString(number).contains(BUZZ_STR) || isMultipleOf(BUZZ, number);
	}

	public static boolean isFizzBuzz(int number) {
		return isFizz(number) && isBuzz(number);
	}

}
