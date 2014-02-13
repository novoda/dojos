public class HaikuHelper {

    private final String haiku;

    public HaikuHelper(String haiku) {
        this.haiku = haiku;
    }

    public boolean isValidLineCount() {
        return haiku.matches("(.*)/(.*)/(.*)");
    }
}
