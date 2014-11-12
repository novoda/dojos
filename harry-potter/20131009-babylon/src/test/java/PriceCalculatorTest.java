import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.Ignore;

import static org.fest.assertions.Assertions.assertThat;

public class PriceCalculatorTest {

    @Test
    public void priceForOneBook_isEightEuros() {
        Map<Book, Basket.Amount> books = new HashMap<Book, Basket.Amount>();
        books.put(Book.FIRST, new Basket.Amount(1));

        PriceCalculator calculator = new PriceCalculator(books);

        assertThat(calculator.total()).isEqualTo(Book.defaultPrice());
    }

    @Test
    public void priceForTwoDifferentBooks_is5PercentDiscounted() {
        Map<Book, Basket.Amount> books = new HashMap<Book, Basket.Amount>();
        books.put(Book.FIRST, new Basket.Amount(1));
        books.put(Book.SECOND, new Basket.Amount(1));

        PriceCalculator calculator = new PriceCalculator(books);

        assertThat(calculator.total()).isEqualTo(15.2D);
    }

    @Test
    public void priceForTwoSameBooks_isNotDiscounted() {
        Map<Book, Basket.Amount> books = new HashMap<Book, Basket.Amount>();
        books.put(Book.FIRST, new Basket.Amount(2));

        PriceCalculator calculator = new PriceCalculator(books);

        assertThat(calculator.total()).isEqualTo(16D);
    }

	@Ignore
    @Test
    public void priceForThreeDifferentBooks_is10PercentDiscounted() {
        Map<Book, Basket.Amount> books = new HashMap<Book, Basket.Amount>();
        books.put(Book.FIRST, new Basket.Amount(1));
        books.put(Book.SECOND, new Basket.Amount(1));
        books.put(Book.THIRD, new Basket.Amount(1));

        PriceCalculator calculator = new PriceCalculator(books);

        assertThat(calculator.total()).isEqualTo(24.0D - 2.4D);
    }

}
