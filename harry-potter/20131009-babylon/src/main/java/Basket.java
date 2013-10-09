import java.util.HashMap;
import java.util.Map;

/**
 * Created by acsia on 09/10/13.
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

    public void add(Book fifth) {
        Amount amount = nb
        nbBooks.put()
    }

    public int size() {
        return 0;
    }

    private static class Amount {
        public int amount;
    }
}
