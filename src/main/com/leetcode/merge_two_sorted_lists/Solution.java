package com.leetcode.merge_two_sorted_lists;

public class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // round 2.1
    // recursive
    // time complexity: o(n)
    // space complexity: o(1)
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    // round 2
    // non-recursive, iteration
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode first = null;
//        ListNode curr = null;
//        while (l1 != null && l2 != null) {
//            if (l1.val > l2.val) {
//                ListNode nextNode = new ListNode(l2.val);
//                if (first == null) {
//                    first = nextNode;
//                    curr = nextNode;
//                } else {
//                    curr.next = nextNode;
//                    curr = curr.next;
//                }
//                l2 = l2.next;
//            } else {
//                ListNode nextNode = new ListNode(l1.val);
//                if (first == null) {
//                    first = nextNode;
//                    curr = nextNode;
//                } else {
//                    curr.next = nextNode;
//                    curr = curr.next;
//                }
//                l1 = l1.next;
//            }
//        }
//
//        while (l1 != null) {
//            ListNode nextNode = new ListNode(l1.val);
//            if (first == null) {
//                first = nextNode;
//                curr = nextNode;
//            } else {
//                curr.next = nextNode;
//                curr = curr.next;
//            }
//            l1 = l1.next;
//        }
//
//        while (l2 != null) {
//            ListNode nextNode = new ListNode(l2.val);
//            if (first == null) {
//                first = nextNode;
//                curr = nextNode;
//            } else {
//                curr.next = nextNode;
//                curr = curr.next;
//            }
//            l2 = l2.next;
//        }
//
//        return first;
//    }

    // round 1
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        /**
//         * recursive iteration
//         *
//         * concept: find the smallest number to be the first node, and then find the second smallest one to be its next node
//         * (A) 1, 2, 3
//         * (B) 2, 4, 5
//         * round 0.
//         * (A) 2, 3
//         * (B) 2, 4, 5
//         * Ans. 1,
//         * round 1.
//         * (A) 2, 3
//         * (B) 4, 5
//         * Ans. 1, 2
//         * round 2.
//         * (A) 3
//         * (B) 4, 5
//         * Ans. 1, 2, 2
//         * round 3.
//         * (A) (null)
//         * (B) 4, 5
//         * Ans. 1, 2, 2, 3
//         * round 4.
//         * (A) (null)
//         * (B) 5
//         * Ans. 1, 2, 2, 4
//         * round 5.
//         * (A) (null)
//         * (B) (null)
//         * Ans. 1, 2, 3, 4, 5
//         * round 6 (FINAL)
//         */
//        if (l1 == null) {
//            return l2;
//        }
//
//        if (l2 == null) {
//            return l1;
//        }
//
//        if (l1.val < l2.val) {
//            l1.next = mergeTwoLists(l1.next, l2);
//            return l1;
//        } else {
//            l2.next = mergeTwoLists(l1, l2.next);
//            return l2;
//        }
//    }

}
