public class HaikuReview {

    public static final String INPUT_ONE = "happy purple frog/eating bugs in the marshes/get indigestion";
    public static final String INPUT_TWO = "computer programs/the bugs try to eat my code/i will not let them";

    public boolean isHaiku(String input) {
        if (!hasThreeLines(input)) {
            return false;
        }

        String[] lines = splitHaiku(input);

        return numberOfSyllables(lines[0]) == 5
                && numberOfSyllables(lines[1]) == 7
                && numberOfSyllables(lines[2]) == 5;

    }

    String[] splitHaiku(String input) {
        return input.split("/");
    }

    int numberOfSyllables(String input) {

        int count = 0;

        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i == chars.length - 1 && isVowel(chars[i])) {
                return count + 1;
            }

            if (isVowel(chars[i]) && !isVowel(chars[i + 1])) {
                count++;
            }
        }
        return count;
    }

    boolean isVowel(char letter) {
        char[] chars = new char[]{'a', 'e', 'i', 'o', 'u', 'y'};
        for (char vowel : chars) {
            if (vowel == letter) {
                return true;
            }
        }
        return false;
    }

    boolean hasThreeLines(String haiku) {
        return haiku.matches(".*[/].*[/].*");
    }
}
