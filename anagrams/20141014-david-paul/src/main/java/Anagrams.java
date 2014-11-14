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

    public static int total(String anagram) {
        int accumulative = 1;

        for (int i = anagram.length() - 1; i > 0; --i) {
            accumulative += accumulative * i;
        }

        return accumulative;
    }

    public static String generate(String input) {
        char[] inputChars = input.toCharArray();

        char move = inputChars[0];
        char replace = inputChars[1];
        inputChars[0] = replace;
        inputChars[1] = move;

        String output = String.valueOf(inputChars);

        return output;
    }
}
