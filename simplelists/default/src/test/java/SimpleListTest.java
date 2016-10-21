import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

/**
 * Simple List Kata: http://codekata.com/kata/kata21-simple-lists/
 */
public class SimpleListTest {

    private SimpleList list;

    @Before
    public void createList() {
        list = new MySimpleList();
    }

    @Test
    public void shouldNotFindWhenEmpty() {
        assertEquals(null, list.find("fred"));
    }

    @Test
    public void shouldHandleAddition() throws Exception {
        list.add("fred");

        assertEquals("fred", list.find("fred"));

        list.add("wilma");

        assertEquals("fred", list.find("fred"));
        assertEquals("wilma", list.find("wilma"));
        String[] expecteds = arrayOf("fred", "wilma");
        assertArrayEquals(expecteds, list.values());
    }

    @Test
    public void shouldHandleDeletion() throws Exception {
        list.add("fred");
        list.add("wilma");
        list.add("betty");
        list.add("barney");

        assertArrayEquals(arrayOf("fred", "wilma", "betty", "barney"), list.values());

        list.delete(list.find("wilma"));

        assertArrayEquals(arrayOf("fred", "betty", "barney"), list.values());

        list.delete(list.find("barney"));

        assertArrayEquals(arrayOf("fred", "betty"), list.values());

        list.delete(list.find("fred"));

        assertArrayEquals(arrayOf("betty"), list.values());

        list.delete(list.find("betty"));

        assertArrayEquals(arrayOf(), list.values());
    }

    private static String[] arrayOf(String... s) {
        return s;
    }

}
