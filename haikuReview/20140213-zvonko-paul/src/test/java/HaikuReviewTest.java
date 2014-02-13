import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class HaikuReviewTest {

    @Test
    public void testThatTestsRun() throws Exception {
        assertThat(true).isEqualTo(true);
    }

    @Test
    public void testCountIsFiveForValidInput() throws Exception {
        String input = "happy purple frog";

        int count = HaikuReview.getNumberOfSyllables(input);

        assertThat(count).isEqualTo(5);
    }

    @Test
    public void testCountIsSevenForValidInput() throws Exception {
        String input = "eating bugs in the marshes";

        int count = HaikuReview.getNumberOfSyllables(input);

        assertThat(count).isEqualTo(7);
    }

    @Test
    public void testIndigestionHasFourSyllables() throws Exception {
        String input = "indigestion";

        int count = HaikuReview.getNumberOfSyllables(input);

        assertThat(count).isEqualTo(4);
    }

    @Test
    public void testCountIsSevenForValidInputWithContinuousSyllables() throws Exception {
        String input = "get indigestion";

        int count = HaikuReview.getNumberOfSyllables(input);

        assertThat(count).isEqualTo(5);
    }

    @Test
    public void testIsVowel() throws Exception {
        String[] input = {"a", "e", "i", "o", "u", "y"};
        for (String s : input) {
            boolean isVowel = HaikuReview.isVowel(s);

            assertThat(isVowel).isTrue();
        }
    }

    @Test
    public void testIsNotVowel() throws Exception {
        String input = "b";

        boolean isVowel = HaikuReview.isVowel(input);

        assertThat(isVowel).isFalse();
    }

    @Test
    public void testIsSyllable() throws Exception {
        String[] input = {"a", "e", "i", "o", "u", "y"};
        for (String s : input) {
            boolean isSyllable = HaikuReview.isSyllable(s);

            assertThat(isSyllable).isTrue();
        }
    }

    @Test
    public void testTwoContinuousVowelsIsOneSyllable() throws Exception {

        boolean isSyllable = HaikuReview.isSyllable("ae");

        assertThat(isSyllable).isTrue();
    }

    @Test
    public void testIsNotASyllable() throws Exception {

        boolean isSyllable = HaikuReview.isSyllable("code");

        assertThat(isSyllable).isFalse();
    }

    @Test
    public void testNumberOfLinesThreeGivenValidInput() throws Exception {
        String input = "happy purple frog/eating bugs in the marshes/get indigestion";

        int numberOfLines = HaikuReview.getNumberOfLines(input);

        assertThat(numberOfLines).isEqualTo(3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidNumberOfLinesForHaiku() throws Exception {
        String invalidHaiku = "fail/haiku";

        HaikuReview.processHaiku(invalidHaiku);

    }


}
