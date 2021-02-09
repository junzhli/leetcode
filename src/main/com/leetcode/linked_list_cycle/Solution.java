package com.leetcode.linked_list_cycle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution {
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode walker = head;
        ListNode runner = head;
        while (walker.next != null && runner.next != null && runner.next.next != null) { // !!!!!!
            walker = walker.next;
            runner = runner.next.next;
            if (walker == runner) {
                return true;
            }
        }
        return false;
    }

//    public boolean hasCycle(ListNode head) {
//        HashSet<ListNode> map = new HashSet<>(); // not satisfied with the requirement which runs the program with constant space
//        ListNode n = head;
//        while (n != null) {
//            if (map.contains(n)) {
//                return true;
//            }
//
//            map.add(n);
//            n = n.next;
//        }
//        return false;
//    }
}
