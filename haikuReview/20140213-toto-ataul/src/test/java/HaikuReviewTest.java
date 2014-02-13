import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class HaikuReviewTest {

    @Test
    public void testThatTestsRun() throws Exception {
        assertThat(true).isEqualTo(true);
    }

    @Test
    public void testHaikuHasTwoSlashes() throws Exception {
        String input = "//";

        boolean result = HaikuReview.hasTwoSlashes(input);

        assert(result);
    }

}
