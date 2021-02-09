package self.alg.sorting.merge_sort;

import com.sun.tools.corba.se.idl.InvalidArgument;

import java.util.Arrays;

public class Solution {
    // round 2
//    class GfG
//    {
//        // Merges two subarrays of arr[].  First subarray is arr[l..m]
//        // Second subarray is arr[m+1..r]
//        void merge(int arr[], int l, int m, int r)
//        {
//            if (l == m || m == r) {
//                return;
//            }
//
//            // Your code here
//            int mid = (l + m) / 2;
//            int mid2 = (m + r) / 2;
//            merge(arr, l, mid, m - 1);
//            merge(arr, m, mid2, r);
//
//            arr = mergeArr(arr, l, m, r);
//        }
//
//        int[] mergeArr(int[] arr, int l, int m, int r) {
//            int[] res = new int[r - l + 1];
//            int[] arr1 = Arrays.copyOfRange(arr, l, m);
//            int[] arr2 = Arrays.copyOfRange(arr, m, r + 1);
//
//            int i = 0;
//            int j = 0;
//            int p = 0;
//            while (i < arr1.length && j < arr2.length) {
//                if (arr[i] <= arr[j]) {
//                    res[p++] = arr[i++];
//                } else {
//                    res[p++] = arr[j++];
//                }
//            }
//
//            while (i < arr1.length) {
//                res[p++] = arr[i++];
//            }
//
//            while (j < arr2.length) {
//                res[p++] = arr[j++];
//            }
//
//            return res;
//        }
//
//
//    }
//
// /* This method is present in a class other than GfG class .
//static void mergeSort(int arr[], int l, int r)
// {
//    GfG g = new GfG();
//    if (l < r)
//   {
//        int m = (l+r)/2;
//        mergeSort(arr, l, m);
//        mergeSort(arr , m+1, r);
//        g.merge(arr, l, m, r);
//    }
//}*/



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
