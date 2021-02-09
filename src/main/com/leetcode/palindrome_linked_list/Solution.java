package com.leetcode.palindrome_linked_list;

public class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        // reverse right half, return head from right half
        //// split
        //// reverse
        //// return right half head
        ListNode rightHead = splitAndReverseRightHalf(head);
        // compare left one with right one
        //// iterate through list node from each head
        //// compare left node with right node
        //// if left node != right node, return false
        //// continue until its end of node, return true
        while (rightHead != null) {
            if (head.val != rightHead.val) {
                return false;
            }
            head = head.next;
            rightHead = rightHead.next;
        }
        return true;
    }

    // return right head
    private ListNode splitAndReverseRightHalf(ListNode left) {
        ListNode slow = left, fast = left;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // for oven number of nodes
        if (fast.next != null) {
            fast = fast.next;
            slow = slow.next; // starting point to reverse the following nodes e.g. 1, 2, 2 (slow-changed), 1 (fast-changed)
        }

        // odd number of nodes
        // e.g. 1, 2 (slow), 2 (fast)

        ListNode prev = null;
//        slow = slow.next; // starting point to reverse the following nodes
        while (slow != null) {
            ListNode nxt = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nxt;
        }

        // oven: 1->2->null, 1'->2'->null (1,2,2',1')
        // odd: 1->2->null, 1'->2->null (1,2,1')
        return fast;
    }
}
