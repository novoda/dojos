import java.util.List;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class GildedRoseTest {

    private static final String EXPECTED = "[Item{name='+5 Dexterity Vest', sellIn=9, quality=19}, Item{name='Aged Brie', sellIn=1, quality=1}, Item{name='Elixir of the Mongoose', sellIn=4, quality=6}, Item{name='Sulfuras, Hand of Ragnaros', sellIn=0, quality=80}, Item{name='Backstage passes to a TAFKAL80ETC concert', sellIn=14, quality=21}, Item{name='Conjured Mana Cake', sellIn=2, quality=5}]";

    @Test
    public void smokeTest() throws Exception {
        GildedRose gildedRose = GildedRose.newInstance();

        gildedRose.updateQuality();
        List<Item> items = gildedRose.getItems();
        String actual = items.toString();
        System.out.println(actual);

        assertThat(actual).isEqualTo(EXPECTED);
    }

}
