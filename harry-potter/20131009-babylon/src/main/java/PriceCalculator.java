import java.util.Map;

public class PriceCalculator {

    private final Map<Book, Basket.Amount> basket;

    public PriceCalculator(Map<Book, Basket.Amount> bookMap) {
        this.basket = bookMap;
    }

    public double total() {
        double tot = 0;

        for (Basket.Amount amount : basket.values()) {
            if (amount.total > 1) {
                tot += Book.defaultPrice() * amount.total;
            } else if (basket.size() != 1) {
                tot += .95 * amount.total * Book.defaultPrice();
            } else if (basket.size() != 1) {
                tot += .95 * amount.total * Book.defaultPrice();
            } else {
                tot = Book.defaultPrice();
            }
        }

        return tot;
    }
}
