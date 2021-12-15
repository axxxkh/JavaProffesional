package Hashmap;

public class Node<TKey, TValue> {
    private TKey key;
    private TValue value;
    private int hash;
    private Node<TKey, TValue> next;


    public TKey getKey() {
        return key;
    }

    public Node<TKey, TValue> getNext() {
        return next;
    }

    public void setNext(Node<TKey, TValue> next) {
        this.next = next;
    }

    public void setKey(TKey key) {
        this.key = key;
    }

    public TValue getValue() {
        return value;
    }

    public void setValue(TValue value) {
        this.value = value;
    }

    public Node(TKey key, TValue value, int hash) {
        this.key = key;
        this.value = value;
        this.hash = hash;
        this.next = null;
    }
}
