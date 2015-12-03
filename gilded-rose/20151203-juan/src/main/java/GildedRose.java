import java.util.ArrayList;
import java.util.List;


public class GildedRose {

	private static List<Item> items = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

        System.out.println("OMGHAI!");

        items = new ArrayList<Item>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));

        updateQuality();
}



    public static void updateQuality()
    {
        for (int i = 0; i < items.size(); i++)
        {
            Item item = items.get(i);
            updateQualityOf(item);
        }
    }

    public static void updateQualityOf(Item item) {
        if ((!isAgedBrie(item)) && !"Backstage passes to a TAFKAL80ETC concert".equals(item.getName()))
        {
            if (item.getQuality() > 0)
            {
                if (!"Sulfuras, Hand of Ragnaros".equals(item.getName()))
                {
                    item.setQuality(item.getQuality() - 1);
                }
            }
        }
        else
        {
            if (item.getQuality() < 50)
            {
                item.setQuality(item.getQuality() + 1);

                if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName()))
                {
                    if (item.getSellIn() < 11)
                    {
                        if (item.getQuality() < 50)
                        {
                            item.setQuality(
                                    item.getQuality() + 1);
                        }
                    }

                    if (item.getSellIn() < 6)
                    {
                        if (
                                item.getQuality() < 50)
                        {

                            item.setQuality(item.getQuality() + 1);
                        }
                    }
                }
            }
        }

        if (!"Sulfuras, Hand of Ragnaros".equals(item.getName()))
        {
            item.setSellIn(item.getSellIn() - 1);
        }

        if (item.getSellIn() < 0)
        {
            if (!isAgedBrie(item))
            {
                if (!"Backstage passes to a TAFKAL80ETC concert".equals(item.getName()))
                {
                    if (item.getQuality() > 0)
                    {
                        if (!"Sulfuras, Hand of Ragnaros".equals(item.getName()))
                        {
                            item.setQuality(item.getQuality() - 1);
                        }
                    }
                }
                else
                {
                    item.setQuality(item.getQuality() - item.getQuality());
                }
            }
            else
            {
                if (item.getQuality() < 50)
                {
                    item.setQuality(item.getQuality() + 1);
                }
            }
        }
    }

    private static boolean isAgedBrie(Item item) {
        return "Aged Brie".equals(item.getName());
    }

}
