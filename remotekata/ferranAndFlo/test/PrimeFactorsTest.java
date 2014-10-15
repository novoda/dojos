import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrimeFactorsTest extends TestCase {
    public void testOne() throws Exception {
        assertEquals(primesOf1(), PrimeFactors.generate(1));
    }

    public void testPrimeFactorsOf21() throws Exception {
        assertEquals(primesOf21(), PrimeFactors.generate(21));
    }

    public void testPrimeFactorOf3() throws Exception {
        assertEquals(primesOf3(), PrimeFactors.generate(3));
    }

    private List<Integer> primesOf1() {
        return Collections.emptyList();
    }

    private List<Integer> primesOf21() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(7);
        return list;
    }

    private List<Integer> primesOf3() {
        return Collections.emptyList();
    }
}