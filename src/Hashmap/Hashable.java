package Hashmap;

public interface Hashable<TKey, TValue> {
    boolean equals();

    String toString();

    void put(TKey key, TValue value);

    boolean contains(TKey key);

    TValue get(TKey key);

    int size();

}
