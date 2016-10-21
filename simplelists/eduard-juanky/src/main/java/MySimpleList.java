public class MySimpleList implements SimpleList {

    private static final String NOT_FOUND = null;
    private Node headNode;
    private Node tailNode;
    private int count;

    @Override
    public String find(String element) {
        if (hasHead()) {
            Node current = headNode;
            do {
                if (current.hasElement(element)) {
                    return element;
                }
                current = current.nextNode;
            }
            while (isInBounds(current));
        }
        return NOT_FOUND;

    }

    private boolean isInBounds(Node current) {
        return current != null;
    }

    @Override
    public void add(String element) {
        if (hasHead()) {
            Node newNode = new Node(element);
            tailNode.nextNode = newNode;
            tailNode = newNode;
        } else {
            headNode = new Node(element);
            tailNode = headNode;
        }
        count++;
    }

    private boolean hasHead() {
        return headNode != null;
    }

    @Override
    public String[] values() {
        String[] values = new String[count];
        if (count == 0) {
            return values;
        }

        Node current = headNode;
        int loopCount = 0;
        do {
            values[loopCount] = current.content;
            current = current.nextNode;
            loopCount++;
        }
        while (isInBounds(current));

        return values;
    }

    @Override
    public void delete(String element) {
        if (count == 0) {
            return;
        }

        if (headNode.hasElement(element)) {
            headNode = headNode.nextNode;
            count--;
            return;
        }

        Node current = headNode.nextNode;
        Node previous = headNode;
        do {
            if (current.hasElement(element)) {
                previous.nextNode = current.nextNode;
                break;
            }
            previous = current;
            current = current.nextNode;
        }
        while (isInBounds(current));
        count--;
    }

    static class Node {
        private Node nextNode;
        private String content;

        public Node(String element) {
            this.content = element;
        }

        public boolean hasElement(String element) {
            return this.content.equals(element);
        }
    }
}
