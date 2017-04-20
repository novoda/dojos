import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Haiku is an ancient form of Japanese poetry. A haiku
 * is a three-line poem with seventeen syllables, where
 * the first line must contain five syllables, the second
 * line must contain seven syllables, and the third line
 * must contain five syllables. The lines do not have to
 * rhyme. Here is an example, where slashes separate the
 * lines:
 * <p>
 * >Computer programs/The bugs try to eat my code/I must not let them.
 * <p>
 * <p>
 * You must write a program that will review a haiku and
 * check that each line contains the correct number of
 * syllables.
 * <p>
 * Input
 * ------------
 * <p>
 * The input contains one or more lines, each of which
 * contains a single haiku. A haiku will contain at least
 * three words, and words will be separated by either a
 * single space or a slash ('/'). Slashes also separate
 * the three lines of a haiku, so each haiku will contain
 * exactly two slashes. (The three lines of the haiku will
 * be contained within one physical line of the file.)
 * <p>
 * A haiku will contain only lowercase letters ('a'-'z'),
 * forward slashes ('/'), and spaces, and will be no more
 * than 200 characters long (not counting the end-of-line
 * characters).
 * <p>
 * Each haiku is guaranteed to contain three lines, and
 * each line will contain at least one word. Your job is
 * to determine whether each line has the correct number
 * of syllables (5/7/5). For the purposes of this problem,
 * every contiguous sequence of one or more vowels counts
 * as one syllable, where the vowels are
 * a, e, i, o, u, and y. Every word will contain at least
 * one syllable.
 * <p>
 * (Note that this method of counting syllables does not
 * always agree with English conventions. In the second
 * example below, your program must consider the word
 * 'code' to have two syllables because the 'o' and the
 * 'e' are not consecutive. However, in English the 'e'
 * is silent and so 'code' actually has only one syllable.)
 * <p>
 * Output
 * ------------
 * <p>
 * For each haiku, output a comma separated single line
 * that contains the number of syllables in each haiku,
 * together with the letter Y if it is a haiku, or N if
 * it is not a haiku (see below).
 * <p>
 * <p>
 * Sample Input
 * ------------
 * >happy purple frog/eating bugs in the marshes/get indigestion
 * <p>
 * >computer programs/the bugs try to eat my code/i will not let them
 * <p>
 * Sample Output
 * -------------
 * >5,7,5,Yes
 */
public class HaikuReviewTest {

    private HaikuReview haikuReview;

    @Before
    public void setUp() throws Exception {
        haikuReview = new HaikuReview();
    }

    @Test
    public void givenATest_ThenItWorks() throws Exception {

        assertThat(true).isTrue();
    }

    @Test
    public void testYouCanSplitAHaikuIntoLines() {
        String haiku = "happy purple frog/eating bugs in the marshes/get indigestion";
        String[] splitHaiku = haikuReview.splitHaiku(haiku);
        assertThat(splitHaiku).hasSize(3);
    }

    @Test
    public void testOnlyAllowLowercase() throws Exception {
        String lowercase = "a";
        String uppercase = "A";
        boolean valid = haikuReview.validateHaikuCharacters(lowercase);

        assertThat(valid).isTrue();
        boolean invalid = haikuReview.validateHaikuCharacters(uppercase);
        assertThat(invalid).isFalse();
    }

    @Test
    public void testForwardSlashIsAValidCharacter() throws Exception {
        String forwardSlash = "/";
        boolean invalid = haikuReview.validateHaikuCharacters(forwardSlash);
        assertThat(invalid).isTrue();
    }

    @Test
    public void testSpaceIsAValidCharacter() throws Exception {
        String space = " ";
        boolean invalid = haikuReview.validateHaikuCharacters(space);
        assertThat(invalid).isTrue();
    }

    @Test
    public void testAllow200Characters() throws Exception {
        String haiku = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaatwohundred";
        boolean valid = haikuReview.validateHaikuCharacters(haiku);
        assertThat(valid).isTrue();
    }

    @Test
    public void testDontAllowMoreThan200Characters() throws Exception {
        String haiku = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaatwohundred1";
        boolean valid = haikuReview.validateHaikuCharacters(haiku);
        assertThat(valid).isFalse();
    }

    @Test
    public void testAllowLessThan200Characters() throws Exception {
        String haiku = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaoneninenine";
        boolean valid = haikuReview.validateHaikuCharacters(haiku);
        assertThat(valid).isTrue();
    }

    @Test
    public void testAllowLessThan200CharactersExcludingForwardSlash() throws Exception {
        String haiku = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa " +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaatwohundred/";
        boolean valid = haikuReview.validateHaikuCharacters(haiku);
        assertThat(valid).isTrue();
    }

    @Test
    public void testWordIsOneSyllable() throws Exception {
        String oneSyllable = "ae";
        int number = haikuReview.getNumberOfSyllables(oneSyllable);

        assertThat(number).isEqualTo(1);
    }

    @Test
    public void test() {
        String string = "at";
        int number = haikuReview.getNumberOfSyllables(string);

        assertThat(number).isEqualTo(1);
    }
}
