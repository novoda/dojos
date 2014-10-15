import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorsTest extends TestCase {
    public void testOne() throws Exception {
        assertEquals(list(), PrimeFactors.generate(1));
    }

    public void testAnotherOne() throws Exception {
        assertEquals(primesOf21(), PrimeFactors.generate(21));
    }

    private List<Integer> list() {
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