public class FizzBuzz {

    public String convert(int number) {
        StringBuilder result = new StringBuilder();

        if (isMultipleOfThree(number)) {
            result.append("Fizz");
        }
        if (isMultipleOfFive(number)) {
            result.append("Buzz");
        }

        if (!isMultipleOfThree(number) && !isMultipleOfFive(number)) {
            result.append(String.valueOf(number));
        }

        return result.toString();

    }

    private boolean isMultipleOfFive(int number) {
        return number % 5 == 0;
    }

    private boolean isMultipleOfThree(int number) {
        return number % 3 == 0;
    }
}
