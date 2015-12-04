import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class FizzBuzzTest {

    @Test
    public void whenWeRunItWithOneTheOutputIsTheNumber() {
        FizzBuzz fizzBuzz = new FizzBuzz();

        assertThat(fizzBuzz.output(1)).isEqualTo("1");
    }

    @Test
    public void whenWeRunItWithTwoTheOutputIsTheNumber() {
        FizzBuzz fizzBuzz = new FizzBuzz();

        assertThat(fizzBuzz.output(2)).isEqualTo("2");
    }
}
