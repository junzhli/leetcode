package com.leetcode.reverse_linked_list_ii;

import java.util.ArrayDeque;

// https://leetcode.com/problems/reverse-linked-list-ii/description/
// follow-up: do this with one-pass, using stack and queue
public class Solution {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  // round 2, stack and queue approach
  public ListNode reverseBetween(ListNode head, int left, int right) {
      if (left == right) {
          return head;
      }

      ArrayDeque<ListNode> queue = new ArrayDeque<>();
      ArrayDeque<ListNode> stack = new ArrayDeque<>();
      int count = 1;
      while (head != null) {
          if (count < left || count > right) {
              if (count == right + 1) {
                  while (!stack.isEmpty()) {
                      queue.offer(stack.pop());
                  }
              }
              queue.offer(head);
          } else if (count >= left && count <= right) {
              stack.push(head);
          }
          head = head.next;
          count++;
      }

      if (count == right + 1) {
          while (!stack.isEmpty()) {
              queue.offer(stack.pop());
          }
      }

      ListNode _head = null;
      ListNode prev = null;
      while (!queue.isEmpty()) {
          ListNode curr = queue.poll();
          if (_head == null) {
              _head = curr;
          }
          if (prev != null) { //!!!
              prev.next = curr;
          }
          prev = curr;
      }
      if (prev != null) {  //!!!
          prev.next = null; //!!!
      }

      return _head;
  }

  // round 1, intuitive approach
//    public ListNode reverseBetween(ListNode head, int left, int right) {
//        ListNode bak = head;
//        if (left == right) {
//            return bak;
//        } else {
//            ListNode prev = null;
//            ListNode prevHead = null;
//            ListNode nextTail = null;
//            ListNode _head = null;
//            ListNode tail = null;
//            int count = 1;
//            while (count <= right) {
//                if (_head != null && tail != null) {
//                    break;
//                }
//
//                if (count == left) {
//                    _head = head;
//                    prevHead = prev;
//                }
//                if (count == right) {
//                    tail = head;
//                    nextTail = tail.next;
//                }
//                prev = head;
//                head = head.next;
//                count++;
//            }
//            if (_head != null && tail != null) {
//                ListNode res = reverseList(nextTail, _head, tail);
//                if (prevHead != null) {
//                    prevHead.next = res;
//                }
//
//                if (left != 1) { // !!
//                    return bak;
//                } else {
//                    return tail;
//                }
//            }
//        }
//        return null;
//    }
//
//    private ListNode reverseList(ListNode prev, ListNode head, ListNode tail) {
//        ListNode next = prev;
//        while (next != tail) {
//            ListNode nextNext = head;
//            ListNode nextHead = head.next;
//            head.next = next;
//            next = nextNext;
//            head = nextHead;
//        }
//        return tail;
//    }
}
