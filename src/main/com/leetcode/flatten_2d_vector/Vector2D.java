package com.leetcode.flatten_2d_vector;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// premium 251, lintcode: https://www.lintcode.com/problem/flatten-2d-vector/discuss
public class Vector2D implements Iterator<Integer> {
    private List<List<Integer>> vec2d;
    private int x;
    private int y;


    public Vector2D(List<List<Integer>> vec2d) {
        // Initialize your data structure here
        this.vec2d = vec2d;
        this.x = 0;
        this.y = 0;
    }

    @Override
    public Integer next() {
        // Write your code here
        while (true) {
            if (x >= vec2d.size()) {
                break;
            }

            if (y >= vec2d.get(x).size()) {
                x++;
                y = 0;
                continue;
            }

            return vec2d.get(x).get(y++);
        }

        return null;
    }

    @Override
    public boolean hasNext() {
        while (x < vec2d.size()) {
            if (y >= vec2d.get(x).size()) {
                x++;
                y = 0;
                continue;
            }

            return true;
        }
        return false;
    }

    @Override
    public void remove() {}
}

//public class Vector2D implements Iterator<Integer> {
//    List<Integer> vecFlatten;
//    int pointer;
//    public Vector2D(List<List<Integer>> vec2d) {
//        // Initialize your data structure here
//        vecFlatten = new ArrayList<>();
//        for (List<Integer> v: vec2d) {
//            vecFlatten.addAll(v);
//        }
//        if (vecFlatten.size() == 0) {
//            pointer = -1;
//        } else {
//            pointer = 0;
//        }
//    }
//
//    @Override
//    public Integer next() {
//        // Write your code here
//        if (pointer == -1) {
//            return null;
//        }
//        return vecFlatten.get(pointer++);
//    }
//
//    @Override
//    public boolean hasNext() {
//        // Write your code here
//        return pointer != -1 && pointer != vecFlatten.size();
//    }
//
//    @Override
//    public void remove() {}
//}
