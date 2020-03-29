package com.leetcode.evaluate_reverse_polish_notation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 0) {
            return 0;
        }

        Set<String> operands = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        Stack<String> stack = new Stack<>();
        for (String token: tokens) {
            if (operands.contains(token)) {
                int right, left, subT;
                right = Integer.parseInt(stack.pop());
                left = Integer.parseInt(stack.pop());
                switch (token) {
                    case "+":
                        subT = left + right;
                        break;
                    case "-":
                        subT = left - right;
                        break;
                    case "*":
                        subT = left * right;
                        break;
                    case "/":
                        subT = left / right;
                        break;
                    default:
                        throw new IllegalArgumentException("Unexpected operand " + token);
                }
                stack.push(String.valueOf(subT));
                continue;
            }

            stack.push(token);
        }

        return Integer.parseInt(stack.pop());
    }
}
