import org.junit.Before;
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

    private static final String ABC = "abc";
    private static final List<String> ANAGRAMS_FOR_ABC = new ArrayList<String>() {{ add("abc"); add("acb"); add("bac"); add("bca"); add("cab"); add("cba"); }};

    Anagrams anagrams;

    @Before
    void setup() {
        anagrams = new Anagrams();
    }

    @Test
    public void testAnagramForAIsItself() throws Exception {
        List<String> expected = ANAGRAMS_FOR_A;

        List<String> result = anagrams.from(A);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void testAnagramsForAbHasCorrectLength() throws Exception {
        List<String> expected = ANAGRAMS_FOR_AB;

        List<String> result = anagrams.from(AB);

        assertThat(result).hasSameSizeAs(expected);
    }

    @Test
    public void testAnagramsForAbcHasCorrectLength() {
        List<String> expected = ANAGRAMS_FOR_ABC;

        List<String> result = anagrams.from(ABC);

        assertThat(result).hasSameSizeAs(expected);
    }




    @Test
    @Ignore
    public void testAllAnagramsAreSameLengthAsInput() throws Exception {
        List<String> expected = ANAGRAMS_FOR_AB;

        List<String> result = anagrams.from(AB);

        for (String anagram : result) {
            assertThat(anagram).hasSize(AB.length());
        }
        // TODO: This test is wrong!
    }
}
