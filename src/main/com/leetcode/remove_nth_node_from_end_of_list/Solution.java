package com.leetcode.remove_nth_node_from_end_of_list;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // round 2.1
    // time complexity: o(n)
    // space complexity: o(1)
    // one-pass
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // add dummy node to handle case where n = its head
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        // Advances the first pointer so that the gap between first and second is n nodes apart.
        for (int i = 0; i < n; i++) { // ** i <= n, looping 2 times
            first = first.next;
        }

        // Shift right both first and second pointers (Move the first pointer to end), maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // now second pointer is before the deletion node
        second.next = second.next.next;
        return dummy.next;
    }

    // round 2
    // two pass with two pointers
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        // use two-pointer to traverse through linked list once. get two pointers target either middle and last one
//        // with this pass, we can get the length and find out the one we have to move out of linked list
//        // choose either head, middle or last to help move it out.
//
//        // case by case length = 1 or 0;
//        if (head == null || head.next == null) {
//            return null;
//        }
//
//        // case by case length = 2;
//        if (head.next.next == null) {
//            if (n == 0) {
//                head.next = null;
//                return head;
//            } else {
//                // n == 1
//                head = head.next;
//                return head;
//            }
//        }
//
//        // case by case length >= 3;
//
//        // get its length of list node
//        // the result in counter is the length in half
//        // must detect its length is even or odd
//        ListNode middle = head.next;
//        ListNode last = head.next.next;
//        int counter = 1;
//        while (last != null && last.next != null) {
//            counter++;
//            middle = middle.next;
//            last = last.next.next;
//        }
//
//        // (counter >= n) after/at the middle position : before the middle position
//        int i = (counter >= n) ? counter : n - counter;
//        ListNode prev = null;
//        ListNode curr = (counter >= n) ? middle : head;
//        while (i <= counter - n) {
//            prev = curr;
//            curr = curr.next;
//            i++;
//        }
//        prev.next = curr.next;
//        curr.next = null;
//        return head;
//    }

    // round 1
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        // time complexity: big o (n)
//
//        /**
//         * reverse the linked-list, and access the node being deleted by iterating over the linked-list
//         * during the iteration, keep the pointer of its prev and next so that we can assign its next to its prev
//         * reverse it back and return
//         */
//
//        ListNode reversed = reverse(head);
//        if (n == 1) {
//            return reverse(reversed.next);
//        }
//
//        ListNode prev = null;
//        ListNode current = reversed;
//        ListNode next = null;
//        for (int i = 0; i < n; i++) {
//            if (i == n - 2) {
//                prev = current;
//            }
//            if (i == n - 1) {
//                next = current.next;
//            }
//            current = current.next;
//        }
//        prev.next = next;
//
//        return reverse(reversed);
//    }
//
//    private ListNode reverse(ListNode node) {
//        ListNode current = null;
//        ListNode next = null;
//        ListNode prev = null;
//        current = node;
//        while (current != null) {
//            next = current.next;
//            current.next = prev;
//            prev = current;
//            current = next;
//
//        }
//        return prev;
//    }


//    ========
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
