import java.util.StringTokenizer;

public class HaikuReview {

    public static final char HAIKU_SEPARATOR = '/';

    private static final String INPUT_ONE = "happy purple frog/eating bugs in the marshes/get indigestion";
    private static final String INPUT_TWO = "computer programs/the bugs try to eat my code/i will not let them";
    public static final int MIN_WORDS = 3;
    public static final int SEPARATORS_COUNT = 2;

    boolean validateSeparators(String input) {
        int separatorsCounter = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '/') {
                separatorsCounter++;
            }
        }

        return separatorsCounter == SEPARATORS_COUNT;
    }

    boolean validateWordCount(String input) {
        StringTokenizer tokenizer = new StringTokenizer(input, " /", false);
        return tokenizer.countTokens() >= MIN_WORDS;
    }

}
