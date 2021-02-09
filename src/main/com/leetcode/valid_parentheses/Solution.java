package com.leetcode.valid_parentheses;

import java.util.*;

public class Solution {
    // round 2
    // last in first out (lifo)
    // stack would be better
    // time complexity: o(n)
    // space complexity: o(n) (for worst case)
    public boolean isValid(String s) {
        List<Character> leftBrackets = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char chr = s.charAt(i);
            if (chr == '(' || chr == '{' || chr == '[') {
                leftBrackets.add(chr);
            } else {
                if (leftBrackets.size() == 0) { // **** no left brackets, return false
                    return false;
                }

                if (chr == ')' && leftBrackets.get(leftBrackets.size() - 1) == '(') {
                    leftBrackets.remove(leftBrackets.size() - 1);
                } else if (chr == '}' && leftBrackets.get(leftBrackets.size() - 1) == '{') {
                    leftBrackets.remove(leftBrackets.size() - 1);
                } else if (chr == ']' && leftBrackets.get(leftBrackets.size() - 1) == '[') {
                    leftBrackets.remove(leftBrackets.size() - 1);
                } else {
                    return false;
                }
            }
        }

        if (leftBrackets.size() != 0) { // **** still left brackets in leftBrackets, return false
            return false;
        }
        return true;
    }


    // round 1
//    public boolean isValid(String s) {
//        Stack<String> stack = new Stack<>();
//        HashSet<String> ltSet = new HashSet<>();
//        ltSet.add("(");
//        ltSet.add("{");
//        ltSet.add("[");
//        HashMap<String, String> hashSet = new HashMap<>();
//        hashSet.put("(", ")");
//        hashSet.put("{", "}");
//        hashSet.put("[", "]");
//
//        if (s.length() == 1) {
//            return false;
//        }
//
//        while (s.length() != 0) {
//            String chr = String.valueOf(s.charAt(0));
//
//            if (ltSet.contains(chr)) {
//                stack.push(chr);
//            } else {
//                if (stack.empty()) {
//                    return false;
//                }
//                String ltChr = stack.pop();
//                if (!hashSet.get(ltChr).equals(chr)) {
//                    return false;
//                }
//            }
//
//            s = s.substring(1);
//        }
//
//        return stack.empty();
//    }

}
