public class HaikuReview {

    private static final String INPUT_ONE = "happy purple frog/eating bugs in the marshes/get indigestion";
    private static final String INPUT_TWO = "computer programs/the bugs try to eat my code/i will not let them";


    public static boolean hasThreeLines(String input) {

        if (input == null) return false;

        String[] arrayResult = input.split("/");

        return (  arrayResult.length == 3);

    }


    public static boolean hasWord(String input) {

        if (input == null) return false;

        return (input.matches("[a-z]+"));
    }

    public static boolean checkWordsInEachLine(String haiku) {

        if (!hasThreeLines(haiku)) return false;

        String[] arrayResult = haiku.split("/");

        for (String sentence : arrayResult) {
            String[] words = sentence.split(" ");
            if (words.length == 0) {
                return false;
            }
            for (String word : words) {
                if (!hasWord(word)) return false;
            }
        }

        return true;
    }

}
