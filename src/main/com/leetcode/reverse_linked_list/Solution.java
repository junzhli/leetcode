package com.leetcode.reverse_linked_list;

public class Solution {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    /**
     * Use recursion
     */
    private ListNode ret;
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        helper(null, head);
        return ret;
    }

    private ListNode helper(ListNode prev, ListNode curr) {
        if (curr.next == null) {
            curr.next = prev;
            ret = curr;
            return prev;
        }

        ListNode r = helper(curr, curr.next);
        r.next = prev;
        return prev;
    }

    /**
     * Use iteration
     */
//    public ListNode reverseList(ListNode head) {
//        ListNode ret = null;
//        while (head != null) {
//            ListNode next = head.next;
//            head.next = ret;
//            ret = head;
//            head = next;
//        }
//        return ret;
//    }
}
