import java.util.ArrayList;
import java.util.List;

/**
 * Write a program to generate all potential
 * anagrams of an input string.
 * <p/>
 * For example, the potential anagrams of "biro" are
 * <p/>
 * biro bior brio broi boir bori
 * ibro ibor irbo irob iobr iorb
 * rbio rboi ribo riob roib robi
 * obir obri oibr oirb orbi orib
 */
public class Anagrams {
    public static List<String> generate(String input) {
        List<String> anagrams = new ArrayList<String>();

        char[] chars = input.toCharArray();
        int inputLength = chars.length;
        int maxAnagrams = calculateTotalAnagramsForWordSize(inputLength);

        for (int a = 0; a < maxAnagrams; a++) {
            int pickPosition = calculatePickPosition(inputLength - 1, a);
//            System.out.println("pick at " + pickPosition);
            int dropPosition = calculateDropPosition(inputLength - 1, pickPosition, a);
//            System.out.println("drop at " + dropPosition);
            char movingLetter = chars[pickPosition];
//            System.out.println("moving " + movingLetter);
//            System.out.println("________");
            char[] output = new char[inputLength];
            for (int i = 0; i < inputLength; i++) {
                if (dropPosition == i) {
                    output[dropPosition] = movingLetter;
                    output[pickPosition] = chars[i];
                } else {
                    output[i] = chars[i];
                }
            }
            anagrams.add(String.valueOf(output));
        }
        return anagrams;
    }

    private static int calculateTotalAnagramsForWordSize(int size) {
        int total = size;
        while (--size > 0) {
            total = total * size;
        }
        return total;
    }

    private static int calculatePickPosition(int maxPosition, int iteration) {
        return 0;
    }

    private static int calculateDropPosition(int maxPosition, int pickUpPosition, int iteration) {
        int dropPosition = iteration * (pickUpPosition + 1);
        return dropPosition < maxPosition ? dropPosition : maxPosition;
    }
}
