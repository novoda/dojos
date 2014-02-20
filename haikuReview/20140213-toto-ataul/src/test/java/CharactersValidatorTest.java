import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CharactersValidatorTest {

    private CharactersValidator validator;

    @Before
    public void setUp() throws Exception {
        validator = new CharactersValidator();
    }

    @Test
    public void testLowerCaseCharactersAreValid() throws Exception {
        String input = "fajklsdfhkladsfj";

        boolean result = validator.validate(input);

        assertTrue(result);
    }

    @Test
    public void testUpperCaseCharactersAreNotValid() throws Exception {
        String input = "aaaWERWERWwerw  \t";

        boolean result = validator.validate(input);

        assertFalse(result);
    }

}
