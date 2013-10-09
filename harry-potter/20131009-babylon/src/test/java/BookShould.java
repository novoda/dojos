import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
public class BookShould {

    @Test
    public void have_a_price() {
        Book first = Book.FIRST;
        assertThat(first.price()).isEqualTo(8);
    }

    @Test
    public void have_a_title() {
        Book first = Book.FIRST;
        assertThat(first.name()).isEqualTo("FIRST");
    }

    @Test
    public void be_unique() {
        assertThat(Book.FIRST).isEqualTo(Book.FIRST);
    }


}
