import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class GildedRoseTest {

    @Test
    public void testThatTestsRun() throws Exception {
        assertThat(true).isEqualTo(true);
    }

    @Test
    public void testThatWhenSellDateHasPassedThenQualityDegradesTwiceAsFast() {

    }

    @Test
    public void testThatQualityOfItemIsNeverNegative() {

    }

    @Test
    public void testThatAgedBrieIncreasesQualityWhenItemGetsOlder() {

    }

    @Test
    public void testThatQualityOfItemDecreasesByOneIfSellDateDidNotPass() {
        Item item = new Item("An item", 1, 50);
        GildedRose.updateQualityOf(item);
        assertThat(item.getQuality()).isEqualTo(49);
    }

    @Test
    public void testThatQualityOfItemDecreasesByTwoIfSellDatePassed() {
        Item item = new Item("An item", 0, 50);
        GildedRose.updateQualityOf(item);
        assertThat(item.getQuality()).isEqualTo(48);
    }

    @Test
    public void testThatLegendaryItemsAreNeverSold() {

    }

    @Test
    public void testThatLegendaryItemsNeverDecreasesQuality() {

    }

}
