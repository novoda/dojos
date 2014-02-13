import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Haiku {

    private final String haiku;

    private Pattern linesPattern = Pattern.compile("/");

    public Haiku(String haiku) {
        this.haiku = haiku;
    }

    boolean isValidLineCount() {
        return haiku.matches("(.*)/(.*)/(.*)");
    }

    public List<String> asLines() {
        String[] split = linesPattern.split(haiku);
        List<String> strings = Arrays.asList(split);
        if (!isValidLineCount()) throw new RuntimeException("A haiku yoyo, it should be 3 lines only, try again carrot");
        return strings;
    }


}
