import com.google.common.base.Stopwatch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SpeedTest {

    static class JavaListWrapper implements SimpleList {
        private List<String> javaList;

        public JavaListWrapper(List<String> javaList) {
            this.javaList = javaList;
        }

        @Override
        public String find(String element) {
            int index = javaList.indexOf(element);
            return index == -1 ? null : javaList.get(index);
        }

        @Override
        public void add(String element) {
            javaList.add(element);
        }

        @Override
        public String[] values() {
            ArrayList<String> arrayList = new ArrayList();
            arrayList.addAll(javaList);
            return arrayList.toArray(new String[0]);
        }

        @Override
        public void delete(String element) {
            javaList.remove(element);
        }

        @Override
        public String toString() {
            return "wrapping " + javaList.getClass().getSimpleName();
        }
    }

    static class JavaArrayListFactory implements SimpleListFactory {
        @Override
        public SimpleList create() {
            return new JavaListWrapper(new ArrayList());
        }
    }

    static class JavaLinkedListFactory implements SimpleListFactory {
        @Override
        public SimpleList create() {
            return new JavaListWrapper(new LinkedList());
        }
    }

    static class MySimpleListFactory implements SimpleListFactory {
        @Override
        public SimpleList create() {
            return new MySimpleList();
        }
    }

    private SimpleListFactory factory;
    private int itemCount;

    public SpeedTest(SimpleListFactory factory, int itemCount) {
        this.factory = factory;
        this.itemCount = itemCount;
    }

    private void run() {
        System.out.println("\n" + factory.getClass().getSimpleName() + " with " + itemCount + " items");

        drainFromStart(listWithItems());
        drainFromEnd(listWithItems());
    }

    private void drainFromStart(SimpleList list) {
        String[] values = list.values();

        Stopwatch stopwatch = Stopwatch.createStarted();

        for (String value : values) {
            list.delete(value);
        }

        printTime("drain", stopwatch.stop());
    }

    private void drainFromEnd(SimpleList list) {
        String[] values = list.values();

        Stopwatch stopwatch = Stopwatch.createStarted();

        for (int i = values.length - 1; i >= 0; i--) {
            String value = values[i];
            list.delete(value);
        }

        printTime("backdrain", stopwatch.stop());
    }

    private SimpleList listWithItems() {
        Stopwatch stopwatch = Stopwatch.createStarted();

        SimpleList list = factory.create();
        for (int i = 0; i < itemCount; i++) {
            list.add("item" + Integer.toString(i));
        }

        printTime("add", stopwatch.stop());
        return list;
    }

    private static void printTime(String label, Stopwatch watch) {
        String text = String.format("%s: %6d  ", label, watch.elapsed(TimeUnit.MILLISECONDS));
        System.out.print(text);
    }

    public static void main(String[] args) {

        SimpleListFactory[] factories = {
                new JavaArrayListFactory(),
                new JavaLinkedListFactory(),
//                new MySimpleListFactory()
        };

        int[] itemSizes = {100, 1000, 10000, 20000, 50000};

        for (int itemSize : itemSizes) {
            for (SimpleListFactory factory : factories) {
                new SpeedTest(factory, itemSize).run();
            }
        }

    }
}
