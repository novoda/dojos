import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class HaikuReviewTest {

    private HaikuReview haikuReview;

    @Before
    public void setUp() throws Exception {
        haikuReview = new HaikuReview();
    }

    @Test
    public void givenTheCorrectNumberOfLines_ThenIsCorrectLinesForHaiku() throws Exception {
        String input = "line1/line2/line3";

        boolean b = haikuReview.hasThreeLines(input);

        assertThat(b).isTrue();
    }

    @Test
    public void givenAnIncorrectNumberOfLines_ThenIsNotAHaiku() throws Exception {
        String input = "line1/line2";

        boolean b = haikuReview.hasThreeLines(input);

        assertThat(b).isFalse();
    }

    @Test
    public void givenUppercaseCharacters_ThenReturnFalse() throws Exception {
        String input = "failonUPPERCASE";

        boolean b = isOnlyLowerCase(input);

        assertThat(b).isFalse();
    }

    @Test
    public void givenACorrectHaiku_ThenTestHasLowerCaseLettersOnly() throws Exception {
        String input = HaikuReview.INPUT_TWO;

        boolean b = isOnlyLowerCase(input);

        assertThat(b).isTrue();
    }

    @Test
    public void givenAWordOfTwoNonConsequtiveVowels_ThenAnswerIs2() throws Exception {
        String input = "code";

        int i = haikuReview.numberOfSyllables(input);

        assertThat(i).isEqualTo(2);
    }

    @Test
    public void givenAWordWithTwoConsecutiveVowels_ThenAnsweris1() throws Exception {
        String input = "Good";

        int i = haikuReview.numberOfSyllables(input);

        assertThat(i).isEqualTo(1);
    }

    @Test
    public void givenAHaikuLineWithThreeWords_ThenAnswerIs5() {
        String input = "happy purple frog";

        int i = haikuReview.numberOfSyllables(input);

        assertThat(i).isEqualTo(5);
    }

    @Test
    public void givenACorrectHaiku_ReturnASplitHaiku() {
        String input = HaikuReview.INPUT_TWO;

        String[] s = haikuReview.splitHaiku(input);

        assertThat(s).hasSize(3);

    }

    @Test
    public void testIsHaiku() throws Exception {
        String input = HaikuReview.INPUT_ONE;

        boolean b = haikuReview.isHaiku(input);

        assertThat(b).isTrue();
    }

    boolean isOnlyLowerCase(String haiku) {
        return haiku.replace("/", "").replace(" ", "").matches("[a-z]*");
    }


}
