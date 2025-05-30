package Hashing;

public class HashLinearProbing {
    static int size = 10;
    static Integer[] hashTable = new Integer[size];

    static void insert(int key) {
        int index = key % size;
        int start = index;
        while (hashTable[index] != null) {
            index = (index + 1) % size;
            if (index == start) {
                System.out.println("Hash table full");
                return;
            }
        }
        hashTable[index] = key;
    }

    static void display() {
        for (int i = 0; i < size; i++)
            System.out.println(i + " => " + (hashTable[i] != null ? hashTable[i] : "null"));
    }

    public static void main(String[] args) {
        int[] keys = {23, 43, 13, 27};
        for (int key : keys) insert(key);
        display();
    }
}
