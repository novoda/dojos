import java.util.List;

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

        int output = Anagrams.generate(input).size();

        assertThat(output).isEqualTo(24);
    }

    @Test
    public void testOriginalWordIsAnAnagramOfItself() throws Exception {
        String input = "biro";

        List<String> output = Anagrams.generate(input);

        assertThat(output).contains("biro");
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

}
