package com.leetcode.find_the_celebrity;

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

//public class Solution extends Relation {
//    /**
//     * @param n a party with n people
//     * @return the celebrity's label or -1
//     */
//    public int findCelebrity(int n) {
//        if (n < 2) {
//            return 0;
//        }
//        // Write your code here
//        boolean[] impossible = new boolean[n];
//        for (int i = 1; i < n; i++) {
//            if (!knows(0, i)) {
//                impossible[i] = true;
//            } else {
//                impossible[0] = true;
//            }
//        }
//
//        for (int i = 0; i < n; i++) {
//            if (impossible[i]) {
//                continue;
//            }
//            boolean allUnknown = true;
//            for (int j = 0; j < n; j++) {
//                if (i == j) {
//                    continue;
//                }
//                boolean isKnown = knows(i, j) || !knows(j, i); // !!! if you don't know others, it doesn't mean other knows about you, so you need to have one more check about !knows(j,i)
//                if (isKnown) {
//                    allUnknown = false;
//                    break;
//                }
//            }
//            if (allUnknown) {
//                return i;
//            }
//        }
//
//        return -1;
//    }
//}
