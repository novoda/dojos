package silent;

import java.util.Map;

public class DiscountCalculator {

    private final Map<String, Integer> books;
    private final Order order;

    public DiscountCalculator(Order order) {
        this.order = order;
        books = order.getBooks();
    }

    public double calculate() {
        if (order.getTotalBooks() == 2 && areAllBooksDifferent()) {
            return - 0.8;
        }
        return 0;
    }

    private boolean areAllBooksDifferent() {
        return books.size() == order.getTotalBooks();
    }
}
