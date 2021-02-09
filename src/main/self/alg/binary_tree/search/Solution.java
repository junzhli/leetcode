package self.alg.binary_tree.search;

import java.util.Arrays;

// binary search article: https://hackernoon.com/binary-search-in-detail-914944a1434a
public class Solution {

    public int binarySearch(int[] arr, int target) {
        if (arr.length == 0) {
            return -1;
        }

        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;
        while (left <= right) { // !!! ===
            int mid = (left + right) / 2; // !!! (left + right) / 2 --> oven not working properly.
            // when elements is oven --> (left + right) / 2 goes to lower mid
            // best way:
            //   lower-mid: left + (right - left) / 2
            //   high-mid: left + (right - left + 1) / 2
            if (target < arr[mid]) {
                right = mid - 1;
            } else if (target > arr[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
