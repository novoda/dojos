import java.util.StringTokenizer;

public class WordCountValidator {

    private static final int MIN_WORDS = 3;

    public boolean validate(String input) {
        StringTokenizer tokenizer = new StringTokenizer(input, " /", false);
        return tokenizer.countTokens() >= MIN_WORDS;
    }

}
