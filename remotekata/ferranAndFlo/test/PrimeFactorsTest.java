import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorsTest extends TestCase {
    public void testOne() throws Exception {
        assertEquals(primesOf1(), PrimeFactors.generate(1));
    }

    public void testPrimeFactorsOf21() throws Exception {
        assertEquals(primesOf21(), PrimeFactors.generate(21));
    }

    private List<Integer> primesOf1() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        return list;
    }

    private List<Integer> primesOf21() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(7);
        return list;
    }
}