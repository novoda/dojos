package silent;

public class BookStore {

    public Order startOrder() {
        return new Order();
    }

    public int purchase(Order order) {
        return 8 * order.getTotalBooks() + applyDiscount(order);
    }

    private int applyDiscount(Order order) {
        DiscountCalculator discountCalculator = new DiscountCalculator(order);
        return discountCalculator.calculate();
    }
}
