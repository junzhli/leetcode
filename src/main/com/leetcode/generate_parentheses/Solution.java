package com.leetcode.generate_parentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        _generateParenthesis("", 0, 0, n);

//        for (int x = 0; x < result.size(); x++) {
//            System.out.println(result.get(x));
//        }
        return result;
    }

    private void _generateParenthesis(String str, int open, int close, int n) {
        if (str.length() == n * 2) {
            result.add(str);
            StringBuilder a = new StringBuilder();
            return;
        }

        if (open > close) {
            _generateParenthesis(str + ")", open, close + 1, n);
        }

        if (open < n) {
            _generateParenthesis(str + "(", open + 1, close, n);
        }
    }
}
