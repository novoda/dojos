import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HaikuReviewTest {

    @Test
    public void testHaikuMustHaveTwoSlashes() throws Exception {
        String input = HaikuReview.HAIKU_SEPARATOR + HaikuReview.HAIKU_SEPARATOR;

        boolean result = HaikuReview.hasTwoSlashes(input);

        assertTrue(result);
    }

    @Test
    public void testInputWithOneSlashIsNotValid() throws Exception {
        String input = HaikuReview.HAIKU_SEPARATOR;

        boolean result = HaikuReview.hasTwoSlashes(input);

        assertFalse(result);
    }
}
