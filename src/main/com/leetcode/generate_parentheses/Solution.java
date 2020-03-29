package com.leetcode.generate_parentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private int _n;
    private List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        _n = n;
        _generateParenthesis("", 0, 0);

//        for (int x = 0; x < result.size(); x++) {
//            System.out.println(result.get(x));
//        }
        return result;
    }

    private void _generateParenthesis(String str, int start, int end) {
        if (str.length() == _n * 2 && start == _n && end == _n) {
            result.add(str);
            return;
        }

        if (start > end) {
            _generateParenthesis(str + ")", start, end + 1);
        }

        if (start < _n) {
            _generateParenthesis(str + "(", start + 1, end);
        }
    }
}
