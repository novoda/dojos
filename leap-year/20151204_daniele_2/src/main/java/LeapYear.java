public class LeapYear {

    public boolean isLeap(int year) {
        if (isDivisibleBy(year, 400)) {
            return true;
        }

        return isDivisibleBy(year, 4) && !isDivisibleBy(year, 100);
    }

    private boolean isDivisibleBy(int year, int divisor) {
        return year % divisor == 0;
    }
}
