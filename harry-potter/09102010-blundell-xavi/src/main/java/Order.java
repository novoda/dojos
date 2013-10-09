package silent;

import java.util.Iterator;

public class Order implements Iterable {

    private int numberOfBooks;
    private String[] books;

    public int getTotalBooks() {
        return numberOfBooks;
    }

    public Order select(String... books) {
        this.books = books;
        numberOfBooks = books.length;
        return this;
    }

    public String[] getBooks() {
        return books;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
