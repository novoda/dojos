import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

public class DataMungingTest {

    @Test
    public void shouldBeTrue() throws Exception {
        assertThat(true).isTrue();
    }

    @Test
    public void testDataRegexMatcher() {
        Pattern pattern = Pattern.compile("(\\d+)");

        String dataSet = WeatherDataset.DATA;
        String row = dataSet.split("\n")[2];

        Matcher matcher = pattern.matcher(row);
        System.out.println(row);

        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (matcher.find()) {
                String group = matcher.group(0);
                System.out.println(group);
                count++;
            }

        }

        assertTrue("matcher count was " + count, count == 3);
    }
}
