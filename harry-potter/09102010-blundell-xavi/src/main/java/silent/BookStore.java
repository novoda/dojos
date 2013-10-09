package silent;

public class BookStore {

    public Order startOrder() {
        return new Order();
    }

    public double purchase(Order order) {
        return 8 * order.getTotalBooks() + applyDiscount(order);
    }

    private double applyDiscount(Order order) {
        DiscountCalculator discountCalculator = new DiscountCalculator(order);
        return discountCalculator.calculate();
    }
}
