package com.fizzbuzz;

public class FizzBuzzer {
    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";
    static final String FIZZBUZZ = "FizzBuzz";

    public FizzBuzzer() {
    }

    String fizzBuzz(int i) {
        if (isFizzBuzz(i)) {
            return FIZZBUZZ;
        } else if (isFizz(i)) {
            return FIZZ;
        } else if (isBuzz(i)) {
            return BUZZ;
        } else {
            return "" + i;
        }
    }

    private boolean isFizzBuzz(int i) {
        return (multipleOfThree(i) && multipleOfFive(i)) || (containsFive(i) && containsThree(i));
    }

    private boolean isFizz(int i) {
        return multipleOfThree(i) || containsThree(i);
    }

    private boolean isBuzz(int i) {
        return multipleOfFive(i) || containsFive(i);
    }

    private boolean containsFive(int i) {
        return containsNumber(i, "5");
    }

    private boolean containsThree(int i) {
        return containsNumber(i, "3");
    }

    private boolean containsNumber(int i, String s) {
        return String.valueOf(i).contains(s);
    }

    boolean multipleOfFive(int i) {
        return i % 5 == 0;
    }

    boolean multipleOfThree(int i) {
        return i % 3 == 0;
    }
}