package Hashmap;

import java.util.Hashtable;

public class Main {
    public static void main(String[] args) {
        Hashtable<Integer,String> my = new Hashtable<>();
        my.put(10,"FF");
        System.out.println(my);
        my.put(10,"AA");
    }
}
