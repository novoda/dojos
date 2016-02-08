package com.novoda.interview;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";

    /**
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("OMGHAI!");

        List<Item> items = new ArrayList<Item>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item(AGED_BRIE, 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item(SULFURAS_HAND_OF_RAGNAROS, 0, 80));
        items.add(new Item(BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT, 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));

        updateQuality(items);
    }

    public static void updateQuality(List<Item> items) {
        for (int i = 0, size = items.size(); i < size; i++) {
            Item item = items.get(i);
            if (!item.getName().equals(AGED_BRIE) && !item.getName().equals(BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT)) {
                if (item.getQuality() > 0) {
                    if (!item.getName().equals(SULFURAS_HAND_OF_RAGNAROS)) {
                        item.setQuality(item.getQuality() - 1);
                    }
                }
            } else {
                if (item.getQuality() < 50) {
                    item.setQuality(item.getQuality() + 1);

                    if (item.getName().equals(BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT)) {
                        if (item.getSellIn() < 11) {
                            if (item.getQuality() < 50) {
                                item.setQuality(item.getQuality() + 1);
                            }
                        }

                        if (item.getSellIn() < 6) {
                            if (item.getQuality() < 50) {
                                item.setQuality(item.getQuality() + 1);
                            }
                        }
                    }
                }
            }

            if (!item.getName().equals(SULFURAS_HAND_OF_RAGNAROS)) {
                item.setSellIn(item.getSellIn() - 1);
            }

            if (item.getSellIn() < 0) {
                if (!item.getName().equals(AGED_BRIE)) {
                    if (!item.getName().equals(BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT)) {
                        if (item.getQuality() > 0) {
                            if (!item.getName().equals(SULFURAS_HAND_OF_RAGNAROS)) {
                                item.setQuality(item.getQuality() - 1);
                            }
                        }
                    } else {
                        item.setQuality(item.getQuality() - item.getQuality());
                    }
                } else {
                    if (item.getQuality() < 50) {
                        item.setQuality(item.getQuality() + 1);
                    }
                }
            }
        }
    }

}
