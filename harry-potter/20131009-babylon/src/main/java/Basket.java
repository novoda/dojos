import java.util.HashMap;
import java.util.Map;

/**
 * Created by acsia on 09/10/13.  << sucks
 */
public class Basket {

    private Map<Book, Amount> nbBooks;

    Basket() {
        this.nbBooks = new HashMap<Book, Amount>();
    }

    public boolean isEmpty() {
        return nbBooks.isEmpty();
    }

    public static Basket empty() {
        return new Basket();
    }

    public void add(Book book) {
        Amount amount = nbBooks.get(book);
        if (amount == null) {
            amount = new Amount(1);
        } else {
            amount.total++;
        }

        nbBooks.put(book, amount);
    }

    public int size() {
        int booksNr = 0;
        for (Amount amount : nbBooks.values()) {
            booksNr += amount.total;
        }

        return booksNr;
    }

    public double total() {
        return new PriceCalculator(nbBooks).total();
    }

    static class Amount {
        public int total;

        Amount(int total) {
            this.total = total;
        }
    }
}
