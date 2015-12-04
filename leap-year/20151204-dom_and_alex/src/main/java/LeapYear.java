public class LeapYear {
    public boolean isALeapYear(int year) {
        if (year % 4 == 0) {
            return true;
        }
        return false;
    }
}
