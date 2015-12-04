public class FizzBuzz {
    public String output(int input) {
        String output = "";
        if (modulo(input, 3)) {
            output += "Fizz";
        }
        if (modulo(input, 5)) {
            output += "Buzz";
        }
        if (output.length() != 0) {
            return output;
        }
        return String.valueOf(input);
    }

    private boolean modulo(int input, int modulo) {
        return input % modulo == 0;
    }
}
