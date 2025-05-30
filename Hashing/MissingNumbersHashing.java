package Hashing;

public class MissingNumbersHashing {
    public static void main(String[] args) {
        int[] arr = {21, 29, 23, 22, 26, 27, 25};
        int min = 21, max = 30;

        // Hash table of size (max - min + 1)
        boolean[] hashTable = new boolean[max - min + 1];

        // Insert elements into hash table using hash function
        for (int num : arr) {
            int index = num - min;
            hashTable[index] = true;
        }

        // Find missing numbers
        System.out.println("Missing numbers between 21 to 30:");
        for (int i = 0; i < hashTable.length; i++) {
            if (!hashTable[i]) {
                System.out.print((i + min) + " ");
            }
        }
    }
}
