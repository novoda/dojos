import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HikerTest {

    @Test
    public void answerToLifeTheUniverseAndEverything() {
        int expected = 42;
        int actual = Hiker.answer();

        assertEquals(expected, actual);
    }
}
