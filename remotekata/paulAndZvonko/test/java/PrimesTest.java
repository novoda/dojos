import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrimesTest {

    @Test
    public void testOne() throws Exception {
        assertEquals(list(), Primes.generate(1));
    }

    @Test
    public void testTwo() throws Exception {
        assertEquals(list2(), Primes.generate(2));
    }

    @Test
    public void testThree() throws Exception {
        assertEquals(list3(), Primes.generate(3));
    }

    @Test
    public void testFour() throws Exception {
        assertEquals(list4(), Primes.generate(4));
    }

    private List<Integer> list() {
        return new ArrayList<Integer>();
    }

    private List<Integer> list2() {
        ArrayList<Integer> primeFactors = new ArrayList<Integer>();
        primeFactors.add(2);
        return primeFactors;
    }

    private List<Integer> list3() {
        ArrayList<Integer> primeFactors = new ArrayList<Integer>();
        primeFactors.add(3);
        return primeFactors;
    }

    private List<Integer> list4() {
        ArrayList<Integer> primeFactors = new ArrayList<Integer>();
        primeFactors.add(2);
        primeFactors.add(2);
        return primeFactors;
    }
}
