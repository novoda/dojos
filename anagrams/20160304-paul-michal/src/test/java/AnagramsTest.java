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
    public void testReverseInput2CharAnagram() throws Exception {

        Anagrams anagrams = new Anagrams();

        assertThat(anagrams.anagram("bi")).contains("ib");
    }

    @Test
    public void testReverseInput3CharAnagram() throws Exception {

        Anagrams anagrams = new Anagrams();

        assertThat(anagrams.anagram("bir")).contains("rib");
    }

    @Test
    public void testRepositionTwoIsStartInput3CharAnagram() throws Exception {

        Anagrams anagrams = new Anagrams();

        assertThat(anagrams.anagram("bir")).contains("irb");
    }

}
