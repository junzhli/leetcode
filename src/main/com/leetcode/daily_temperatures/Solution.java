package com.leetcode.daily_temperatures;

import java.util.Stack;

public class Solution {
    public int[] dailyTemperatures(int[] T) {
        int top = -1;
        int[] stack = new int[T.length]; // !!! can be replaced with "stack"
        int[] ret = new int[T.length];

        for (int i = 0; i < T.length; i++) {
            while (top > -1 && T[stack[top]] < T[i]) {
                int poppedIndex = stack[top--];
                ret[poppedIndex] = i - poppedIndex;
            }
            stack[++top] = i;
        }

        return ret;
    }


//    /**
//     * 題目：要等幾天會得到比較高的溫度？
//     *
//     * For example, given the list of temperatures T = [28, 29, 30, 26, 24, 27, 31, 28]
//     * your output should be [1, 1, 4, 2, 1, 1, 0, 0].
//     */
//    Stack<Integer> stack = new Stack<>();
//
//    public int[] solution(int[] temperatures) {
//        int[] res = new int[temperatures.length];
//
//        for (int i = 0; i < temperatures.length; i++) {
//            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
//                int poppedIndex = stack.pop();
//                res[poppedIndex] = i - poppedIndex;
//            }
//
//            stack.push(i);
//        }
//        return res;
//    }
}
