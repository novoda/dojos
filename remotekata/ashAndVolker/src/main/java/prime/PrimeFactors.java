package prime;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {
    public static List<Integer> generate(int i) {

        ArrayList<Integer> factors = new ArrayList<Integer>();
        if (i > 1) {
            factors.add(i);
        }
        return factors;
    }
}
