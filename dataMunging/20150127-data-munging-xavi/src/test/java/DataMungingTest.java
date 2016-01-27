import com.google.common.base.Strings;
import org.junit.Test;
import rx.Observable;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DataMungingTest {

    @Test
    public void shouldBeTrue() throws Exception {
        assertThat(true).isTrue();
    }

    @Test
    public void shouldReadAllLinesInDataset() throws Exception {
        Observable<String> lines = new DataMunger(WeatherDataset.DATA).lines();

        List<String> allLines = lines.toList().toBlocking().first();

        assertThat(allLines).hasSize(33);
    }

    @Test
    public void shouldReadFirstLineCorrectly() throws Exception {
        Observable<String> lines = new DataMunger(WeatherDataset.DATA).lines();

        String firstLine = lines.toBlocking().first();

        assertThat(firstLine).isEqualTo("  Dy MxT   MnT   AvT   HDDay  AvDP 1HrP TPcpn WxType PDir AvSp Dir MxS SkyC MxR MnR AvSLP");
    }

    @Test
    public void shouldSkipHeaderWhenAskedForEntries() throws Exception {
        Observable<String> entries = new DataMunger(WeatherDataset.DATA).entries();

        List<String> allEntries = entries.toList().toBlocking().first();

        assertThat(allEntries).doesNotContain("  Dy MxT   MnT   AvT   HDDay  AvDP 1HrP TPcpn WxType PDir AvSp Dir MxS SkyC MxR MnR AvSLP");
    }

    @Test
    public void shouldSkipEmptyLinesWhenAskedForEntries() throws Exception {
        Observable<String> entries = new DataMunger(WeatherDataset.DATA).entries();

        List<String> allEntries = entries.toList().toBlocking().first();

        assertThat(allEntries).doesNotContain("");
    }

    @Test
    public void shouldSkipMonthAverageWhenAskedForEntries() throws Exception {
        Observable<String> entries = new DataMunger(WeatherDataset.DATA).entries();

        List<String> allEntries = entries.toList().toBlocking().first();

        assertThat(allEntries).doesNotContain("  mo  82.9  60.5  71.7    16  58.8       0.00              6.9          5.3");
    }


}
