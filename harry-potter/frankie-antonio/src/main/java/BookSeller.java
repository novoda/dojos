import java.util.HashMap;

public class BookSeller {

    public static final double DEFAULT_PRICE = 8;

    public double price(Book... book) {
        HashMap<Book, Integer> sell = new HashMap<Book, Integer>();




        return DEFAULT_PRICE * book.length;
    }
}
