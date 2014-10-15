import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PrimesTest {

    @Test
    public void testName() throws Exception {
        assertTrue(Primes.someMethod());
    }

    @Test
    public void testOne() throws Exception {
        assertEquals(list(), Primes.generate(1));

    }

    private List<Integer> list() {
        return new ArrayList<Integer>();
    }
}
