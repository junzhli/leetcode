package com.leetcode.reverse_nodes_in_k_group;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void reverseKGroup() {
        Solution sol = new Solution();

        Solution.ListNode node1 = new Solution.ListNode(1);
        Solution.ListNode node2 = new Solution.ListNode(2);
        Solution.ListNode node3 = new Solution.ListNode(3);
        Solution.ListNode node4 = new Solution.ListNode(4);
        Solution.ListNode node5 = new Solution.ListNode(5);
        Solution.ListNode node6 = new Solution.ListNode(6);
        Solution.ListNode node7 = new Solution.ListNode(7);
        Solution.ListNode node8 = new Solution.ListNode(8);
        Solution.ListNode node9 = new Solution.ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;

        Solution.ListNode res = sol.reverseKGroup(node1, 5);
        traverseNodes(res);
    }

    private void traverseNodes (Solution.ListNode head) {
        StringBuilder str = new StringBuilder();
        boolean first = true;
        while (head != null) {
            if (first) {
                first = false;
            } else {
                str.append(" --> ");
            }
            str.append(head.val);
            head = head.next;
        }
        System.out.println(str.toString());
    }
}