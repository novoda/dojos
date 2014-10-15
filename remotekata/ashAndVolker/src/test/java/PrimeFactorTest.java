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
        Assert.assertEquals(just(2), PrimeFactors.generate(2));
    }


    private List<Integer> just(int i) {
        return Collections.singletonList(Integer.valueOf(i));
    }

    private List<Integer> list() {
                        return Collections.emptyList();
    }
}
