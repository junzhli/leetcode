package com.leetcode.pascal_s_triangle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/submissions/
 * Dynamic programming
 *
 * t.c numRow^2
 * s.c numRow^2
 */
public class Solution {

    // round 2
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<>();
        if (numRows == 0) {
            return res;
        }

        List<Integer> first = new LinkedList<>();
        first.add(1);
        res.add(first);
        if (numRows == 1) {
            return res;
        }

        List<Integer> second = new LinkedList<>();
        second.add(1);
        second.add(1);
        res.add(second);
        if (numRows == 2) {
            return res;
        }

        for (int i = 3; i <= numRows; i++) {
            int lefts = i - 2;
            List<Integer> more = new LinkedList<>();
            List<Integer> prev = res.get(i - 2);
            more.add(1);
            for (int j = 0; j < lefts; j++) {
                int added = prev.get(j) + prev.get(j + 1);
                more.add(added);
            }
            more.add(1);
            res.add(more);
        }

        return res;
    }

    // round 1
//    public List<List<Integer>> generate(int numRows) {
//        List<List<Integer>> res = new ArrayList<>();
//        if (numRows == 0) {
//            return res;
//        }
//
//        List<Integer> zLevel = new ArrayList<>();
//        zLevel.add(1);
//        res.add(zLevel);
//        if (numRows == 1) {
//            return res;
//        }
//        List<Integer> z2Level = new ArrayList<>();
//        z2Level.add(1);
//        z2Level.add(1);
//        res.add(z2Level);
//        if (numRows == 2) {
//            return res;
//        }
//
//        for (int i = 2; i < numRows; i++) {
//            List<Integer> xLevel = new ArrayList<>();
//            xLevel.add(1);
//            List<Integer> prev = res.get(i - 1);
//            int x = 0;
//            int y = 1;
//            while (y < prev.size()) {
//                int newEle = prev.get(x) + prev.get(y);
//                xLevel.add(newEle);
//                x = y;
//                y++;
//            }
//            xLevel.add(1);
//            res.add(xLevel);
//        }
//        return res;
//    }
}
