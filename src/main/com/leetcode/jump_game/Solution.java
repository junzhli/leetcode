package com.leetcode.jump_game;

import java.awt.image.ImageProducer;

// https://leetcode.com/problems/jump-game/solution/


// !!!! Greedy solution
public class Solution {

    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] > lastPos) {
                lastPos = i;
            }
        }

        return lastPos == 0;
    }
}


// Bottom-up dynamic programming (eliminating recursion but leaving memorization)
//public class Solution {
//    boolean[] cache;
//
//    public boolean canJump(int[] nums) {
//        if (nums.length == 0) {
//            return false;
//        }
//
//        cache = new boolean[nums.length];
//        cache[nums.length - 1] = true;
//
//        for (int i = nums.length - 2; i >= 0; i--) {
//            int maxSteps = Math.min(nums[i] + i, nums.length - 1);
//            for (int j = maxSteps; j > i; j--) {
//                if (cache[j]) {
//                    cache[i] = true;
//                    break;
//                }
//            }
//        }
//        return cache[0];
//    }
//}



// Top-down dynamic programming (backtracking + memorization)
//public class Solution {
//    Boolean[] cache;
//    public boolean canJump(int[] nums) {
//        if (nums.length == 0) {
//            return false;
//        }
//
//        cache = new Boolean[nums.length];
//        cache[nums.length - 1] = true;
//        _canJump(0, nums);
//        return cache[0];
//    }
//
//    private boolean _canJump(int pointer, int[] steps) {
//        if (cache[pointer] != null) {
//            return cache[pointer];
//        }
//
////        int maxSteps = steps[pointer];
//        int maxSteps = Math.min(steps[pointer] + pointer, steps.length - 1);
//
////        if (maxSteps == 0) {
////            boolean target = false;
////            if (steps.length - 1 == pointer) {
////                target = true;
////            }
////            cache[pointer] = target;
////            return target;
////        }
//
//        for (int i = maxSteps; i > pointer; i--) {
////            if (tar > steps.length - 1) {
////                cache[pointer] = true;
////                break;
////            }
//
//
//            // continue to follow the procedure
//            if (_canJump(i, steps)) {
//                cache[pointer] = true;
//                break;
//            };
//
//        }
//
//        if (cache[pointer] == null) {
//            cache[pointer] = false;
//        }
//        return cache[pointer];
//    }
//}
