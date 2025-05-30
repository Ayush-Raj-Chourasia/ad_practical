package Sorting;

public class InversionCount {

    public static int countInversions(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    private static int mergeSort(int[] arr, int left, int right) {
        int count = 0;
        if (left < right) {
            int mid = (left + right) / 2;
            count += mergeSort(arr, left, mid);
            count += mergeSort(arr, mid + 1, right);
            count += merge(arr, left, mid, right);
        }
        return count;
    }

    private static int merge(int[] arr, int left, int mid, int right) {
        int[] leftArr = new int[mid - left + 1];
        int[] rightArr = new int[right - mid];

        for (int i = 0; i < leftArr.length; i++) leftArr[i] = arr[left + i];
        for (int i = 0; i < rightArr.length; i++) rightArr[i] = arr[mid + 1 + i];

        int i = 0, j = 0, k = left, invCount = 0;

        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
                invCount += (leftArr.length - i);  // Count inversions
            }
        }

        while (i < leftArr.length) arr[k++] = leftArr[i++];
        while (j < rightArr.length) arr[k++] = rightArr[j++];

        return invCount;
    }

    public static void main(String[] args) {
        int[][] testCases = {
            {12, 14, 11, 13, 15, 9, 14, 10},
            {9, 10, 12, 14, 19, 21, 32},
            {39, 24, 17, 15, 13, 11, 10},
            {10, 10, 10, 10, 10, 10, 10}
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] input = testCases[i].clone(); // clone to preserve original array
            int invCount = countInversions(input);
            System.out.println("Test Case " + (i + 1) + ": Inversion Count = " + invCount);
        }
    }
}
