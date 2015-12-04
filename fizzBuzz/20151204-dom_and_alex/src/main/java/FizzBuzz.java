public class FizzBuzz {
    public String output(int input) {
        if (modulo(input, 3) && modulo(input, 5)) {
            return "FizzBuzz";
        }
        if (modulo(input, 3)) {
            return "Fizz";
        }
        if (modulo(input, 5)) {
            return "Buzz";
        }
        return String.valueOf(input);
    }

    private boolean modulo(int input, int modulo) {
        return input % modulo == 0;
    }
}
