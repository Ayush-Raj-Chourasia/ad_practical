package Hashing;

import java.util.*;

public class HashSeparateChaining {
    static int size = 10;
    static LinkedList<Integer>[] hashTable = new LinkedList[size];

    static void insert(int key) {
        int index = key % size;
        if (hashTable[index] == null)
            hashTable[index] = new LinkedList<>();
        hashTable[index].add(key);
    }

    static void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(i + " => ");
            if (hashTable[i] != null)
                for (int key : hashTable[i])
                    System.out.print(key + " -> ");
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        int[] keys = {23, 43, 13, 27};
        for (int key : keys) insert(key);
        display();
    }
}
