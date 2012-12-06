package com.fizzbuzz;

public class FizzBuzzPrinter {

	public String print(int i) {
		if(FizzBuzz.isFizzBuzz(i)){
			return "FizzBuzz";
		} else
		if(FizzBuzz.isFizz(i)){
			return "Fizz";
		} else
			if(FizzBuzz.isBuzz(i)){
				return "Buzz";
			}
		return  ""+i;
	}

}
