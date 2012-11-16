package com.fizzbuzz;

public class FizzBuzzer {
    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";
    static final String FIZZBUZZ = "FizzBuzz";

    public FizzBuzzer() {
    }

    String fizzBuzz(int i) {
        if (multipleOfThree(i) && multipleOfFive(i)) {
            return FIZZBUZZ;
        } else if (multipleOfThree(i)) {
            return FIZZ;
        } else if (multipleOfFive(i)) {
            return BUZZ;
        } else {
            return "" + i;
        }
    }

    boolean multipleOfFive(int i) {
        return i % 5 == 0;
    }

    boolean multipleOfThree(int i) {
        return i % 3 == 0;
    }
}