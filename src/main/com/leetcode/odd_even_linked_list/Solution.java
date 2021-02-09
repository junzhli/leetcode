package com.leetcode.odd_even_linked_list;

public class Solution {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

//        ListNode oddS = head;
        ListNode evenHead = head.next;
        ListNode oddNode = head;
        ListNode evenNode = head.next;

        while (evenNode != null && evenNode.next != null) {
            oddNode.next = evenNode.next;
            oddNode = oddNode.next;
            evenNode.next = oddNode.next;
            evenNode = evenNode.next;
        }

        oddNode.next = evenHead;
        return head;
    }
}
