package com.leetcode.delete_node_in_a_linked_list;

// such a stupid question, it could cause memory leak
public class Solution {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
