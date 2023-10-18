package com.leetcode.evaluate_reverse_polish_notation;

import java.util.*;

public class Solution {

    public int evalRPN(String[] tokens) {
        ArrayDeque<String> deque = new ArrayDeque<>();
        for (String t: tokens) {
            if (t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/")) {
                Integer b = Integer.valueOf(deque.pop());
                Integer a = Integer.valueOf(deque.pop());
                char tc = t.charAt(0);
                Integer sub = null;
                switch (tc) {
                    case '+':
                        sub = a + b;
                        break;
                    case '-':
                        sub = a - b;
                        break;
                    case '*':
                        sub = a * b;
                        break;
                    case '/':
                        sub = a / b;
                        break;
                }

                deque.push(String.valueOf(sub));
            } else {
                deque.push(t);
            }
        }
        return Integer.valueOf(deque.pop());
    }

    // round 1
    // TBD: Use ArrayDeque
//    public int evalRPN(String[] tokens) {
//        if (tokens.length == 0) {
//            return 0;
//        }
//
//        Set<String> operands = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
//        Stack<String> stack = new Stack<>();
//        for (String token: tokens) {
//            if (operands.contains(token)) {
//                int right, left, subT;
//                right = Integer.parseInt(stack.pop());
//                left = Integer.parseInt(stack.pop());
//                switch (token) {
//                    case "+":
//                        subT = left + right;
//                        break;
//                    case "-":
//                        subT = left - right;
//                        break;
//                    case "*":
//                        subT = left * right;
//                        break;
//                    case "/":
//                        subT = left / right;
//                        break;
//                    default:
//                        throw new IllegalArgumentException("Unexpected operand " + token);
//                }
//                stack.push(String.valueOf(subT));
//                continue;
//            }
//
//            stack.push(token);
//        }
//
//        return Integer.parseInt(stack.pop());
//    }
}
