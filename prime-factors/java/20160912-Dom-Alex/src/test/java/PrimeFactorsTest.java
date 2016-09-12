import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class PrimeFactorsTest {

    @Test
    public void testThat2Returns2() {
        PrimeFactors factors = new PrimeFactors();
        List<Integer> result = factors.getFactorsOf(2);
        assertThat(result).isEqualTo(Arrays.asList(2));
    }

    @Test
    public void testThat3Returns3() {
        PrimeFactors factors = new PrimeFactors();
        List<Integer> result = factors.getFactorsOf(3);
        assertThat(result).isEqualTo(Arrays.asList(3));
    }

    @Test
    public void testThat4Returns2And2() {
        PrimeFactors factors = new PrimeFactors();
        List<Integer> result = factors.getFactorsOf(4);
        assertThat(result).isEqualTo(Arrays.asList(2,2));
    }

    @Test
    public void testThat6Returns2And3() {
        PrimeFactors factors = new PrimeFactors();
        List<Integer> result = factors.getFactorsOf(6);
        assertThat(result).isEqualTo(Arrays.asList(2, 3));
    }

    @Test
    public void testThat9Returns3And3() {
        PrimeFactors factors = new PrimeFactors();
        List<Integer> result = factors.getFactorsOf(9);
        assertThat(result).isEqualTo(Arrays.asList(3, 3));
    }

    @Test
    public void testThat12Returns2And2And3() {
        PrimeFactors factors = new PrimeFactors();
        List<Integer> result = factors.getFactorsOf(12);
        assertThat(result).isEqualTo(Arrays.asList(2, 2, 3));
    }

    @Test
    public void testThat15Returns3And5() {
        PrimeFactors factors = new PrimeFactors();
        List<Integer> result = factors.getFactorsOf(15);
        assertThat(result).isEqualTo(Arrays.asList(3, 5));
    }

}
