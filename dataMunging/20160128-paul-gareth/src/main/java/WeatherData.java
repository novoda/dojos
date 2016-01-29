import java.io.BufferedReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ## Part One: Weather Data
 In `Weather.DATA` you’ll find daily weather data for Morristown, NJ for June 2002.
 Write a program to
 output the day number (column one) with the smallest temperature spread
 (the maximum temperature is the second column, the minimum the third column).
 */
public class WeatherData {

    public static void main(String[] args) {

        String dataSet = WeatherDataset.DATA;

        new WeatherData().parseData(dataSet);


    }


    public void parseData(String dataSet) {
        String[] rows = dataSet.split("\n");

        String headerRow = rows[0];
        System.out.println("ROWS count: " + rows.length);

        Pattern pattern = Pattern.compile("(\\d+)");

        for (int i = 1; i < rows.length; i++) {

            Matcher matcher = pattern.matcher(rows[i]);

            if(matcher.find()) {
                int count = matcher.groupCount();
                System.out.println("MATCHES: " + count);
                if(count > 2) {
                    String day = matcher.group(0);
                    String maxT = matcher.group(1);
                    String minT = matcher.group(2);

                    System.out.println("DAY: " + day);
                    System.out.println("MaxTemp: " + maxT);
                    System.out.println("MinTemp: " + minT);
                }
            }
        }
    }



}
