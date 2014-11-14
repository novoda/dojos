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

    private ArrayList<String> ANAGRAMS_FOR_A = new ArrayList<String>() {{ add("a"); }};

    @Test
    public void testOneCharAnagramIsItself() throws Exception {
        List<String> expected = ANAGRAMS_FOR_A;

        List<String> anagrams = new Anagrams().from("a");
        
        assertThat(anagrams).isEqualTo(expected);
    }
}
