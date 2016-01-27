import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ## Part One: Weather Data
 In `weather.dat` you’ll find daily weather data for Morristown, NJ for June 2002.
 Write a program to
 output the day number (column one) with the smallest temperature spread
 (the maximum temperature is the second column, the minimum the third column).
 */
public class WeatherData {

    public static void main(String[] args) {

        String[] rowsArray = WeatherDataset.DATA.split("\n");
        List<String> rowData = new ArrayList<String>();
        for (int i = 0; i < rowsArray.length; i++) {
            if(i < 2) {
                continue;
            }
            rowData.add(rowsArray[i]);
        }
        System.out.println(rowData);
    }

}
