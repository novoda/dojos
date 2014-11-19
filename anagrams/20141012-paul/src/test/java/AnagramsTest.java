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
    public void testCalculateTotalAnagrams() throws Exception {
        String input = "four";

        List<String> output = Anagrams.generate(input);

        assertThat(output).hasSize(24);
    }

    @Test // testSwapFirstLetterIntoFirstPosition
    public void testOriginalWordIsAnAnagramOfItself() throws Exception {
        String input = "biro";

        List<String> output = Anagrams.generate(input);

        assertThat(output).contains("biro");
    }

    @Test
    public void testNewForCIPoints() throws Exception { // cAT@!!
        String input = "biro";

        List<String> output = Anagrams.generate(input);

        assertThat(output).contains("ibro");
    }

    @Test
    public void testSwapFirstLetterIntoSecondPosition() throws Exception {
        String input = "biro";

        List<String> output = Anagrams.generate(input);

        assertThat(output).contains("ibro");
    }

    @Test
    public void testSwapFirstLetterIntoThirdPosition() throws Exception {
        String input = "biro";

        List<String> output = Anagrams.generate(input);

        assertThat(output).contains("ribo");
    }

    @Test
    public void testSwapFirstLetterIntoFourthPosition() throws Exception {
        String input = "biro";

        List<String> output = Anagrams.generate(input);

        assertThat(output).contains("oirb");
    }

    @Test
    public void testSwapFirstLetterIntoAllPositions() throws Exception {
        String input = "blundell";

        List<String> output = Anagrams.generate(input);

        assertThat(output).contains(
                "blundell",
                "lbundell",
                "ulbndell",
                "nlubdell",
                "dlunbell",
                "elundbll",
                "llundebl",
                "llundelb");
    }

    @Test
    public void testSwapSecondLetterIntoFirstPosition() throws Exception {
        String input = "biro";

        List<String> output = Anagrams.generate(input);

        assertThat(output).contains("ibro");
    }

    @Test
    public void testSwapSecondLetterIntoSecondPosition() throws Exception {
        String input = "biro";

        List<String> output = Anagrams.generate(input);

        assertThat(output).contains("biro");
    }

    @Ignore // TODO
    @Test
    public void testSwapSecondLetterIntoThirdPosition() throws Exception {
        String input = "biro";

        List<String> output = Anagrams.generate(input);

        assertThat(output).contains("brio");
    }
}
