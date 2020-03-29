package com.leetcode.sort_list;

public class Solution {
    public static class ListNode {
        int val;
//        ListNode prev;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // explicitly split dll into two dlls of half size
        ListNode second = split(head);
        head = sortList(head);
        second = sortList(second);

        // merge again (includes sorting)
        return merge(head, second);
    }

    private ListNode merge(ListNode first, ListNode second) {
        if (first == null) {
            return second;
        }

        if (second == null) {
            return first;
        }

        // pick smaller element to be the first element and concentrate with others (after merged)
        if (first.val < second.val) {
            first.next = merge(first.next, second); // **
//            first.next.prev = first;
//            first.prev = null;
            return first;
        } else {
            second.next = merge(first, second.next); // **
//            second.next.prev = second;
//            second.prev = null;
            return second;
        }
    }

    private ListNode split(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode ret = slow.next;
        slow.next = null;
        return ret;
    }


}
