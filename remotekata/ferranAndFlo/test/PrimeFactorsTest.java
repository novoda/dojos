import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorsTest extends TestCase {
    public void testOne() throws Exception {
        assertEquals(list(), PrimeFactors.generate(1));
    }

    private List<Integer> list() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        return list;
    }
}