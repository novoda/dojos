import java.io.BufferedReader;
import java.io.StringReader;


public class Weather {

    public static void main(String[] args) {
        findMinTemperature();
    }

    private static void findMinTemperature() {
        StringReader stringReader = new StringReader(WeatherDataset.DATA);
        BufferedReader bufferedReader = new BufferedReader(stringReader);

        String minTemp = bufferedReader.lines()
                .skip(2)
                .map(line -> line.split("\\s+"))
                .map(a -> a[3])
                .filter(a -> a.endsWith("*"))
                .findFirst().get();

        System.out.println(minTemp);
    }

}
