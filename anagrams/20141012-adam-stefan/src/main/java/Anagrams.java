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

    private String word;

    public Anagrams(String word) {

        this.word = word;
    }

    public List<String> generate() {
        return makeListOfSize(getMaxCombinations());
    }

    int getMaxCombinations() {
        return (int) Math.pow(word.length(), word.length());
    }

    private List<String> makeListOfSize(int size) {
        List<String> list = new ArrayList<String>(size);
        for (int index = 0; index < size; index++) {
            list.add("");
        }
        return list;
    }

}
