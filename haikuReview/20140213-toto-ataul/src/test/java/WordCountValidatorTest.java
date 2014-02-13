import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WordCountValidatorTest {

    private WordCountValidator validator;

    @Before
    public void setUp() throws Exception {
        validator = new WordCountValidator();
    }

    @Test
    public void testInputWithTwoWordsIsNotValid() throws Exception {
        String input = "paul // smells";

        boolean result = validator.validate(input);

        assertFalse(result);
    }

    @Test
    public void testInputWithAtLeastThreeWordsIsValid() throws Exception {
        String input = "paul / smells/ badly !!!";

        boolean result = validator.validate(input);

        assertTrue(result);
    }

}
