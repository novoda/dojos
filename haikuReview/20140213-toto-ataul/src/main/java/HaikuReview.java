import java.util.StringTokenizer;

public class HaikuReview {

    private static final String INPUT_ONE = "happy purple frog/eating bugs in the marshes/get indigestion";
    private static final String INPUT_TWO = "computer programs/the bugs try to eat my code/i will not let them";

    private static final char HAIKU_SEPARATOR = '/';
    private static final int SEPARATORS_COUNT = 2;
    private static final int MIN_WORDS = 3;

    boolean validateSeparators(String input) {
        int separatorsCounter = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == HAIKU_SEPARATOR) {
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
