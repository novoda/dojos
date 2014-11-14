import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Write a program to generate all potential
 * anagrams of an input string.
 * <p/>
 * For example, the potential anagrams of "biro" are
 * <p/>
 * biro bior brio broi boir bori
 * ibro ibor irbo irob iobr iorb
 * rbio rboi ribo riob roib robi
 * obir obri oibr oirb orbi orib
 */
public class AnagramsTest {

    @Test
    public void testUseFestItRocks() throws Exception {
        assertThat(true).isEqualTo(true);
    }

    @Test
    public void testCalculateTotalAnagrams() throws Exception {
        String input = "biro";

        int output = Anagrams.total(input);

        assertThat(output).isEqualTo(24);
    }

    @Test
    public void testFirstTwoLetterOfBiroAreSwapped() throws Exception {
        String input = "biro";

        String output = Anagrams.generate(input);

        assertThat(output).isEqualTo("ibro");
    }

    @Test
    public void testFirstTwoLetterOfBenAreSwapped() throws Exception {
        String input = "ben";

        String output = Anagrams.generate(input);

        assertThat(output).isEqualTo("ebn");
    }
}
