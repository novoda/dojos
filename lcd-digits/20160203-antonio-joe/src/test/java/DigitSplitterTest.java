import org.junit.Test;

import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

public class DigitSplitterTest {

    @Test
    public void shouldReturn9_WhenInputIs9() throws Exception {
        DigitSplitter splitter = new DigitSplitter();

        List<Integer> split = splitter.split(9);

        // Assert
        assertThat(split).containsExactly(9);
    }

    @Test
    public void shouldReturn1and2and0_WhenInputIs120() throws Exception {
        DigitSplitter splitter = new DigitSplitter();

        List<Integer> split = splitter.split(120);

        // Assert
        assertThat(split).containsExactly(1, 2, 0);
    }

}