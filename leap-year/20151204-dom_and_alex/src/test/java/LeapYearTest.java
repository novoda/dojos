import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class LeapYearTest {

    @Test
    public void testThat2001IsNotALeapYear() {
        assertThat(new LeapYear().isALeapYear(2001)).isFalse();
    }

    @Test
    public void testThat1996IsALeapYear() {
        assertThat(new LeapYear().isALeapYear(1996)).isTrue();
    }
}
