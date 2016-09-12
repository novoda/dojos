import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

public class PrimeFactorsTest {

    @Test
    public void OneShouldReturnsCorrectFactors() {
        testFactorise(1, Arrays.asList(1));
    }

    @Test
    public void FourShouldReturnsCorrectFactors() {
        testFactorise(4, Arrays.asList(2, 2));
    }

    @Test
    public void SixShouldReturnsCorrectFactors() {
        testFactorise(6, Arrays.asList(2, 3));
    }

    public void testFactorise(int inputValue, List<Integer> expectedValue)  {
        assertThat(PrimeFactors.factorise(inputValue)).isEqualTo(expectedValue);
    }
}
