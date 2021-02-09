package com.leetcode.trapping_rain_water;

public class Solution {

    // round 2
//    public int trap(int[] height) {
//        int res = 0;
//
//        for (int i = 0; i < height.length - 1;) {
//            int left = height[i];
//            int j = i + 1;
//            int lower = i;
//            int lowerHeight = left;
//            boolean lh = false;
//            while (j < height.length) {
//                int right = height[j];
//                if (right <= lowerHeight) {
//                    lower = j;
//                    lowerHeight = height[lower];
//                }
//
//                if (right >= left) {
//                    res += calculate(height, i, j);
//                    i = j;
//                    lh = true;
//                    break;
//                }
//
//                j++;
//            }
//
//            if (!lh) {
//                int subtotal = calculate(height, i, lower);
//                if (subtotal == 0) {
//                    i++;
//                } else {
//                    i = lower;
//                }
//                res += subtotal;
//            }
//        }
//
//        return res;
//    }
//
//    private int calculate(int[] height, int left, int right) {
//        int res = 0;
//        int h = Math.min(height[left], height[right]);
//        for (int i = left + 1; i < right; i++) {
//            int subtract = h - height[i];
//            if (subtract < 0) {
//                continue;
//            }
//            res += h - height[i];
//        }
//        return res;
//    }

    // round 1
    // t.c. one pass, big o n
    // s.c. big o 1, in constant space
    // https://leetcode.com/problems/trapping-rain-water/
    // https://leetcode.com/problems/trapping-rain-water/discuss/17386/Sharing-my-Java-code%3A-O(n)-time-O(1)-space
    public int trap(int[] A) {
        // length < 3, it would be impossible to hold water
        if (A.length < 3) {
            return 0;
        }

        // find the highest of left and right edges which can hold water
        // -->[hold water]<--, (as left/right side of edges can't hold water as mentioned in question)
        int i = 0, j = A.length - 1;
        while (i < j && A[i] <= A[i + 1]) {
            i++;
        }
        while (i < j && A[j] <= A[j - 1]) {
            j--;
        }

        int res = 0;
        // start fill water as follow:
        while (i < j) {
            int left = A[i];
            int right = A[j];
            // always process from smaller edge to handle left/right edge sink together e.g. 4,2,3
            if (left < right) {
                while (i < j && left >= A[++i]) { // fill water from left to right until the height of i is greater than left edge
                    res += left - A[i];
                }
            } else { // A[i] > A[j]
                while (i < j && right >= A[--j]) { // fill water from right to left until the height of i is greater than right edge
                    res += right - A[j];
                }
            }
        }

        return res;
    }
}
