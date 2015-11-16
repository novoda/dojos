import java.util.ArrayList;
import java.util.List;

public class Recents {

    private final List<String> mListItems = new ArrayList<String>();

    public boolean isEmpty() {
        return mListItems.isEmpty();
    }

    public void add(String item) {
        if (mListItems.contains(item)) {
            mListItems.remove(item);
        }
        mListItems.add(0, item);
    }

    public String get(int index) {
        return mListItems.get(index);
    }

    public int size() {
        return mListItems.size();
    }

}
