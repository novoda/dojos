package com.fizzbuzz;

public class FizzBuzzer {
    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";
    static final String FIZZBUZZ = "FizzBuzz";

    public FizzBuzzer() {
    }

    String fizzBuzz(int i) {
        if ((multipleOfThree(i) && multipleOfFive(i)) || (containsFive(i) && containsThree(i))) {
            return FIZZBUZZ;
        } else if (multipleOfThree(i) || containsThree(i)) {
            return FIZZ;
        } else if (multipleOfFive(i) || containsFive(i)) {
            return BUZZ;
        } else {
            return "" + i;
        }
    }

    private boolean containsFive(int i) {
        return String.valueOf(i).contains("5");
    }

    private boolean containsThree(int i) {
        return String.valueOf(i).contains("3");
    }

    boolean multipleOfFive(int i) {
        return i % 5 == 0;
    }

    boolean multipleOfThree(int i) {
        return i % 3 == 0;
    }
}