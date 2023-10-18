package com.leetcode.intersections_of_two_linked_lists;

import java.util.HashSet;

// https://leetcode.com/problems/intersection-of-two-linked-lists/description/?envType=featured-list&envId=top-interview-questions
public class Solution {
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
         val = x;
          next = null;
      }
  }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        while (headA != null && headB !=null) {
            if (headA == headB) {
                return headA;
            }

            if (set.contains(headA)) {
                return headA;
            }
            set.add(headA);
            if (set.contains(headB)) {
                return headB;
            }
            set.add(headB);
            headA = headA.next;
            headB = headB.next;
        }

        while (headA != null) {
            if (set.contains(headA)) {
                return headA;
            }
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            set.add(headB);
            headB = headB.next;
        }

        return null;
    }
}
