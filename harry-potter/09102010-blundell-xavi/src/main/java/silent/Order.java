package silent;

import java.util.HashMap;
import java.util.Map;

public class Order {

    private Map<String, Integer> books = new HashMap<String, Integer>();

    public int getTotalBooks() {
        int accumulated = 0;
        for (String book: books.keySet()) {
            accumulated += books.get(book);
        }

        return accumulated;
    }

    public Order select(String... newBooks) {
        for (String book : newBooks) {
            int nbBook = books.containsKey(book) ? books.get(book) : 0;
            nbBook += 1;
            books.put(book, nbBook);
        }
        return this;
    }

    public Map<String, Integer> getBooks() {
        return books;
    }

}
