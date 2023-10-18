package com.leetcode.odd_even_linked_list;

public class Solution {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // round 2 (similar to round 1, but beautified
    // t.c. o(n)
    // s.c. o(1)
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode oddHead = head;
        ListNode evenHead = head.next;

        ListNode oddCurr = oddHead;
        ListNode evenCurr = evenHead;
        boolean odd = true;
        ListNode oddTail = null;
        while (oddCurr != null && evenCurr != null) {
            if (odd) {
                if (evenCurr.next == null) {
                    oddTail = oddCurr;
                }
                oddCurr.next = evenCurr.next;
                oddCurr = oddCurr.next;
                odd = false;
            } else {
                if (oddCurr.next == null) {
                    oddTail = oddCurr;
                }
                evenCurr.next = oddCurr.next;
                evenCurr = evenCurr.next;
                odd = true;
            }
        }

        if (oddTail != null) {
            oddTail.next = evenHead;
        }

        return oddHead;
    }

    // round 1
//    public ListNode oddEvenList(ListNode head) {
//        if (head == null) {
//            return null;
//        }
//
////        ListNode oddS = head;
//        ListNode evenHead = head.next;
//        ListNode oddNode = head;
//        ListNode evenNode = head.next;
//
//        while (evenNode != null && evenNode.next != null) {
//            oddNode.next = evenNode.next;
//            oddNode = oddNode.next;
//            evenNode.next = oddNode.next;
//            evenNode = evenNode.next;
//        }
//
//        oddNode.next = evenHead;
//        return head;
//    }
}
