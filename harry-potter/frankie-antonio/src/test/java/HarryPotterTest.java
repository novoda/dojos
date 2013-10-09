import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HarryPotterTest {

    private BookSeller bookSeller = new BookSeller();

    @org.junit.Test
    public void normalBookCost8Eur() throws Exception {
        assertEquals(bookSeller.price(Book.PRISONER_OF_AZKABAN), BookSeller.DEFAULT_PRICE, 0);
    }

    @Test
    public void discountIsAppliedOnlyForDifferentTitles() throws Exception {
        double expectedTotal = 2 * BookSeller.DEFAULT_PRICE;

        assertEquals(bookSeller.price(Book.PRISONER_OF_AZKABAN, Book.PRISONER_OF_AZKABAN), expectedTotal, 0);
    }

    @Test
    public void discount5IfBuyTwoDifferentTitles() throws Exception {
        double expectedTotal = .95 * 2 * BookSeller.DEFAULT_PRICE;

        assertEquals(bookSeller.price(Book.PRISONER_OF_AZKABAN, Book.PHOENIX_ORDER), expectedTotal, 0);
    }
}
