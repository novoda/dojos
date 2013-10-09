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
        assertThat(basket.size()).isEqualTo(0);
        basket.add(Book.FIFTH);
        assertThat(basket.size()).isEqualTo(1);
    }

}
