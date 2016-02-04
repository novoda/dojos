import java.util.ArrayList;
import java.util.List;

/**
 * Your task is to create an LCD string representation of an
 * integer value using a 3x3 grid of space, underscore, and
 * pipe characters for each digit. Each digit is shown below
 * (using a dot instead of a space)
 * <p/>
 * ._.   ...   ._.   ._.   ...   ._.   ._.   ._.   ._.   ._.
 * |.|   ..|   ._|   ._|   |_|   |_.   |_.   ..|   |_|   |_|
 * |_|   ..|   |_.   ._|   ..|   ._|   |_|   ..|   |_|   ..|
 * <p/>
 * <p/>
 * Example: 910
 * <p/>
 * ._. ... ._.
 * |_| ..| |.|
 * ..| ..| |_|
 */

public class LcdDigits {

    private final int inputNumber;

    public LcdDigits(int inputNumber) {
        this.inputNumber = inputNumber;
    }

    public String line(int lineNumber) {


        return Digit.values()[inputNumber].line(lineNumber);
    }

    private enum Digit {
        ZERO(" _ ", "| |", "|_|"),
        ONE("   ", "  |", "  |"),
        TWO(" _ ", " _|", "|_ ");

        private final List<String> lines = new ArrayList<String>();

        Digit(String firstLine, String secondLine, String thirdLine) {
            lines.add(firstLine);
            lines.add(secondLine);
            lines.add(thirdLine);
        }

        String line(int lineNumber) {
            return lines.get(lineNumber);
        }

    }

}
