public class HaikuReview {

    public static final char HAIKU_SEPARATOR = '/';

    private static final String INPUT_ONE = "happy purple frog/eating bugs in the marshes/get indigestion";
    private static final String INPUT_TWO = "computer programs/the bugs try to eat my code/i will not let them";

    public boolean validate(String input) {
        int slashesCounter = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '/') {
                slashesCounter++;
            }
        }

        return slashesCounter == 2;
    }

}
