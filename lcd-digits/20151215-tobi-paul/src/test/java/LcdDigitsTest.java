import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LcdDigitsTest {

    private LcdDigits.IScreen screen = mock(LcdDigits.IScreen.class);
    final LcdDigits tested = new LcdDigits(screen);

    @Test
    public void testThatWorks() {
        assertThat(true).isTrue();
    }

    @Test
    public void prints_first_line_on_screen() throws Exception {
        //given
        int number = 0;

        // when
        tested.displayNumber(number);

        //then
        verify(screen).displayFirstLine(" _ ");
    }

    @Test
    public void should_display_second_line_on_screen() throws Exception {
        //given
        int number = 0;

        // when
        tested.displayNumber(number);

        //
        verify(screen).displaySecondLine("| |");
    }

    @Test
    public void should_display_third_line_on_screen() throws Exception {
        //given
        int number = 0;

        // when
        tested.displayNumber(number);

        //
        verify(screen).displayThirdLine("|_|");
    }
}
