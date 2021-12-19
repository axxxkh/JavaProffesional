package Hashmap;

import java.util.HashSet;
import java.util.Set;

public class Hash<TKey, TValue> implements Hashable<TKey, TValue> {
    private final int INITIAL_SIZE = 16;
    private final double INCREASE = 1.5;
    private Node<TKey, TValue>[] array;
    private int size;

    public Hash() {
        array = new Node[INITIAL_SIZE];
    }

    // метод який вертає bucket до якого відповідно до hashcode привязаний ключ-значення
    private int bucketIndex(TKey key) {
        return (key == null) ? 0 : (key.hashCode() >>> 16) % array.length;
    }

    //так як часто перевірялось то вирішив вивести в окремий метод
    // тру якщо ячейка масиву налл. тепер потрібно походу буде переробити на налл
    private boolean bucketCheck(TKey key) {
        return (array[bucketIndex(key)] != null) ? true : false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void put(TKey key, TValue value) {
        if (!bucketCheck(key)) {
            array[bucketIndex(key)] = new Node<>(key, value, key.hashCode());
            ++size;
        } else {
            Node<TKey, TValue> node = nodeSearch(key);
            if (node != null) {
                node.setValue(value);
            } else {
                Node<TKey, TValue> lastNode = nodeLast(key);
                lastNode.setNext(new Node<>(key, value, key.hashCode()));
                ++size;
            }
        }
        resize();
    }

    //повертає останню ноду в бакеті
    private Node<TKey, TValue> nodeLast(TKey key) {
        Node<TKey, TValue> node = array[bucketIndex(key)];
        while (node.getNext() != null) {
            node = node.getNext();
        }
        return node;
    }

    //    шукає значення поміж нод у визначенному бакеті
    private Node<TKey, TValue> nodeSearch(TKey key) {
        Node<TKey, TValue> node = array[bucketIndex(key)];
        if (node != null) {
            do {
                if (node.getKey().equals(key)) {
                    return node;
                }
                node = node.getNext();
            } while (node != null);
        }
        return null;
    }

    @Override
    public TValue get(TKey key) {
        Node<TKey, TValue> node = nodeSearch(key);
        if (node != null) {
            return nodeSearch(key).getValue();
        }
        return null;
    }

    private void resize() {
        if (size > array.length * 7) {
            size = 0;
            Node<TKey, TValue>[] oldArray = array;
            array = new Node[(int) (array.length * INCREASE)];

            for (Node<TKey, TValue> node : oldArray) {
                if (node != null) {
                    put(node.getKey(), node.getValue());
                    while (node.getNext() != null) {
                        node = node.getNext();
                        put(node.getKey(), node.getValue());
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        int lineDivider = 0;
        for (Node<TKey, TValue> valueNode : array) {
            if (valueNode != null) {
                Node<TKey, TValue> node = valueNode;
                string.append(node.getValue());
                string.append(" ,");
                string.append(node.getValue());
                while (node.getNext() != null) {
                    node = node.getNext();
                    string.append(node.getKey());
                    string.append(" - ");
                    string.append(node.getValue());
                    string.append(" ,");
                    ++lineDivider;

                    if (lineDivider > 15) {
                        string.append("\n");
                        lineDivider = 0;
                    }
                }
            }
        }
        return string.toString();
    }

    public Set<TKey> getKeySet() {
        Set<TKey> set = new HashSet<>();
        int lineDivider = 0;
        for (Node<TKey, TValue> valueNode : array) {
            if (valueNode != null) {
                Node<TKey, TValue> node = valueNode;
                set.add(node.getKey());
                while (node.getNext() != null) {
                    node = node.getNext();
                    set.add(node.getKey());
                }
            }
        }
        return set;
    }

    public Set<TValue> getValues() {
        Set<TValue> set = new HashSet<>();
        int lineDivider = 0;
        for (Node<TKey, TValue> valueNode : array) {
            if (valueNode != null) {
                Node<TKey, TValue> node = valueNode;
                set.add(node.getValue());
                while (node.getNext() != null) {
                    node = node.getNext();
                    set.add(node.getValue());
                }
            }
        }
        return set;
    }
}