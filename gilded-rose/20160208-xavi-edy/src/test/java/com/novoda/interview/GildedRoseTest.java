package com.novoda.interview;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    public List<Item> createListWithOneItem(String name, int sellIn, int quality) {
        List<Item> items = new ArrayList<Item>();
        items.add(new Item(name, sellIn, quality));
        return items;
    }

    @Test
    public void testSimpleItem() {
        List<Item> items = createListWithOneItem("whatever", 11, 20);
        GildedRose.updateQuality(items);
        Item item = items.get(0);
        assertEquals(10, item.getSellIn());
        assertEquals(19, item.getQuality());
    }

    @Test
    public void testQualityNeverBelowZero() {
        List<Item> items = createListWithOneItem("whatever", 11, 1);
        GildedRose.updateQuality(items);
        GildedRose.updateQuality(items);
        Item item = items.get(0);
        assertEquals(0, item.getQuality());
    }

    @Test
    public void testQualityDegradesTwiceAsFastAfterSellByDate() {
        List<Item> items = createListWithOneItem("whatever", 0, 10);
        GildedRose.updateQuality(items);
        Item item = items.get(0);
        assertEquals(8, item.getQuality());
    }

    @Test
    public void testAgedBrieQualityIncreases() {
        List<Item> items = createListWithOneItem("Aged Brie", 11, 20);
        GildedRose.updateQuality(items);
        Item item = items.get(0);
        assertEquals(21, item.quality);
    }

    @Test
    public void testAgedBrieQualityBelow50() {
        List<Item> items = createListWithOneItem("Aged Brie", 11, 49);
        GildedRose.updateQuality(items);
        GildedRose.updateQuality(items);
        Item item = items.get(0);
        assertEquals(50, item.quality);
    }

    @Test
    public void testAgedBrieQualityIncreasesTwiceAsFastAfterSellByDate() {
        List<Item> items = createListWithOneItem("Aged Brie", 0, 20);
        GildedRose.updateQuality(items);
        Item item = items.get(0);
        assertEquals(22, item.quality);
    }

    @Test
    public void testSulfurasRemainsConstant() {
        List<Item> items = createListWithOneItem("Sulfuras, Hand of Ragnaros", 10, 30);
        GildedRose.updateQuality(items);
        Item item = items.get(0);
        assertEquals(30, item.quality);
        assertEquals(10, item.getSellIn());
    }

    @Test
    public void testBackstagePassesQualityBelow50() {
        List<Item> items = createListWithOneItem("Backstage passes to a TAFKAL80ETC concert", 12, 50);
        GildedRose.updateQuality(items);
        Item item = items.get(0);
        assertEquals(50, item.getQuality());
    }

    @Test
    public void testBackstagePassesQualityAfterConcertDropTo0() {
        List<Item> items = createListWithOneItem("Backstage passes to a TAFKAL80ETC concert", 0, 50);
        GildedRose.updateQuality(items);
        Item item = items.get(0);
        assertEquals(0, item.getQuality());
    }

    @Test
    public void testBackstagePassesQualityIncreasesBy3Under5Days() {
        List<Item> items = createListWithOneItem("Backstage passes to a TAFKAL80ETC concert", 4, 10);
        GildedRose.updateQuality(items);
        Item item = items.get(0);
        assertEquals(13, item.getQuality());
    }

    @Test
    public void testBackstagePassesQualityIncreasesBy2Under10Days() {
        List<Item> items = createListWithOneItem("Backstage passes to a TAFKAL80ETC concert", 6, 10);
        GildedRose.updateQuality(items);
        Item item = items.get(0);
        assertEquals(12, item.getQuality());
    }

    @Test
    public void testBackstagePassesQualityIncreasesBy1Above10Days() {
        List<Item> items = createListWithOneItem("Backstage passes to a TAFKAL80ETC concert", 21, 10);
        GildedRose.updateQuality(items);
        Item item = items.get(0);
        assertEquals(11, item.getQuality());
    }

}
