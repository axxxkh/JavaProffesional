package Hashmap;

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
        if (array[bucketIndex(key)] != null) {
            return true;
        }
        return false;
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

    // повертає наступну ноду
    private Node<TKey, TValue> nodeNext(Node<TKey, TValue> node) {
        if (node.getNext() != null) {
            return node.getNext();
        }
        return null;
    }

    //повертає останню ноду в бакеті
    private Node<TKey, TValue> nodeLast(TKey key) {
        Node<TKey, TValue> node = array[bucketIndex(key)];
        while (node.getNext() != null) {
            node = nodeNext(node);
        }
        return node;
    }

    //    шукає значення поміж нод у визначенному бакеті
    private Node<TKey, TValue> nodeSearch(TKey key) {
        Node<TKey, TValue> node = array[bucketIndex(key)];
        while (node.getNext() != null) {
            if (node.getKey().equals(key)) {
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    @Override
    public TValue get(TKey key) {
        Node<TKey, TValue> node = array[bucketIndex(key)];
        while (node.getNext() != null) {
            if (node.getKey().equals(key)) {
                return node.getValue();
            }
            node = nodeNext(node);
        }
        return null;
    }

    private void resize() {
        if (size > array.length * 7) {
            size = 0;
            Node<TKey, TValue>[] tempArray = array;
            array = new Node[(int) (array.length * INCREASE)];
            Node<TKey, TValue> tempNode;

            for (Node<TKey, TValue> node : tempArray) {
                tempNode = node;
                if (tempNode != null) {
                    put(tempNode.getKey(), tempNode.getValue());
                    while (tempNode.getNext() != null) {
                        tempNode = nodeNext(tempNode);
                        put(tempNode.getKey(), tempNode.getValue());
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
                    node = nodeNext(node);
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

    public String getKeySet() {
        StringBuilder string = new StringBuilder();
        int lineDivider = 0;
        for (Node<TKey, TValue> valueNode : array) {
            if (valueNode != null) {
                Node<TKey, TValue> node = valueNode;
                string.append(node.getKey());
                string.append(", ");
                while (node.getNext() != null) {
                    node = nodeNext(node);
                    string.append(node.getKey());
                    string.append(", ");
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

    public String getValues() {
        StringBuilder string = new StringBuilder();
        int lineDivider = 0;
        for (Node<TKey, TValue> valueNode : array) {
            if (valueNode != null) {
                Node<TKey, TValue> node = valueNode;
                string.append(node.getValue());
                string.append(", ");
                while (node.getNext() != null) {
                    node = nodeNext(node);
                    string.append(node.getValue());
                    string.append(", ");
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
}