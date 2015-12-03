import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class GildedRoseTest {

    @Test
    public void testThatTestsRun() throws Exception {
        assertThat(true).isEqualTo(true);
    }

    @Test
    public void testUpdaterCurrentBehaviour() throws Exception {
        Updater updater = new Updater();

        List<Item> items = new ArrayList<Item>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));

        updater.updateQuality(items);

        assertThat(items.get(0)).isEqualTo(new Item("+5 Dexterity Vest", 9, 19));
    }
}
