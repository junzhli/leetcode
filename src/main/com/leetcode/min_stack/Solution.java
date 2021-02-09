package com.leetcode.min_stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class MinStack {

    // round 2
    // use arraylist
    private List<Integer> min;
    private List<Integer> stack;
    /** initialize your data structure here. */
    public MinStack() {
        min = new ArrayList<>();
        stack = new ArrayList<>();
    }

    public void push(int x) {
        stack.add(x);
        if (min.size() == 0) {
            min.add(x);
            return;
        }

        if (x <= min.get(min.size() - 1)) {
            min.add(x);
        }
    }

    public void pop() {
        if (stack.get(stack.size() - 1).equals(min.get(min.size() - 1))) {
            min.remove(min.size() - 1);
        }
        stack.remove(stack.size() - 1);
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return min.get(min.size() - 1);
    }


    // round 1
    // use linkedlist
//    private class LinkNode {
//        int val;
//        LinkNode next;
//        LinkNode (int val) {
//            this.val = val;
//        }
//    }
//
//    /** initialize your data structure here. */
//    private LinkNode root;
//    private LinkNode min;
//    public MinStack() {
//        root = null;
//        min = null;
//    }
//
//    public void push(int x) {
//        LinkNode newNode = new LinkNode(x);
//        LinkNode newMinNode = new LinkNode(x);
//        if (root == null) {
//            root = newNode;
//            min = newMinNode;
//            return;
//        }
//
//        newNode.next = root;
//        root = newNode;
//        if (x <= min.val) { // *
//            newMinNode.next = min;
//            min = newMinNode;
//        }
//    }
//
//    public void pop() {
//        if (root == null) {
//            return;
//        }
//
//        if (root.next == null) {
//            root = null;
//            min = null;
//            return;
//        }
//
//        if (root.val == min.val) { // *
//            min = min.next;
//        }
//        root = root.next;
//    }
//
//    public int top() {
//        if (root == null) {
//            return 0;
//        }
//
//        return root.val;
//    }
//
//    public int getMin() {
//        if (root == null) {
//            return 0;
//        }
//
//        return min.val;
//    }
}

