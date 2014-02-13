public class HaikuReview {

    public static final String HAIKU_SEPARATOR = "/";

    private static final String INPUT_ONE = "happy purple frog/eating bugs in the marshes/get indigestion";
    private static final String INPUT_TWO = "computer programs/the bugs try to eat my code/i will not let them";

    public static boolean hasTwoSlashes(String input) {
        int firstOccurrence = input.indexOf(HAIKU_SEPARATOR);
        int lastOccurrence = input.lastIndexOf(HAIKU_SEPARATOR);
        return firstOccurrence != lastOccurrence;
    }
}
