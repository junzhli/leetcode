package com.leetcode.merge_k_sorted_lists;

public class Solution {
    // https://leetcode.com/problems/merge-k-sorted-lists/description/
    // https://leetcode.com/problems/merge-k-sorted-lists/solutions/3286058/image-explanation-5-methods-divide-conquer-priority-queue-complete-intuition/
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return divideAndConquer(lists, 0, lists.length - 1);
    }

    private ListNode divideAndConquer(ListNode[] lists, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return lists[start];
        }

        int mid = start + (end - start) / 2;
        var list1 = divideAndConquer(lists, start, mid);
        var list2 = divideAndConquer(lists, mid + 1, end);

        return merge(list1, list2);
    }

    // template!!!! merge two sorted array
    private ListNode merge(ListNode l1, ListNode l2) {
        // !! use dummy node to handle the condition where (head == curr) instead
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        // all sorted lists, using two pointers approach
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                //curr = l1; replaced by curr = curr.next
                l1 = l1.next;
            } else {
                curr.next = l2;
                //curr = l2; replaced by curr = curr.next
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if (l1 != null) {
            curr.next = l1;
        }
        if (l2 != null) {
            curr.next = l2;
        }
        return head.next;
    }
}
