import java.util.HashSet;
import java.util.Set;

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

    public Set<String> generateFor(String input) {
        Set<String> results = new HashSet<String>();
        results.add(input);
        char[] reverse = new char[input.length()];
        for (int i = input.length() -1; i >= 0; i--) {
             reverse[input.length() - 1 - i] = input.charAt(i);
        }
        results.add(new String(reverse));
        return results;
    }
}
