import java.util.List;

import org.junit.Ignore;
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

        List<String> output = Anagrams.generate(input);

        assertThat(output).hasSize(24);
    }

    @Test
    public void testFirstTwoLetterOfBiroAreSwapped() throws Exception {
        String input = "biro";

        List<String> output = Anagrams.generate(input);

        assertThat(output).contains("ibro");
    }

    @Test
    public void testFirstTwoLetterOfBenAreSwapped() throws Exception {
        String input = "ben";

        List<String> output = Anagrams.generate(input);

        assertThat(output).contains("ebn");
    }

    @Test
    public void testFirstLetterOfBenIsSwappedWithTheLast() throws Exception {
        String input = "ben";

        List<String> output = Anagrams.generate(input);

        assertThat(output).contains("neb");
    }

    @Ignore
    @Test
    public void testFirstLetterOfBiroIsSwappedWithTheLast() throws Exception {
        String input = "biro";

        List<String> output = Anagrams.generate(input);

        assertThat(output).contains("oirb");
    }
}
