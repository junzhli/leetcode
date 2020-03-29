package com.leetcode.swap_nodes_in_pairs;

public class Solution {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        /**
         * head -> head.next -> head.next.next
         * head.next (head') -> head (head'.next) -> swapPairs(head.next.next)
         * use recursion to iterate over the node list until nullity is found
         */
        ListNode res = head.next;
        head.next = swapPairs(head.next.next);
        res.next = head;
        return res;
    }
}
