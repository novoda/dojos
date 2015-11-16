import org.junit.Test;

import static junit.framework.Assert.*;

public class RecentsTest {

    @Test
    public void if_no_items_added_then_recents_is_empty() {
        Recents recents = new Recents();

        assertTrue(recents.isEmpty());
    }

    @Test
    public void an_item_correctly_added() {
        Recents recents = new Recents();
        recents.add("test");
        assertNotNull(recents.get(0));
    }

    @Test
    public void when_adding_one_item_it_is_correctly_added() {
        Recents recents = new Recents();

        String testItem = "test";
        recents.add(testItem);

        assertEquals(testItem, recents.get(0));
        assertFalse(recents.isEmpty());
    }

    @Test
    public void items_are_unique() {
        Recents recents = new Recents();

        String testItem = "test";
        recents.add(testItem);
        recents.add(testItem);

        assertEquals(1, recents.size());
    }

    @Test
    public void adding_2_items_most_recent_added_is_first_and_older_is_second() {
        Recents recents = new Recents();

        String lessRecent = "test";
        recents.add(lessRecent);
        String mostRecent = "foobar";
        recents.add(mostRecent);

        assertEquals(mostRecent, recents.get(0));
        assertEquals(lessRecent, recents.get(1));
    }

    @Test
    public void adding_a_duplicate_makes_it_the_most_recent() {
        Recents recents = new Recents();

        String firstItem = "test";
        recents.add(firstItem);
        String secondItem = "foobar";
        recents.add(secondItem);
        recents.add(firstItem);

        assertEquals(firstItem, recents.get(0));
        assertEquals(secondItem, recents.get(1));
    }

}
