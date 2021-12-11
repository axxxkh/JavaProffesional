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
        return key.hashCode() & (INITIAL_SIZE - 1);
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean equals() {
        return false;
    }

    @Override
    public void put(TKey key, TValue value) {
        if (array[bucketIndex(key)] == null) {
            array[bucketIndex(key)] = new Node<>(key, value, key.hashCode());
        } else {

        }

    }

    private Node nodeIterator(int bucketIndex) {
        Node node = array[bucketIndex];
        if (node.next != null) {
            return node.next;
        }
        return null;
    }

//    private TValue bucketIterator(TKey key) {
//        while (array[bucketIndex(key)].next != null) {
//            if (array[bucketIndex(key)].key == key) {
//                return array[bucketIndex(key)].value;
//            }
//        }
//        return null;
//    }

    @Override
    public boolean contains(TKey key) {
        if (array[bucketIndex(key)] != null) {
            while (nodeIterator(bucketIndex(key)) != null) {
                if (nodeIterator(bucketIndex(key)).key == key) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public TValue get(TKey key) {
        if (contains(key)) {

            return bucketIterator(key);
        }
        System.out.println("No such element in the hashMap");
        return null;
    }

    private void resize() {
    }
}
