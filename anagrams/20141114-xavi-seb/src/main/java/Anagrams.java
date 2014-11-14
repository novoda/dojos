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

    public List<String> from(String a) {
        List<String> strings = new ArrayList<String>();
        for (int i = 0; i < a.length(); i++) {
            strings.add(a);
        }
        return strings;
    }
}
