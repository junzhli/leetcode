package com.leetcode.basic_calculator_ii;

import java.util.Stack;

public class Solution {
    // refer to https://leetcode.com/problems/basic-calculator-ii/discuss/63003/Share-my-java-solution
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int subTotal = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                subTotal = subTotal * 10 + (c - '0');
            }

            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                switch (sign) {
                    case '+':
                        stack.push(subTotal);
                        break;
                    case '-':
                        stack.push(-subTotal);
                        break;
                    case '*':
                        stack.push(stack.pop() * subTotal);
                        break;
                    case '/':
                        stack.push(stack.pop() / subTotal);
                        break;
                }

                sign = c;
                subTotal = 0;
            }
        }

        int res = 0;
        for (Integer num: stack) {
            res += num;
        }
        return res;
    }
}
