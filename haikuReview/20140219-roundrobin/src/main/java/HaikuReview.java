import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HaikuReview {

    private static final String LINE_SEPARATOR = "/";
    public static final int FIRST_LINE_SYLLABLE_COUNT = 5;
    public static final int SECOND_LINE_SYLLABLE_COUNT = 7;
    public static final int THIRD_LINE_SYLLABLE_COUNT = 5;
    public static final String RESULT_VALID = "5,7,5,Yes";
    public static final String RESULT_SEPARATOR = ",";
    public static final String RESULT_NO = "No";

    public boolean validateLineCount(String input) {
        Pattern pattern = Pattern.compile("[a-zA-Z ]+/[a-zA-Z ]+/[a-zA-Z ]+");
        return pattern.matcher(input).matches();
    }

    public int countWords(String input) {
        return new StringTokenizer(input, " /").countTokens();
    }

    public String[] asLines(String input) {
        return input.split(LINE_SEPARATOR);
    }

    public int countSyllables(String input) {
        int count = 0;
        Pattern pattern = Pattern.compile("[aeouiy]+");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    public boolean isHaiku(String input) {
        if (!validateLineCount(input)) {
            return false;
        }

        String[] lines = asLines(input);
        if (countSyllables(lines[0]) != FIRST_LINE_SYLLABLE_COUNT) {
            return false;
        }
        if (countSyllables(lines[1]) != SECOND_LINE_SYLLABLE_COUNT) {
            return false;
        }
        if (countSyllables(lines[2]) != THIRD_LINE_SYLLABLE_COUNT) {
            return false;
        }
        return true;
    }

    public String review(String input) {
        if (isHaiku(input)) {
            return RESULT_VALID;
        }

        String[] lines = asLines(input);

        String lineOne = formattedSyllableCount(lines[0]);
        String lineTwo = formattedSyllableCount(lines[1]);
        String lineThree = formattedSyllableCount(lines[2]);

        return lineOne + lineTwo + lineThree + RESULT_NO;

    }

    private String formattedSyllableCount(String line) {
        return countSyllables(line) + RESULT_SEPARATOR;
    }
}
