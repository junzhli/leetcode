package com.leetcode.palindrome_number;

public class Solution {

    // round 2.1
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int y = x;
        int res = 0;
        while(y != 0) {
            res = res * 10 + y % 10;
            y /= 10;
        }
        return x == res;
    }

    // round 2
    //
//    static class Node {
//        int val;
//        Node prev;
//        Node next;
//
//        Node (int val) {
//            this.val = val;
//        }
//    }
//
//    public boolean isPalindrome(int x) {
//        if (x < 0) {
//            return false;
//        }
//
//        if (x == 0) {
//            return true;
//        }
//
//        Node head = null;
//        Node tail = null;
//        while (x != 0) {
//            int r = x % 10;
//            Node node = new Node(r);
//            if (head == null) {
//                head = node;
//                tail = node;
//            } else {
//                node.prev = tail;
//                tail.next = node;
//                tail = node;
//            }
//
//            x /= 10;
//        }
//
//        while (head != tail) {
//            if (head.val != tail.val) {
//                return false;
//            }
//
//            head = head.next;
//            tail = tail.prev;
//        }
//
//        return true;
//
//
//        // String str = String.valueOf(x);
//        // int start = 0;
//        // int end = str.length() - 1;
//        // while (start < end) {
//        //     if (str.charAt(start) != str.charAt(end)) {
//        //         return false;
//        //     }
//        //     start += 1;
//        //     end -= 1;
//        // }
//        // return true;
//    }



//    private String reverseString(String s) {
//
//        int length = s.length();
//        StringBuilder rev = new StringBuilder();
//        for (int x = length - 1; x >= 0; x--) {
//            rev.append(s.charAt(x));
//        }
//
//        return rev.toString();
//    }
//
//    public boolean isPalindrome(int x) {
//        String str = Integer.toString(x);
//        String revStr = reverseString(str);
//        return (str.equals(revStr));
//    }
}
