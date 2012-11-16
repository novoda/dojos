package com.fizzbuzz;

import static com.fizzbuzz.MultipleHelper.isMultipleOf;

public class FizzBuzz {

	public static final int FIZZ = 3;
	private static final int BUZZ = 5;

	public static boolean isFizz(int number) {
		return isMultipleOf(FIZZ, number);
	}
	
	public static boolean isBuzz(int number) {
		return isMultipleOf(BUZZ, number);
	}

	public static boolean isFizzBuzz(int number) {
		return isFizz(number) && isBuzz(number);
	}

}
