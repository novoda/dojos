package com.fizzbuzz;

public class Something {
	
	public static void main(String[] args){
		FizzBuzzPrinter fizzBuzzPrinter = new FizzBuzzPrinter();
		for (int i = 1; i < 101; i++) {
			System.out.println(fizzBuzzPrinter.print(i));
		}
	}
	
}