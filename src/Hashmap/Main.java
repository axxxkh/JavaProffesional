package Hashmap;

import java.util.Hashtable;

public class Main {
    public static void main(String[] args) {
        Hashtable<Integer, String> my = new Hashtable<>();
        my.put(10, "FF");
        System.out.println(my);
        my.put(10, "AA");

        Hash<Integer, String> myHash = new Hash<>();
        myHash.put(10, "dfd");
        System.out.println(myHash.get(10));

        for (int i = 1; i < 92; i++) {
            myHash.put(i, "dsfdf");
        }

//        for (int i = 1; i < 200; i++) {
//            System.out.println(i+" "+myHash.get(i));
//        }

              System.out.println(myHash);
        myHash.put(10, "dddd");
        System.out.println(myHash.size());
    }
}
