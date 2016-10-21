public class SingleLinkedSimpleList implements SimpleList {

    private Node start;

    private static class Node {
        String data;
        Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public SingleLinkedSimpleList() {
        start = null;
    }

    @Override
    public String find(String element) {
        Node current = start;
        while (current != null) {
            if (current.data.equals(element)) {
                return element;
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public void add(String element) {
        if (start == null) {
            start = new Node(element, null);
            return;
        }
        Node current = start;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(element, null);
    }

    private int size() {
        int size = 0;
        Node current = start;
        while (current != null) {
            size += 1;
            current = current.next;
        }
        return size;
    }

    @Override
    public String[] values() {
        String[] array = new String[size()];
        Node current = start;
        int index = 0;
        while (current != null) {
            array[index] = current.data;
            index += 1;
            current = current.next;
        }
        return array;
    }

    @Override
    public void delete(String element) {
        Node previous = null;
        Node current = start;
        while (current != null) {
            if (current.data.equals(element)) {
                if (previous == null) {
                    start = current.next;
                } else {
                    previous.next = current.next;
                }
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
