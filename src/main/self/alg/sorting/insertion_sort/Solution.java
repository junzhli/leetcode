package self.alg.sorting.insertion_sort;

/**
 * insertion sort
 *
 * time complexity: n^2
 */
public class Solution {
    public int[] insertionSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }

        // >= 2
        for (int i = 0; i < arr.length; i++) {
            int min = i;

            int j = i + 1;
            for (; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            utils.Array.swapValueIntArray(arr, i, min);
        }

        return arr;
    }
}
