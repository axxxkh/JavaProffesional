package Hashmap;

public class Node<TKey, TValue> {
    public TKey key;
    public TValue value;
    public int hash;
    public Node next;

    public Node(TKey key, TValue value, int hash) {
        this.key = key;
        this.value = value;
        this.hash = hash;
        this.next = null;
    }
}
