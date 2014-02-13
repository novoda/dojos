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
        String input = HaikuReview.HAIKU_SEPARATOR + HaikuReview.HAIKU_SEPARATOR;

        boolean result = review.validate(input);

        assertTrue(result);
    }

    @Test
    public void testInputWithOneSlashIsNotValid() throws Exception {
        String input = HaikuReview.HAIKU_SEPARATOR;

        boolean result = review.validate(input);

        assertFalse(result);
    }
}
