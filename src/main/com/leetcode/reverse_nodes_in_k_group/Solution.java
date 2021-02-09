package com.leetcode.reverse_nodes_in_k_group;

public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * The simple idea behind the solution is to divide m group with k nodes, and keep reference for each last node and first node of
     * current processed (reversed) link list to be linked after dividing the next one
     *
     * time complexity: o(n)
     * space complexity: o(1)
     */

    private int count; // counter for each grouping iteration to know numbers of reversed node been processed
    private boolean first; // helper's var to get the head of the returned linked list
    private ListNode res; // final result after invoking 'reverseKGroup'
    private ListNode tmpHead; // last node of previous linked list, linking to current new head of the group (reversed) link list
    private ListNode next; // starting node of each grouping iteration

    /** k = 2
     *   -1 (dummy node as tmpHead), linking to next head of reversed link list (or not reversed link list)
     *
     *
     *    1   ->   2   ->   3   ->   4   ->   5
     *
     *
     *    1   <-   2        3   ->   4   ->   5
     *
     *             -1
     *             |
     *    1   <-   2        3   ->   4   ->   5
     *
     *             -1
     *             |
     *    1   <-   2        3   <-   4        5
     *
     *            -1
     *            |
     *   1   <-   2        3   <-   4        5
     *   |                          |
     *    -> -> -> -> -> -> -> -> ->
     *
     *
     *            -1        -> -> -> -> -> ->
     *            |         |                 |
     *   1   <-   2        3   <-   4        5
     *   |                          |
     *    -> -> -> -> -> -> -> -> ->
     *
     *
     *
     * @param head
     * @param k
     * @return
     */

    public ListNode reverseKGroup(ListNode head, int k) {
        tmpHead = new ListNode(-1); // dummy node
        first = true;
        res = head;
        next = head;
        while (next != null) {
            ListNode lastNext = next;

            reverseKNode(null, next, k);

            tmpHead = lastNext;

            count = 0;
        }

        return res;
    }

    private ListNode reverseKNode(ListNode prev, ListNode curr, int k) {
        if (curr == null) {
            return null;
        }

        if (++count == k) {
            if (first) {
                res = curr;

                first = false;
            }

            tmpHead.next = curr; // link previous node to current node (head, new head)

            next = curr.next;

            curr.next = prev;
            return prev;
        }

        ListNode r = reverseKNode(curr, curr.next, k);
        if (r == null) {
            tmpHead.next = curr; // link previous node to current node (head, original head)

            next = null;

            return null;
        }

        r.next = prev;
        return prev;
    }
}
