import java.util.ArrayList;
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

    public List<Line> asLines() {
        String[] split = linesPattern.split(haiku);
        List<String> strings = Arrays.asList(split);
        if (!isValidLineCount()) throw new RuntimeException("A haiku yoyo, it should be 3 lines only, try again carrot");

        List<Line> lines = new ArrayList<Line>();
        for (String s : strings) {
            lines.add(new Line(s));
        }

        return lines;
    }


    public static class Line {

        private Pattern wordPattern = Pattern.compile(" ");

        private final String line;

        public Line(String line) {
            this.line = line;
            if (line.trim().isEmpty()) {
                throw new LineException();
            }
        }

        public List<Word> getWords() {
            List<Word> ret = new ArrayList<Word>();
            for (String word : wordPattern.split(line)) {
                ret.add(Word.from(word));
            }
            return ret;
        }

        public class LineException extends RuntimeException {
        }
    }

    public static class Word {

        private final String word;

        Word(String word) {
            this.word = word;
        }

        public static Word from(String word) {
            return new Word(word);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Word word1 = (Word) o;

            if (!word.equals(word1.word)) return false;

            return true;
        }

        @Override
        public int hashCode() {
            return word.hashCode();
        }
    }
}
