package com.novoda;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RecentsListTest {

    private RecentsList list;

    @Before
    public void setUp() {
        list = new RecentsList();

    }

    @Test
    public void testRecentListIsInitallyEmpty() {
        assertThat(list.isEmpty()).isTrue();
    }

    @Test
    public void testAddItemToEmptyList() {
        list.put("string");

        assertThat(list.isEmpty()).isFalse();
    }

    @Test
    public void testGetFirstItemInTheList() {
        String item = "string";
        list.put(item);

        assertThat(list.get(0)).isEqualTo(item);
    }

    @Test
    public void testGetLeastRecentlyAddedItem() {
        String firstItem = "first";
        String secondItem  = "second";

        list.put(firstItem);
        list.put(secondItem);

        assertThat(list.get(0)).isEqualTo(secondItem);
    }

    @Test
    public void testAddingThreeItemsKeepsMostRecentylAddedOrder() {
        String firstItem = "first";
        String secondItem  = "second";
        String thirdItem  = "third";

        list.put(firstItem);
        list.put(secondItem);
        list.put(thirdItem);

        assertThat(list.get(0)).isEqualTo(thirdItem);
        assertThat(list.get(1)).isEqualTo(secondItem);
        assertThat(list.get(2)).isEqualTo(firstItem);
    }
}
