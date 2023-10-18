package com.leetcode.largest_rectangle_in_histogram;

import java.util.ArrayDeque;

public class Solution {
     class Height {
        int height;
        int index;

        Height(int height, int index) {
            this.height = height;
            this.index = index;
        }
    }

    public int largestRectangleArea(int[] heights) {
        // https://www.youtube.com/watch?v=zx5Sw9130L0
        // two pointers approach
        int i = 0;
        ArrayDeque<Height> queue = new ArrayDeque<>();
        int max = 0;

        while (i < heights.length) {
            int height = heights[i];
            max = Math.max(max, heights[i]);
            if (queue.isEmpty()) {
                queue.push(new Height(height, i));
                i++;
                continue;
            }

            Height prevHeight = queue.peek();
            if (prevHeight.height <= height) {
                // int j = i - 1;
                // while (j >= 0 && heights[j] == height) {
                //     j--;
                // }
                queue.push(new Height(height, i));
            } else {
                int j = i;
                while (!queue.isEmpty() && queue.peek().height > heights[i]) {
                    Height poped = queue.poll();
                    j = poped.index;
                    max = Math.max(max, poped.height * (i - poped.index));
                }

                // int j = i - 1;
                // while (j >= 0 && heights[j] >= height) {
                //     j--;
                // }
                queue.push(new Height(height, j));
            }

            i++;
        }

        while (!queue.isEmpty()) {
            Height poped = queue.poll();
            int j = poped.index;
            // while (j < heights.length && heights[j] >= poped.height) {
            //     j++;
            // }
            max = Math.max(max, poped.height * (heights.length - poped.index));
        }

        return max;
    }
}
