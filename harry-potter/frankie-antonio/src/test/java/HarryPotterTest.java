import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.assertEquals;

public class HarryPotterTest {

    private BookSeller bookSeller = new BookSeller();

    @org.junit.Test
    public void normalBookCost8Eur() throws Exception {
        assertEquals(BookSeller.DEFAULT_PRICE, bookSeller.price(Book.PRISONER_OF_AZKABAN), 0);
    }

    @Test
    public void discountIsAppliedOnlyForDifferentTitles() throws Exception {
        double expectedTotal = 2 * BookSeller.DEFAULT_PRICE;

        assertEquals(expectedTotal, bookSeller.price(Book.PRISONER_OF_AZKABAN, Book.PRISONER_OF_AZKABAN), 0);
    }

    @Test
    public void discount5IfBuyTwoDifferentTitles() throws Exception {
        double expectedTotal = .95 * 2 * BookSeller.DEFAULT_PRICE;

        assertEquals(expectedTotal, bookSeller.price(Book.PRISONER_OF_AZKABAN, Book.PHOENIX_ORDER), 0);
    }

    @Test
    public void discount10IfBuyThreeDifferentTitles() {
        double expectedTotal = .90 * 3 * BookSeller.DEFAULT_PRICE;

        assertEquals(expectedTotal, bookSeller.price(Book.PRISONER_OF_AZKABAN, Book.PHOENIX_ORDER, Book.THIRD), 0);
    }

    @Test
    public void discount5IfBuyTwoSameAndOneDifferentTitles() {
        double expectedTotal = .95 * 2 * BookSeller.DEFAULT_PRICE + BookSeller.DEFAULT_PRICE;

        assertEquals(expectedTotal, bookSeller.price(Book.PRISONER_OF_AZKABAN, Book.PRISONER_OF_AZKABAN, Book.PHOENIX_ORDER), 0);
    }

    @Test
    public void discount10IfBuyTwoSameAndTwoDifferentTitles() {
        double expectedTotal = .90 * 3 * BookSeller.DEFAULT_PRICE + BookSeller.DEFAULT_PRICE;

        assertEquals(expectedTotal, bookSeller.price(Book.PRISONER_OF_AZKABAN, Book.PRISONER_OF_AZKABAN, Book.PHOENIX_ORDER, Book.THIRD), 0);
    }

    @Ignore
    @Test
    public void discount10And5IfBuyTwoSetsOfDifferentTitlesOf2and3() {
        double expectedTotal = .90 * 3 * BookSeller.DEFAULT_PRICE + .95 * 2 * BookSeller.DEFAULT_PRICE;

        assertEquals(expectedTotal, bookSeller.price(Book.PRISONER_OF_AZKABAN, Book.PRISONER_OF_AZKABAN, Book.PHOENIX_ORDER, Book.PHOENIX_ORDER, Book.THIRD), 0);
    }

}
