import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HaikuReviewTest {

    private HaikuReview review;

    @Before
    public void setUp() throws Exception {
        review = new HaikuReview();
    }

    @Test
    public void testInputWithTwoSlashesIsValid() throws Exception {
        String input = "//";

        boolean result = review.validateSeparators(input);

        assertTrue(result);
    }

    @Test
    public void testInputWithOneSlashIsNotValid() throws Exception {
        String input = "/";

        boolean result = review.validateSeparators(input);

        assertFalse(result);
    }

    @Test
    public void testInputWithThreeSlashesIsNotValid() throws Exception {
        String input = "///";

        boolean result = review.validateSeparators(input);

        assertFalse(result);
    }

    @Test
    public void testInputWithTwoWordsIsNotValid() throws Exception {
        String input = "paul // smells";

        boolean result = review.validateWordCount(input);

        assertFalse(result);
    }

    @Test
    public void testInputWithAtLeastThreeWordsIsValid() throws Exception {
        String input = "paul / smells/ badly !!!";

        boolean result = review.validateWordCount(input);

        assertTrue(result);
    }


}
