package com.leetcode.valid_parentheses;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class Solution {

    public boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        HashSet<String> ltSet = new HashSet<>();
        ltSet.add("(");
        ltSet.add("{");
        ltSet.add("[");
        HashMap<String, String> hashSet = new HashMap<>();
        hashSet.put("(", ")");
        hashSet.put("{", "}");
        hashSet.put("[", "]");

        if (s.length() == 1) {
            return false;
        }

        while (s.length() != 0) {
            String chr = String.valueOf(s.charAt(0));

            if (ltSet.contains(chr)) {
                stack.push(chr);
            } else {
                if (stack.empty()) {
                    return false;
                }
                String ltChr = stack.pop();
                if (!hashSet.get(ltChr).equals(chr)) {
                    return false;
                }
            }

            s = s.substring(1);
        }

        return stack.empty();
    }

}
