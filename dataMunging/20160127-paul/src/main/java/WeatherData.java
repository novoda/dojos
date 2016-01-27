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
        String[] allRows = getAllRows(WeatherDataset.DATA);
        String[] dataRows = removeHeaderRows(allRows);

        List<Weather> weather = new ArrayList<Weather>();
        for (int i = 0; i < dataRows.length; i++) {
            String row = dataRows[i];
            String[] rowData = row.split("\\s+");

            System.out.println(i + ": " + Arrays.asList(rowData));
            if(!valid(rowData[1])) {
                continue;
            }
            int day = cleanCell(rowData[1]);

            if(!valid(rowData[2])) {
                continue;
            }
            int maximumTemperatureFarenheight = cleanCell(rowData[2]);

            if(!valid(rowData[3])) {
                continue;
            }
            int minimumTemperatureFarenheight = cleanCell(rowData[3]);
            
            Weather rowWeather = new Weather(day, maximumTemperatureFarenheight, minimumTemperatureFarenheight);
            weather.add(rowWeather);
            System.out.println(rowWeather);
        }

        System.out.println(weather);
    }

    private static boolean valid(String s) {
        try{
            cleanCell(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static Integer cleanCell(String input) {
        input = input.trim();
        int totalLength = input.length() - 1;
        System.out.println(input);
        char start = input.charAt(0);
        char end = input.charAt(totalLength);
        if(isInteger(start) && isInteger(end)) {
            return Integer.valueOf(input);
        } else if(isInteger(start) && !isInteger(end)) {
            return Integer.parseInt(input.substring(0, totalLength - 1));
        } else {
            return Integer.parseInt(input.substring(1, totalLength));
        }
    }

    private static boolean isInteger(char input) {
        try {
            System.out.println("IS INT "  + input);
            Integer.parseInt(String.valueOf(input));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static String[] getAllRows(String data) {
        return data.split("\n");
    }

    private static String[] removeHeaderRows(String[] allRows) {
        int totalHeaderRows = 2;
        String[] dataRows = new String[allRows.length - totalHeaderRows];
        for (int i = 0; i < allRows.length; i++) {
            if(i < totalHeaderRows) {
                continue;
            }
            dataRows[i - totalHeaderRows] = allRows[i];
        }
        return dataRows;
    }

    static class Weather {
        private final int day;
        private final int maximumTemperatureFarenheight;
        private final int minimumTemperatureFarenheight;

        Weather(int day, int maximumTemperatureFarenheight, int minimumTemperatureFarenheight) {
            this.day = day;
            this.maximumTemperatureFarenheight = maximumTemperatureFarenheight;
            this.minimumTemperatureFarenheight = minimumTemperatureFarenheight;
        }

        public int getDay() {
            return day;
        }

        public int calculateTemperatureSpreadFarenheight() {
            return maximumTemperatureFarenheight - minimumTemperatureFarenheight;
        }

        @Override
        public String toString() {
            return "Weather{" +
                    "day=" + day +
                    ", maximumTemperatureFarenheight=" + maximumTemperatureFarenheight +
                    ", minimumTemperatureFarenheight=" + minimumTemperatureFarenheight +
                    '}';
        }
    }

}
