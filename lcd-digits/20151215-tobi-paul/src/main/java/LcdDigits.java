import java.util.HashMap;
import java.util.Map;

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

    private final IScreen screen;
    private final Map<Integer, String[]> lookupTable = new HashMap<Integer, String[]>();

    void displayNumber(final int number) {
        screen.displayFirstLine(lookupTable.get(number)[0]);
        screen.displaySecondLine(lookupTable.get(number)[1]);
        screen.displayThirdLine(lookupTable.get(number)[2]);
    }

    public LcdDigits(IScreen screen) {
        this.screen = screen;
        lookupTable.put(0, new String[]{" _ ", "| |", "|_|"});
    }

    interface IScreen {

        void displayFirstLine(String line);

        void displaySecondLine(String line);

        void displayThirdLine(String line);
    }

}
