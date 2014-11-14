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

    private static int total(String anagram) {
        int accumulative = 1;

        for (int i = anagram.length() - 1; i > 0; --i) {
            accumulative += accumulative * i;
        }

        return accumulative;
    }

    public static List<String> generate(String input) {
        List<String> anagrams = new ArrayList<String>();

        char[] inputChars = input.toCharArray();

        for (int i = 0; i < total(input); i++) {
            int movePosition = i < input.length() ? i : 0;
            char move = inputChars[movePosition];
            char replace = inputChars[1];
            inputChars[movePosition] = replace;
            inputChars[1] = move;

            String output = String.valueOf(inputChars);

            anagrams.add(output);
        }

        return anagrams;
    }
}
