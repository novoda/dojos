package com.novoda.rul;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Develop a recently-used-list class to hold strings
 uniquely in Last-In-First-Out order.

 o) A recently-used-list is initially empty.

 o) The most recently added item is first, the least
 recently added item is last.

 o) Items can be looked up by index, which counts from zero.

 o) Items in the list are unique, so duplicate insertions
 are moved rather than added.

 o) Null insertions (empty strings) are not allowed.

 o) A bounded capacity can be specified, so there is an upper
 limit to the number of items contained, with the least
 recently added items dropped on overflow.
 */
public class RecentlyUsedListTest {

    private RecentlyUsedList list;

    @Before
    public void setUp() throws Exception {
        list = new RecentlyUsedList(new ArrayList<>());
    }

    @Test
    public void shouldRunUnitTests() {
        assertTrue(true);
    }

    @Test
    public void aNewList_isEmpty() throws Exception {
        assertEquals(0, list.size());
    }

    @Test
    public void listWithOneItem_ReturnsSize1() throws Exception {
        list.add("item");

        assertEquals(1, list.size());
    }

    @Test
    public void itemsCanBeLookedUpByIndex() {
        list.add("item");

        assertEquals("item", list.get(0));
    }

    @Test
    public void mostRecentlyAdded_isIndexedFirst() throws Exception {
        list.add("old");
        list.add("more recent");

        assertEquals("more recent", list.get(0));
    }

    @Test
    public void duplicateInsertions_areMovedToFirstIndex() throws Exception {
        list.add("duplicate");
        list.add("not duplicate");

        list.add("duplicate");

        assertEquals("duplicate", list.get(0));
        assertEquals("not duplicate", list.get(1));
        assertEquals(2, list.size());
    }

//    public void emptyStrings_areNotAllowed()
}
