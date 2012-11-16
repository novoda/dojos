package com.fizzbuzz;

public class FizzChecker implements Checker {
	@Override
	public boolean check(int i) {
		return i % 3 == 0;
	}
}
