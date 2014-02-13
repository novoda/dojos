import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SeparatorsValidatorTest {

    private SeparatorsValidator validator;

    @Before
    public void setUp() throws Exception {
        validator = new SeparatorsValidator();
    }

    @Test
    public void testInputWithTwoSlashesIsValid() throws Exception {
        String input = "//";

        boolean result = validator.validate(input);

        assertTrue(result);
    }

    @Test
    public void testInputWithOneSlashIsNotValid() throws Exception {
        String input = "/";

        boolean result = validator.validate(input);

        assertFalse(result);
    }

    @Test
    public void testInputWithThreeSlashesIsNotValid() throws Exception {
        String input = "///";

        boolean result = validator.validate(input);

        assertFalse(result);
    }

}
