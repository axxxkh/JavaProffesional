package Hashmap;

public class Hash<TKey, TValue> implements Hashable<TKey, TValue> {
    private final int INITIAL_SIZE = 16;
    private int size;
    private Node<TKey, TValue>[] array;
    private int loadLevel;

    public Hash() {
        array = new Node[INITIAL_SIZE];
    }

    private int bucketIndex(TKey key) {
        return (key.hashCode() / Integer.MAX_VALUE) * (INITIAL_SIZE - 1);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean equals() {
        return false;
    }

    @Override
    public void put(TKey key, TValue value) {
        if (array[bucketIndex(key)] == null) {
            array[bucketIndex(key)] = new Node<>(key, value, key.hashCode());
            size++;
        } else {
            Node node = nodeSearch(key);
            if (node != null) {
                node.value = value;
            } else {
                Node<TKey, TValue> lastNode = nodeLast(key);
                lastNode.next = new Node(key, value, key.hashCode());
                size++;
            }
        }
    }

    private Node nodeNext(Node node) {
        if (node.next != null) {
            return node.next;
        }
        return null;
    }

    private Node nodeLast(TKey key) {
        Node node = array[bucketIndex(key)];
        do {
            if (node.next == null) {
                return node;
            }
            node = node.next;
        } while (node.next != null);
        return node;
    }

    private Node nodeSearch(TKey key) {
        if (array[bucketIndex(key)] != null) {
            Node node = array[bucketIndex(key)];
            while (node.next != null) {
                if (node.key == key) {
                    return node;
                }
                node = node.next;
            }
        }
        return null;
    }

    @Override
    public boolean contains(TKey key) {
        int bucket = bucketIndex(key);
        if (array[bucket] != null && nodeSearch(key) != null) {
            return true;
        }
        return false;
    }

    @Override
    public TValue get(TKey key) {
        int sfs = bucketIndex(key);
        if (array[bucketIndex(key)] != null) {
            Node<TKey, TValue> node = nodeSearch(key);
            if (node != null) {
                return node.value;
            }
        }
        System.out.println("no such element");
        return null;
    }

    private void resize() {
        Node<TKey, TValue>[] tempArray = array;
        Node<TKey, TValue>[] newArray = new Node[(int) (array.length * 1.5)];
        array = newArray;

        for (int i = 0; i < tempArray.length; i++) {
            if (tempArray[i] != null) {
                Node node = tempArray[i];
                put((TKey) node.key, (TValue) node.value);
                while (node.next != null) {
                    node = nodeNext(node);
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                Node node = array[i];
                string.append(node.value);
                string.append(" ,");
                while (node.next != null) {
                    node = nodeNext(node);
                    string.append(node.value);
                    string.append(" ,");
                }
            }
        }
        return string.toString();
    }
}
