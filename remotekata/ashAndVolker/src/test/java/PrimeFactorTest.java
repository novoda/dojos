import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import prime.PrimeFactors;

public class PrimeFactorTest {

    @Test
    public void testOne() throws Exception {
        Assert.assertEquals(list(), PrimeFactors.generate(1));
    }

    @Test
    public void testTwo() {
        Assert.assertTrue(PrimeFactors.generate(1).size()>=1);
    }
    private List<Integer> list() {
                        return Collections.emptyList();
    }
}
