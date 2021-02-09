package com.leetcode.add_two_number_ii;

import java.util.Stack;

public class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // round 2
    // use stack or reverse linked list
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = getNumberInReverse(l1);
        Stack<Integer> stack2 = getNumberInReverse(l2);

        int carry = 0;
        Stack<ListNode> resStack = new Stack<>();

        while (!stack1.empty() || !stack2.empty()) {
            int valueA = stack1.empty() ? 0 : stack1.pop();
            int valueB = stack2.empty() ? 0 : stack2.pop();

            int subTotal = carry + valueA + valueB;
            carry = subTotal / 10;
            resStack.push(new ListNode(subTotal % 10));
        }
        if (carry != 0) {
            resStack.push(new ListNode(carry));
        }

        ListNode res = null;
        ListNode next = null;
        while (!resStack.empty()) {
            ListNode node = resStack.pop();
            if (res == null) {
                res = node;
                next = node;
            } else {
                next.next = node;
                next = next.next;
            }
        }

        return res;
    }

    private Stack<Integer> getNumberInReverse(ListNode node) {
        Stack<Integer> stack = new Stack<>();

        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }

        return stack;
    }

    // will overflow if the sum of two number l1, l2 is greather than max number of int
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        int a1Value = getNumber(l1);
//        int a2Value = getNumber(l2);
//        int resValue = a1Value + a2Value;
//
//        ListNode head = null;
//        ListNode next = null;
//        for (char c: String.valueOf(resValue).toCharArray()) {
//            int nodeValue = c - '0';
//            ListNode node = new ListNode(nodeValue);
//            if (head == null) {
//                head = node;
//                next = head;
//            } else {
//                next.next = node;
//                next = next.next;
//            }
//        }
//
//        return head;
//    }
//
//    private int getNumber(ListNode node) {
//        int res = 0;
//
//        while (node != null) {
//            res = res * 10 + node.val;
//            node = node.next;
//        }
//
//        return res;
//    }
}
