package silent;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BookStoreTest {

    private BookStore store = new BookStore();

    @Test
    public void buyingOneBook_shouldCostEightEuros() {
        Order order = store.startOrder();
        order.select("BookOne");
        double total = store.purchase(order);

        assertEquals(8, total, 0);
    }

    @Test
    public void buyingTwoSameBooks_shouldCostSixteenEuros() {
        Order order = store.startOrder();
        order.select("BookOne", "BookOne");
        double total = store.purchase(order);

        assertEquals(16, total, 0);
    }

    @Test
    public void buyingTwoDifferentBooks_shouldApply5percentDiscount() {
        Order order = store.startOrder();
        order.select("BookOne", "BookTwo");

        assertTrue(order.getBooks().containsKey("BookTwo"));
        assertEquals(order.getTotalBooks(), 2);

        double total = store.purchase(order);

        assertEquals(15.2D, total, 0);
    }

    @Test
    public void buyingThreeDifferentBooks_shouldApply10percentDiscount() {
        Order order = store.startOrder();
        order.select("BookOne", "BookTwo", "BookThree");

        double total = store.purchase(order);

        assertEquals(21.6D, total, 0);
    }

}
