import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by acsia on 09/10/13.
 */
public class BasketShould {

    @Test
    public void be_empty_at_first() {
        Basket basket = Basket.empty();
        assertThat(basket.isEmpty()).isTrue();
    }

    @Test
    public void be_able_to_add_a_book() {
        Basket basket = Basket.empty();

        basket.add(Book.FIFTH);

        assertThat(basket.size()).isEqualTo(1);
    }

    @Test
    public void be_able_to_add_two_of_the_same_books() {
        Basket basket = Basket.empty();

        basket.add(Book.FIFTH);
        basket.add(Book.FIFTH);

        assertThat(basket.size()).isEqualTo(2);
    }

    @Test
    public void be_able_to_add_two_different_books() {
        Basket basket = Basket.empty();

        basket.add(Book.FIRST);
        basket.add(Book.FIFTH);

        assertThat(basket.size()).isEqualTo(2);
    }

    @Test
    public void basketTotalForOneBook_isEightEuros() {
        Basket basket = Basket.empty();

        basket.add(Book.FIRST);

        assertThat(basket.total()).isEqualTo(Book.defaultPrice());
    }

    @Test
    public void basketTotalForTwoDifferentBooks_is5PercentDiscounted() {
        Basket basket = Basket.empty();

        basket.add(Book.FIRST);
        basket.add(Book.SECOND);

        assertThat(basket.total()).isEqualTo(15.2D);
    }

}
