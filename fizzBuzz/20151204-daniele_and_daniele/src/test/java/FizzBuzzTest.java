import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.fest.assertions.api.Assertions.assertThat;

@RunWith(Enclosed.class)
public class FizzBuzzTest {

    @RunWith(Parameterized.class)
    public static class MultiplesOfThree {

        private final int number;
        private final String expected;

        @Parameterized.Parameters
        public static Collection data() {
            return Arrays.asList(new Object[][]{
                    {1, "1"},
                    {2, "2"},
                    {3, "Fizz"},
                    {4, "4"},
                    {5, "Buzz"},
                    {6, "Fizz"},
                    {7, "7"},
                    {10, "Buzz"},
                    {12, "Fizz"},
                    {15, "FizzBuzz"},
                    {16, "16"},
            });
        }

        public MultiplesOfThree(int number, String expected) {
            this.number = number;
            this.expected = expected;
        }

        private FizzBuzz fizzBuzz;

        @Before
        public void setUp() throws Exception {
            fizzBuzz = new FizzBuzz();
        }

        @Test
        public void fizzBuzz() throws Exception {
            assertFizzBuzz(number, expected);
        }

        private void assertFizzBuzz(int number, String expected) {
            String result;
            result = fizzBuzz.convert(number);
            assertThat(result).isEqualTo(expected);
        }
    }

}
