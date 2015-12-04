public class FizzBuzz {
    public String output(int input) {
        if (input % 3 == 0) {
            return "Fizz";
        }
        if (input == 5) {
            return "Buzz";
        }
        return String.valueOf(input);
    }
}
