import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.fest.assertions.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class LeapYearTest {

    private final int year;
    private final boolean isLeapYear;
    private LeapYear leapYear;

    @Parameterized.Parameters
    public static Collection years() {
        return Arrays.asList(new Object[][]{
                {1996, true},
                {1900, false},
                {2001, false},
                {2008, true},
                {2000, true},
        });
    }

    public LeapYearTest(int year, boolean isLeapYear) {
        this.year = year;
        this.isLeapYear = isLeapYear;
    }

    @Before
    public void setUp() throws Exception {
        leapYear = new LeapYear();
    }

    @Test
    public void testIsLeap() {
        assertThat(leapYear.isLeap(year)).isEqualTo(isLeapYear);
    }
}
