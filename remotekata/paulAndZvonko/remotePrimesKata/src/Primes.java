import java.util.ArrayList;
import java.util.List;

public class Primes {

    public static List<Integer> generate(int input) {
        ArrayList<Integer> factors = new ArrayList<Integer>();
        if (input == 1) {
            return factors;
        }
        factors.add(input);
        return factors;
    }

}
