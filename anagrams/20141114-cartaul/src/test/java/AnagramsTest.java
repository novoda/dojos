import java.util.Set;

import org.junit.Before;
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

    private Anagrams anagrams;

    @Before
    public void setUp() {
        anagrams = new Anagrams();
    }

    @Test
    public void itDoesNotAffectSingleCharacters() throws Exception {
        Set<String> results = anagrams.generateFor("a");
        assertThat(results.size()).isEqualTo(1);
        assertThat(results).contains("a");
    }

    @Test
    public void returnsAllAnagramsForTwoCharacterInput() throws Exception {
        Set<String> results = anagrams.generateFor("ab");
        assertThat(results.size()).isEqualTo(2);
        assertThat(results).contains("ab");
        assertThat(results).contains("ba");
    }

}
