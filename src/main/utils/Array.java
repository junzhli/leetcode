package utils;

public class Array {
    public static void printIntArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void swapValueIntArray(int[] arr, int idxA, int idxB) {
        if (idxA == idxB) {
            return;
        }
        arr[idxA] ^= arr[idxB];
        arr[idxB] ^= arr[idxA];
        arr[idxA] ^= arr[idxB];
    }
}
