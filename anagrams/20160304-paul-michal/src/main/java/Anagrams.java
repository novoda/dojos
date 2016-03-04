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


    public List<String> anagram(String input) {
        final List<String> anagrams = new ArrayList<String>();

        char[] chars = input.toCharArray();

        String reverse = getReverse(chars);
        anagrams.add(reverse);

        String twoIsStart = getTwoIsStart(chars);
        anagrams.add(twoIsStart);

        return anagrams;
    }

    private String getReverse(char[] chars) {
        char[] output = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            output[i] = reverse(chars, i);
        }
        return String.valueOf(output);
    }

    private char reverse(char[] chars, int i) {
        return chars[chars.length - i - 1];
    }

    private String getTwoIsStart(char[] chars) {
        char[] output = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            output[i] = twoIsStart(chars, i);
        }
        return String.valueOf(output);
    }

    private char twoIsStart(char[] chars, int i) {
        return chars[(i + 1) % chars.length];
    }
}
