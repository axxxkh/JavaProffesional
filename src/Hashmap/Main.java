package Hashmap;

import java.util.Hashtable;

public class Main {
    public static void main(String[] args) {
        Hashtable<Integer, String> my = new Hashtable<>();

        Hash<Integer, String> myHash = new Hash<>();
        myHash.put(10, "dfd");
        System.out.println(myHash.get(10));

        for (int i = 0; i < 3000; i++) {
            myHash.put(i, " " + i);
        }

        for (int i = 0; i < 3000; i++) {
            System.out.println(i + " " + myHash.get(i));
        }

        System.out.println(myHash);
        System.out.println(myHash.get(10));
        System.out.println(myHash.size());
        System.out.println(myHash.getKeySet());
    }
}
