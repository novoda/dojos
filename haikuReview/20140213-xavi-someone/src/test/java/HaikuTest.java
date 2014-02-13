import org.junit.Test;

import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

public class HaikuTest {

    private static final String INPUT_ONE = "happy purple frog/eating bugs in the marshes/get indigestion";
    private static final String INPUT_TWO = "computer programs/the bugs try to eat my code/i will not let them";

    @Test
    public void testThatGivenStringWith3Lines_returnsValidForLineCount() {
        String validFormatHaiku = "input/three/lines";

        Haiku haiku = new Haiku(validFormatHaiku);

        assertThat(haiku.isValidLineCount()).isTrue();
    }

    @Test
    public void test_that_it_breaks_up_into_3_lines() {
        Haiku haiku = new Haiku(INPUT_ONE);
        List<Haiku.Line> lines = haiku.asLines();
        assertThat(lines.size()).isEqualTo(3);
    }

    @Test
    public void test_that_a_Line_should_have_at_least_one_word() {
        Haiku.Line line = new Haiku.Line("hello");
        assertThat(line).isNotNull();
    }

    @Test(expected = Haiku.Line.LineException.class)
    public void test_that_a_line_should_fail_if_empty() {
        Haiku.Line line = new Haiku.Line("");
    }

    @Test
    public void test_that_a_line_should_split_into_words() {
        Haiku.Line line = new Haiku.Line("hello world");

        List<Haiku.Word> words = line.getWords();

        assertThat(words.size()).isEqualTo(2);

        assertThat(words).contains(Haiku.Word.from("hello"), Haiku.Word.from("world"));
    }

}
