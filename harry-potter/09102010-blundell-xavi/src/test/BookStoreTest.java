package silent;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class BookStoreTest {

    @Test
    public void buyingOneBook_shouldCostEightEuros() {
        BookStore store = new BookStore();

        Order order = store.startOrder();
        order.select("BookOne");
        int total = store.purchase(order);

        assertEquals(8, total);
    }

    @Test
    public void buyingTwoSameBooks_shouldCostSixteenEuros() {
        BookStore store = new BookStore();

        Order order = store.startOrder();
        order.select("BookOne", "BookOne");
        int total = store.purchase(order);

        assertEquals(16, total);
    }

    @Test
    public void buyingTwoDifferentBooks_shouldApply5percentDiscount() {
        BookStore store = new BookStore();

        Order order = store.startOrder();
        order.select("BookOne", "BookTwo");

        int total = store.purchase(order);

        assertEquals(15.2D, total);
    }

}
