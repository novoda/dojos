import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LcdDigitsTest {

    @Test
    public void testThatWorks() {
        assertThat(true).isTrue();
    }

    @Test
    public void testThatInputOfOne_GivesOutputOfOne() {

        LcdDigits digits = new LcdDigits(1);

        // Assert
        assertThat(digits.line(0)).isEqualTo("   ");
        assertThat(digits.line(1)).isEqualTo("  |");
        assertThat(digits.line(2)).isEqualTo("  |");
    }

    @Test
    public void testThatInputOfTwo_GivesOutputOfTwo() {

        LcdDigits digits = new LcdDigits(2);

        // Assert
        assertThat(digits.line(0)).isEqualTo(" _ ");
        assertThat(digits.line(1)).isEqualTo(" _|");
        assertThat(digits.line(2)).isEqualTo("|_ ");
    }

    @Test
    public void testThatInputOfZero_GivesOutputOfZero() {

        LcdDigits digits = new LcdDigits(0);

        // Assert
        assertThat(digits.line(0)).isEqualTo(" _ ");
        assertThat(digits.line(1)).isEqualTo("| |");
        assertThat(digits.line(2)).isEqualTo("|_|");
    }

    @Test
    public void testThatInputOfHundredTwenty_GivesOutputOfHundredTwenty() {

        LcdDigits digits = new LcdDigits(120);

        // Assert
        assertThat(digits.line(0)).isEqualTo("     _   _ ");
        assertThat(digits.line(1)).isEqualTo("  |  _| | |");
        assertThat(digits.line(2)).isEqualTo("  | |_  |_|");
    }

}
