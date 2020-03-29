package com.leetcode.sort_list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void sortList() {
        Solution sol = new Solution();
        Solution.ListNode node = new Solution.ListNode(10);
        Solution.ListNode node2 = new Solution.ListNode(30);
        Solution.ListNode node3 = new Solution.ListNode(3);
        Solution.ListNode node4 = new Solution.ListNode(4);
        Solution.ListNode node5 = new Solution.ListNode(20);
        Solution.ListNode node6 = new Solution.ListNode(5);
        appendNode(node, node2);
        appendNode(node2, node3);
        appendNode(node3, node4);
        appendNode(node4, node5);
        appendNode(node5, node6);

        printDoublyLinkedList(node); // before sort
        node = sol.sortList(node);
        printDoublyLinkedList(node); // after sort
    }

    private void appendNode(Solution.ListNode first, Solution.ListNode second) {
        first.next = second;
//        second.prev = first;
    }

    private void printDoublyLinkedList(Solution.ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}