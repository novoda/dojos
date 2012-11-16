package com.fizzbuzz;

public class MultipleHelper {

	public static boolean isMultipleOf(int multiple, int number) {
		if(number == 0){
			return false;
		}
    	return (number % multiple) == 0;
    }
	
}
