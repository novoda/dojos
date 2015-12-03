import java.util.ArrayList;
import java.util.List;

public class GildedRose {

    private final List<Item> items;

    public static void main(String[] args) {
        System.out.println("OMGHAI!");
        GildedRose gildedRose = newInstance();
        gildedRose.updateQuality();
    }

    public static GildedRose newInstance() {
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));
        return new GildedRose(items);
    }

    GildedRose(List<Item> items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (isNotAgedBrie(item) && isNotBackstagePasses(item)) {
                if (item.getQuality() > 0) {
                    if (isNotSulfuras(item)) {
                        item.setQuality(item.getQuality() - 1);
                    }
                }
            } else {
                if (item.getQuality() < 50) {
                    item.setQuality(item.getQuality() + 1);

                    if (isBackstagePasses(item)) {
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

            if (isNotSulfuras(item)) {
                item.setSellIn(item.getSellIn() - 1);
            }

            if (item.getSellIn() < 0) {
                if (isNotAgedBrie(item)) {
                    if (isNotBackstagePasses(item)) {
                        if (item.getQuality() > 0) {
                            if (isNotSulfuras(item)) {
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

    private boolean isBackstagePasses(Item item) {
        return "Backstage passes to a TAFKAL80ETC concert".equals(item.getName());
    }

    private boolean isNotSulfuras(Item item) {
        return !"Sulfuras, Hand of Ragnaros".equals(item.getName());
    }

    private boolean isNotBackstagePasses(Item item) {
        return !isBackstagePasses(item);
    }

    private boolean isNotAgedBrie(Item item) {
        return !"Aged Brie".equals(item.getName());
    }

    public List<Item> getItems() {
        return items;
    }
}
