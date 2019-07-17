package com.leetcode.container_with_most_water;

public class Solution {
    public int maxArea(int[] height) {
//        int length = height.length;
//        int max = 0;
//
//        for (int i = 0; i < length - 1; i++) {
//            for (int j = 1; j < length; j++) {
//                int left = height[i];
//                int right = height[j];
//                int vertical = (left > right) ? right : left;
//                int horizontal = j - i;
//                int area = vertical * horizontal;
//                if (area > max) {
//                    max = area;
//                }
//            }
//        }
//
//        return max;
        // big o (n^2) time
        // big o (1) space

        int length = height.length;
        int max = 0;

        int i = 0;
        int j = length - 1;

        while (j - i > 0) {
            int left = height[i];
            int right = height[j];
            int h = (left > right) ? right : left;
            int v = j - i;
            int area = h * v;
            if (area > max) {
                max = area;
            }

            if (left > right) {
                j -= 1;
            } else {
                i += 1;
            }
        }

        return max;

        // big o n
        // big o 1
    }
}
