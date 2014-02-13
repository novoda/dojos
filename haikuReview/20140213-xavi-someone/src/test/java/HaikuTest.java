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
        List<String> lines = haiku.asLines();
        assertThat(lines.size()).isEqualTo(3);
    }

}
