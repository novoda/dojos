import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DollarChangerTests {

    @Test
    public void answerToLifeTheUniverseAndEverything() {
        int expected = 42;
        int actual = Hiker.answer();

        assertEquals(expected, actual);
    }

    @Test
    public void givenPenniesWhenChangeOfADollarThenOneCombination() {
        int denomination = 1;

        int actual = changeOfADoller(Arrays.asList(denomination));

        int expectedCombinations = 1;
        assertEquals(expectedCombinations, actual);
    }

    @Test
    public void givenNickelsWhenChangeOfADollarThenOneCombination() {
        int denomination = 1;

        int actual = changeOfADoller(Arrays.asList(denomination));

        int expectedCombinations = 1;
        assertEquals(expectedCombinations, actual);
    }

    // dimes, quarters also just have one combo

    @Test
    public void givenPenniesAndNickelsWhenChangeOfADollarThenTwentyOneCombinations() {
        int nickelDenomination = 5;
        int pennieDenomination = 1;

        int actual = changeOfADoller(Arrays.asList(nickelDenomination, pennieDenomination));

        int expectedCombinations = 21;
        assertEquals(expectedCombinations, actual);
    }

    /**
     * @Test public void givenPenniesAndNickelsWhenChangeOfADollarThenXCombinations() {
     * int nickelDenomination = 5;
     * int pennieDenomination = 1;
     * int dimesDenomination = 10;
     * <p/>
     * int actual = changeOfADoller(nickelDenomination, pennieDenomination, dimesDenomination);
     * <p/>
     * int expectedCombinations = 21;
     * assertEquals(expectedCombinations, actual);
     * }
     */
    private int changeOfADoller(List<Integer> denominations) {
        int dollar = 100;
        int numberOfCombinations = 0;
        int sum = 0;

        for (int denom : denominations) {
            while (sum <= dollar) {
                sum += denom;
                if (sum == dollar) {
                    numberOfCombinations++;
                }
            }
        }

        if (denominations.size() == 1) {
            return numberOfCombinations;
        }

        sum = 0;
        int newTarget = dollar;
        while (newTarget > 0) {
            newTarget -= denominations.get(1);
            sum = newTarget;
            while (sum <= dollar) {
                sum += denominations.get(0);
                if (sum == dollar) {
                    numberOfCombinations++;
                }
            }
        }

        return numberOfCombinations;
    }
}
