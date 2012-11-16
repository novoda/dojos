package com.fizzbuzz;

public class FizzBuzz {

	public void print(int from, int to) {
	}

	public String print(int i) {

		FizzChecker fizz = new FizzChecker();
		if (fizz.check(i)) {
			return "fizz";
		} else {
			return i + "";
		}
	}
}
