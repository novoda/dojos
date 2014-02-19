import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class HaikuReviewTest {

    private static final String VALID_INPUT_ONE = "happy purple frog/eating bugs in the marshes/get indigestion";
    private static final String VALID_INPUT_TWO = "computer programs/the bugs try to eat my code/i will not let them";

    private static final String INVALID_FIRST_LINE = "a a a a a invalid/a a a a a a a/a a a a a";
    private static final String INVALID_SECOND_LINE = "a a a a a/a a a a a a a invalid/a a a a a";
    private static final String INVALID_THIRD_LINE = "a a a a a/a a a a a a a/a a a a a invalid";
    private static final String INVALID_LINE_COUNT = "the bugs try to eat my code/i will not let them";
    private static final String INVALID_COUNT_474 = "a a a a/a a a a a a a/a a a a";
    private static final String INVALID_COUNT_373 = "a a a/a a a a a a a/a a a";

    private HaikuReview haikuReview;

    @Before
    public void setUp() throws Exception {
        haikuReview = new HaikuReview();
    }

    @Test
    public void testValidWhenHasThreeLines() throws Exception {
        boolean validated = haikuReview.validateLineCount(VALID_INPUT_ONE);
        assertThat(validated).isTrue();
    }

    @Test
    public void testNotValidWhenHasTwoLines() throws Exception {
        boolean validated = haikuReview.validateLineCount(INVALID_LINE_COUNT);
        assertThat(validated).isFalse();
    }

    @Test
    public void testInvalidWhenLessThenThreeWords() throws Exception {
        boolean validated = haikuReview.validateLineCount("a//c");

        assertThat(validated).isFalse();
    }

    @Test
    public void testValidWhenHasThreeWords() throws Exception {
        boolean validated = haikuReview.validateLineCount("a/b/c");
        assertThat(validated).isTrue();
    }

    @Test
    public void testCorrectNumberOfWords() throws Exception {
        int wordCount = haikuReview.countWords("happy purple frog");

        assertThat(wordCount).isEqualTo(3);
    }

    @Test
    public void testCorrectNumberOfWordsForCompleteHaiku() throws Exception {
        int wordCount = haikuReview.countWords(VALID_INPUT_ONE);

        assertThat(wordCount).isEqualTo(10);
    }

    @Test
    public void testSplitsLines() {
        String[] lines = haikuReview.asLines(VALID_INPUT_ONE);
        assertThat(lines.length).isEqualTo(3);
    }

    @Test
    public void testEachLineIsSplitCorrectly() {
        String[] lines = haikuReview.asLines(VALID_INPUT_ONE);

        assertThat(lines[0]).isEqualTo("happy purple frog");
        assertThat(lines[1]).isEqualTo("eating bugs in the marshes");
        assertThat(lines[2]).isEqualTo("get indigestion");
    }

    @Test
    public void testNumberOfSyllablesIsOne() {
        int syllableCount = haikuReview.countSyllables("ups");
        assertThat(syllableCount).isEqualTo(1);
    }

    @Test
    public void testNumberOfSyllablesIsTwo() {
        int syllableCount = haikuReview.countSyllables("hello");
        assertThat(syllableCount).isEqualTo(2);
    }

    @Test
    public void testNumberOfSyllablesIsOneWithConsecutiveVowels() {
        int syllableCount = haikuReview.countSyllables("hey");
        assertThat(syllableCount).isEqualTo(1);
    }

    @Test
    public void testNumberOfSyllablesForThreeWords() {
        int syllableCount = haikuReview.countSyllables("happy purple bee");
        assertThat(syllableCount).isEqualTo(5);
    }

    @Test
    public void testWellFormedInputIsHaiku() {
        boolean isHaiku = haikuReview.isHaiku(VALID_INPUT_ONE);

        assertThat(isHaiku).isTrue();
    }

    @Test
    public void testIncorrectNumberOfSyllablesInFirstLineIsNotHaiku() throws Exception {
        boolean isHaiku = haikuReview.isHaiku(INVALID_FIRST_LINE);

        assertThat(isHaiku).isFalse();
    }

    @Test
    public void testIncorrectNumberOfSyllablesInSecondLineInNotHaiku() throws Exception {
        boolean isHaiku = haikuReview.isHaiku(INVALID_SECOND_LINE);

        assertThat(isHaiku).isFalse();
    }

    @Test
    public void testIncorrectNumberOfSyllablesInThirdLineInNotHaiku() throws Exception {
        boolean isHaiku = haikuReview.isHaiku(INVALID_THIRD_LINE);

        assertThat(isHaiku).isFalse();
    }

    @Test
    public void testOutputForValidHaikuHasYes() throws Exception {
        String output = haikuReview.review(VALID_INPUT_ONE);

        assertThat(output).contains("Yes");
    }

    @Test
    public void testOutputForInvalidHaikuHasNo() throws Exception {
        String output = haikuReview.review(INVALID_FIRST_LINE);

        assertThat(output).contains("No");
    }

    @Test
    public void testOutputSyllableCountForValidHaikuIs575Yes() throws Exception {
        String output = haikuReview.review(VALID_INPUT_ONE);

        assertThat(output).isEqualTo("5,7,5,Yes");
    }

    @Test
    public void testOutputSyllableCountForInvalidHaikuIsCorrect() throws Exception {
        String output = haikuReview.review(INVALID_COUNT_474);

        assertThat(output).isEqualTo("4,7,4,No");
    }

    @Test
    public void testOutputSyllableCountForAnotherInvalidHaikuIsCorrect() throws Exception {
        String output = haikuReview.review(INVALID_COUNT_373);

        assertThat(output).isEqualTo("3,7,3,No");
    }
}
