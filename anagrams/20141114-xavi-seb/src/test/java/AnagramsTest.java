import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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


    private static final String A = "a";
    private static final List<String> ANAGRAMS_FOR_A = new ArrayList<String>() {{ add("a"); }};

    private static final String AB = "ab";
    private static final List<String> ANAGRAMS_FOR_AB = new ArrayList<String>() {{ add("ab"); add("ba"); }};

    @Test
    public void testOneCharAnagramIsItself() throws Exception {
        List<String> expected = ANAGRAMS_FOR_A;

        List<String> anagrams = new Anagrams().from(A);

        assertThat(anagrams).isEqualTo(expected);
    }

    @Test
    public void testAnagramsForAbHasCorrectLength() throws Exception {
        List<String> expected = ANAGRAMS_FOR_AB;

        List<String> anagrams = new Anagrams().from(AB);

        assertThat(anagrams).hasSameSizeAs(expected);
    }

    @Test
    @Ignore
    public void testAllAnagramsAreSameLengthAsInput() throws Exception {
        List<String> expected = ANAGRAMS_FOR_AB;

        List<String> anagrams = new Anagrams().from(AB);

        for (String anagram : anagrams) {
            assertThat(anagram).hasSize(AB.length());
        }
        // TODO: This test is wrong!
    }
}
