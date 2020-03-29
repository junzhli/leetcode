package self.alg.sorting.merge_sort;

import com.sun.tools.corba.se.idl.InvalidArgument;

import java.util.Arrays;

public class Solution {
    /**
     * https://pjchender.blogspot.com/2017/09/merge-sort.html
     * Merge sort alg.
     * @param values
     * @return
     *
     * Time complexity: n log n
     * Space complexity:
     */
    public int[] mergeSort(int[] values) {
        if (values.length == 1) {
            return values;
        }

        int mid = (values.length) / 2;
        return sortBeforeMerge(mergeSort(Arrays.copyOfRange(values, 0, mid)), mergeSort(Arrays.copyOfRange(values, mid, values.length)));
    }

    private int[] sortBeforeMerge(int[] arr1, int[] arr2) {
        int[] ret = new int[arr1.length + arr2.length];
        int counter = 0;

        while (arr1.length != 0 || arr2.length != 0) {
            if (arr1.length != 0 && arr2.length != 0) {
                if (arr1[0] <= arr2[0]) {
                    ret[counter] = arr1[0];
                    arr1 = sliceArr(arr1);
                } else {
                    ret[counter] = arr2[0];
                    arr2 = sliceArr(arr2);
                }
            } else if (arr1.length == 0) {
                ret[counter] = arr2[0];
                arr2 = sliceArr(arr2);
            } else {
                ret[counter] = arr1[0];
                arr1 = sliceArr(arr1);
            }
            counter++;
        }

        return ret;
    }

    private int[] sliceArr(int[] arr) {
        if (arr.length == 0) {
            throw new RuntimeException("Empty arr");
        }

        if (arr.length == 1) {
            return new int[]{};
        } else {
            return Arrays.copyOfRange(arr, 1, arr.length);
        }
    }
}
