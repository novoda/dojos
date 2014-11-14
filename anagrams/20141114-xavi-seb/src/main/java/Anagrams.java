import java.util.ArrayList;
import java.util.List;

/**
 * Write a program to generate all potential
 * anagrams of an input string.
 * <p/>
 * For example, the potential anagrams of "biro" are
 * <p/>
 * biro bior brio broi boir bori
 * ibro ibor irbo irob iobr iorb
 * rbio rboi ribo riob roib robi
 * obir obri oibr oirb orbi orib
 */
public class Anagrams {

    public List<String> from(String word) {
        List<String> anagrams = new ArrayList<String>();
        for (int i = 0; i < word.length(); i++) {
            anagrams.addAll(generatePermutationsFor(word));
        }
        return anagrams;
    }

    List<String> generatePermutationsFor(String word) {
        int count = factorial(word.length() - 1);
        List<String> permutations = new ArrayList<String>(count);
        for (int i = 0; i < count; i++) {
            permutations.add(word);
        }
        return permutations;
    }

    int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return factorial(n - 1) * n;
    }

}
