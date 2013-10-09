import java.util.HashMap;
import java.util.Map;

public class BookSeller {

    public static final double DEFAULT_PRICE = 8;

    public double price(Book... books) {
        HashMap<Book, Integer> sell = new HashMap<Book, Integer>();
        populate(sell, books);

        int total = 0;
        for (Map.Entry<Book, Integer> entry : sell.entrySet()) {
            total += (entry.getValue() - 1) * DEFAULT_PRICE;
        }

        return total + sell.size() * DEFAULT_PRICE * getDiscountForNumberOfDifferentBooksTypes(sell.size());
    }

    private void populate(HashMap<Book, Integer> sell, Book[] books) {
        for (Book b : books) {
            int previous = 0;
            if (sell.containsKey(b)) {
                previous = sell.get(b);
            }
            sell.put(b, previous + 1);
        }
    }

    private double getDiscountForNumberOfDifferentBooksTypes(int bookTypes) {
        return 1-((bookTypes - 1) * 0.05);
    }

}
