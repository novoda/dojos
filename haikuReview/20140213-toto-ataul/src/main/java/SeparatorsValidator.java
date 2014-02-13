public class SeparatorsValidator {

    private static final char HAIKU_SEPARATOR = '/';
    private static final int SEPARATORS_COUNT = 2;

    public boolean validate(String input) {
        int separatorsCounter = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == HAIKU_SEPARATOR) {
                separatorsCounter++;
            }
        }

        return separatorsCounter == SEPARATORS_COUNT;
    }

}
