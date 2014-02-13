import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class HaikuHelperTest {

    @Test
    public void testThatGivenStringWith3Lines_returnsValidForLineCount() {
        String validFormatHaiku = "input/three/lines";

        HaikuHelper helper = new HaikuHelper(validFormatHaiku);

        assertThat(helper.isValidLineCount()).isTrue();
    }
    
}
