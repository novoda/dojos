/**
 * Each haiku is guaranteed to contain three lines, and
 * each line will contain at least one word. Your job is
 * to determine whether each line has the correct number
 * of syllables (5/7/5). For the purposes of this problem,
 * every contiguous sequence of one or more vowels counts
 * as one syllable, where the vowels are
 * a, e, i, o, u, and y. Every word will contain at least
 * one syllable.
 */
public class HaikuReview {

    public String[] splitHaiku(String haiku) {

        return haiku.split("/");
    }

    public boolean validateHaikuCharacters(String haiku) {
        String haikuWithoutSlashes = haiku.replace("/", "");
        if (haikuWithoutSlashes.length() > 200) {
            return false;
        }

        return haiku.matches("[a-z// ]*");
    }

    public int getNumberOfSyllables(String line) {

        char[] chars = line.toCharArray();
        char previousCharacter = ' ';
        int syllableCount = 0;

        for (int i = 0; i < chars.length; i++) {
            char currentCharacter = chars[i];

            boolean previousCharacterIsAVowel = isAConstantant(previousCharacter);
            boolean endOfLine = i == chars.length - 1;
            if (previousCharacterIsAVowel && endOfLine) {
                syllableCount++;
            } else if (previousCharacterIsAVowel && !isAConstantant(currentCharacter)) {
                syllableCount++;
            }

            previousCharacter = currentCharacter;
        }
        return syllableCount;

    }

    public boolean isAConstantant(char character) {
        return !(character == 'a'
                || character == 'e'
                || character == 'i'
                || character == 'o'
                || character == 'u'
                || character == 'y');
    }
}
