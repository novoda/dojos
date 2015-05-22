import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class HikerTest {

    @Test
    public void givenIHaveADollerWhenIChangeThenThereAre100Pennies() {
       Combination expected = new Combination(0,0,0,1);
       System.out.println(expected.getHashCodeString());

       Set<Combination> combinations = Hiker.calculate(1);
       System.out.println(combinations.iterator().next().getHashCodeString());

       assertTrue(combinations.contains(expected));
    }

    @Test
    public void givenIHave15CentsWhenIChangeThenThereAre15Combinations() {
       int expected = 1;

       Set<Combination> combinations = Hiker.calculate(1);
       int actual = combinations.size();

       assertEquals(expected, actual);
    }
}