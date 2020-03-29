package com.leetcode.min_stack;

class MinStack {

    private class LinkNode {
        int val;
        LinkNode next;
        LinkNode (int val) {
            this.val = val;
        }
    }

    /** initialize your data structure here. */
    private LinkNode root;
    private LinkNode min;
    public MinStack() {
        root = null;
        min = null;
    }

    public void push(int x) {
        LinkNode newNode = new LinkNode(x);
        LinkNode newMinNode = new LinkNode(x);
        if (root == null) {
            root = newNode;
            min = newMinNode;
            return;
        }

        newNode.next = root;
        root = newNode;
        if (x <= min.val) { // *
            newMinNode.next = min;
            min = newMinNode;
        }
    }

    public void pop() {
        if (root == null) {
            return;
        }

        if (root.next == null) {
            root = null;
            min = null;
            return;
        }

        if (root.val == min.val) { // *
            min = min.next;
        }
        root = root.next;
    }

    public int top() {
        if (root == null) {
            return 0;
        }

        return root.val;
    }

    public int getMin() {
        if (root == null) {
            return 0;
        }

        return min.val;
    }
}

