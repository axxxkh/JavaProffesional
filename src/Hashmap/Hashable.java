package Hashmap;

public interface Hashable<TKey, TValue> {

    void put(TKey key, TValue value);

    TValue get(TKey key);

    int size();

}
