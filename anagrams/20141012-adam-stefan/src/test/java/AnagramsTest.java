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

    private final static int BIRO_MAX_COMBINATIONS = 256;

    @Test
    public void testUseFestItRocks() throws Exception {
        assertThat(true).isEqualTo(true);
    }

    @Test
    public void testMaximumLetterCount() {
        Anagrams anagrams = new Anagrams("biro");

        List<String> output = anagrams.generate();

        assertThat(output.size()).isEqualTo(BIRO_MAX_COMBINATIONS);
    }
    
    @Test
    public void testMaximumLetterCount2() {
        Anagrams anagrams = new Anagrams("biro");

        List<String> output = anagrams.generate();

        assertThat(output.size()).isEqualTo(BIRO_MAX_COMBINATIONS);
    }
    
    @Test
    public void testMaximumLetterCount3() {
        Anagrams anagrams = new Anagrams("biro");

        List<String> output = anagrams.generate();

        assertThat(output.size()).isEqualTo(BIRO_MAX_COMBINATIONS);
    }
    
}
