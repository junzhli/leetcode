package com.leetcode.sort_list;

import java.util.Comparator;
import java.util.PriorityQueue;

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

    // round 4 (same as round 1, but beautifier)
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }



        return helper(head);
    }

    private ListNode helper(ListNode head) {
        if (head.next == null) {
            return head;
        }

        ListNode mid = split(head);
        return merge(helper(head), helper(mid));
    }

    private ListNode merge(ListNode l1, ListNode l2) { // iterative version
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head = null;
        ListNode curr = null;
        if (l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        curr = head;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                curr = curr.next;
                l1 = l1.next;
            } else {
                curr.next = l2;
                curr = curr.next;
                l2 = l2.next;
            }
        }

        if (l1 != null) {
            curr.next = l1;
        }
        if (l2 != null) {
            curr.next = l2;
        }
        return head;
    }

    // private ListNode merge (ListNode l1, ListNode l2) { // recursive version
    //     if (l1 == null) {
    //         return l2;
    //     }
    //     if (l2 == null) {
    //         return l1;
    //     }

    //     if (l1.val <= l2.val) {
    //         l1.next = merge(l1.next, l2);
    //         return l1;
    //     } else {
    //         l2.next = merge(l1, l2.next);
    //         return l2;
    //     }
    // }



    private ListNode split(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (slow.next != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode ret = slow.next;
        slow.next = null;

        return ret;
    }

    // round 3 (same as round 2, but beautifier)
//    public ListNode sortList(ListNode head) {
//        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
//            @Override
//            public int compare(ListNode l1, ListNode l2) {
//                return l2.val - l1.val;
//            }
//        });
//
//        ListNode curr = head;
//        while (curr != null) {
//            pq.offer(curr);
//            curr = curr.next;
//        }
//
//        ListNode prev = null;
//        if (pq.isEmpty()) {
//            return null;
//        }
//        curr = pq.poll();
//        while (curr != null) {
//            curr.next = prev;
//            prev = curr;
//            if (pq.isEmpty()) {
//                break;
//            }
//            curr = pq.poll();
//        }
//
//        return curr;
//    }

    // TODO use merge sort (divide and conquer), top-down and then follow-up bottom-up
    // round 2 (25ms)
//    public ListNode sortList(ListNode head) {
//        if (head == null) {
//            return head;
//        }
//
//        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
//            @Override
//            public int compare(ListNode l1, ListNode l2) {
//                return l1.val - l2.val;
//            }
//        });
//
//        ListNode curr = head;
//        while (curr != null) {
//            queue.offer(curr);
//            curr = curr.next;
//        }
//
//        ListNode n = null;
//        while (!queue.isEmpty()) {
//            ListNode tmp = queue.poll();
//            if (n != null) {
//                n.next = tmp;
//                n = n.next;
//            } else {
//                n = tmp;
//                head = n;
//            }
//        }
//        n.next = null;
//
//        return head;
//    }


    // round 1 (5ms)
//    public ListNode sortList(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        // explicitly split dll into two dlls of half size
//        ListNode second = split(head);
//        head = sortList(head);
//        second = sortList(second);
//
//        // merge again (includes sorting)
//        return merge(head, second);
//    }
//
//    private ListNode merge(ListNode first, ListNode second) {
//        if (first == null) {
//            return second;
//        }
//
//        if (second == null) {
//            return first;
//        }
//
//        // pick smaller element to be the first element and concentrate with others (after merged)
//        if (first.val < second.val) {
//            first.next = merge(first.next, second); // **
////            first.next.prev = first;
////            first.prev = null;
//            return first;
//        } else {
//            second.next = merge(first, second.next); // **
////            second.next.prev = second;
////            second.prev = null;
//            return second;
//        }
//    }
//
//    private ListNode split(ListNode head) {
//        ListNode fast = head, slow = head;
//        while (fast.next != null && fast.next.next != null) { // !! no slow.next
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//
//        ListNode ret = slow.next;
//        slow.next = null; //!!!!
//        return ret;
//    }


}
