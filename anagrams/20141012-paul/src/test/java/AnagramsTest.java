import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

    private List<String> output;

    @Test
    public void testCalculateTotalAnagrams() throws Exception {
        String input = "four";

        int output = Anagrams.generate(input).size();

        assertThat(output).isEqualTo(24);
    }

    @Test
    public void testOriginalWordIsAnAnagramOfItself() throws Exception {
        String input = "biro";

        List<String> output = Anagrams.generate(input);

        assertList(output).contains("biro");
    }

    @Test
    public void testSwapFirstLetterIntoSecondPosition() throws Exception {
        String input = "biro";

        List<String> output = Anagrams.generate(input);

        assertList(output).contains("ibro");
    }

    @Test
    public void testSwapFirstLetterIntoThirdPosition() throws Exception {
        String input = "biro";

        List<String> output = Anagrams.generate(input);

        assertList(output).contains("ribo");
    }

    @Test
    public void testSwapFirstLetterIntoFourthPosition() throws Exception {
        String input = "biro";

        List<String> output = Anagrams.generate(input);

        assertList(output).contains("oirb");
    }

    @Test
    public void testSwapFirstLetterIntoAllPositions() throws Exception {
        String input = "blundell";

        List<String> output = Anagrams.generate(input);

        assertList(output).contains(
                "blundell",
                "lbundell",
                "ulbndell",
                "nlubdell",
                "dlunbell",
                "elundbll",
                "llundebl",
                "llundelb");
    }

    private AnagramsTest assertList(List<String> output) {
        assertFalse("Actual List was null", output == null);
        this.output = output;
        return this;
    }

    private void contains(String... expected) {
        String msg = "List was: " + output + " \n"
                + " Expected to contain: " + Arrays.asList(expected);
        assertTrue(msg, output.containsAll(Arrays.asList(expected)));
    }

}
