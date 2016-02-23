import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class HaikuReviewTest {

    @Test
    public void testThatTestsRun() throws Exception {
        assertThat(true).isEqualTo(true);
    }

    @Test
    public void testNumberLinesPasses() {

        assertThat( HaikuReview.hasThreeLines("one line/two lines/three lines") ).isEqualTo(true);
    }

    @Test
    public void testNumberLinesFails() {

        assertThat( HaikuReview.hasThreeLines("one line/two lines") ).isEqualTo(false);
    }


    @Test
    public void testAlmostWordForLinePasses(){

        String text = "one";

        assertThat( HaikuReview.hasWord(text) ).isEqualTo(true);

    }

    @Test
    public void testAlmostWordForLineFails(){
        String text = "";

        assertThat(HaikuReview.hasWord(text) ).isEqualTo(false);

    }

    @Test
    public void testCheckWordInEachLinePasses(){

        String text ="word/word/word word";

        assertThat( HaikuReview.checkWordsInEachLine(text)) .isEqualTo(true);
    }

    @Test
    public void testCheckWordInEachLineFails(){

        String text ="one/ /three";

        assertThat( HaikuReview.checkWordsInEachLine(text)) .isEqualTo(false);
    }

}
