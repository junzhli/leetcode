package com.leetcode.remove_nth_node_from_end_of_list;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // time complexity: big o (n)

        /**
         * reverse the linked-list, and access the node being deleted by iterating over the linked-list
         * during the iteration, keep the pointer of its prev and next so that we can assign its next to its prev
         * reverse it back and return
         */

        ListNode reversed = reverse(head);
        if (n == 1) {
            return reverse(reversed.next);
        }

        ListNode prev = null;
        ListNode current = reversed;
        ListNode next = null;
        for (int i = 0; i < n; i++) {
            if (i == n - 2) {
                prev = current;
            }
            if (i == n - 1) {
                next = current.next;
            }
            current = current.next;
        }
        prev.next = next;

        return reverse(reversed);
    }

    private ListNode reverse(ListNode node) {
        ListNode current = null;
        ListNode next = null;
        ListNode prev = null;
        current = node;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;

        }
        return prev;
    }

//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        // time complexity: > big o (n)
//        List<ListNode> arr = new ArrayList<>();
//
//        ListNode iterationNode = head;
//        arr.add(iterationNode);
//        int index = 0;
//        while (iterationNode.next != null) {
//            iterationNode = iterationNode.next;
//            arr.add(iterationNode);
//            index += 1;
//        }
//        int length = index + 1;
//
//        int target = length - n;
//        if (target - 1 < 0) {
//            ListNode tarNode = arr.get(target);
//            return tarNode.next;
//        }
//        ListNode preTarNode = arr.get(target - 1);
//
//        if (target + 1 >= length) {
//            preTarNode.next = null;
//        } else {
//            ListNode nextTarNode = arr.get(target + 1);
//            preTarNode.next = nextTarNode;
//        }
//
//        return head;
//    }
}
