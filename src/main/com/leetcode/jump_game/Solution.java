package com.leetcode.jump_game;

import java.awt.image.ImageProducer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/jump-game/solution/
public class Solution {
    // round 5
    // greedy
    // https://leetcode.com/problems/jump-game/solutions/3435741/simple-clean-java-solution/
    public boolean canJump(int[] nums) {

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        };

//        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return 0;
//            }
//        });
//        queue.poll();
//        queue.isEmpty();
//        queue.offer();
//        queue.add();

//        ArrayDeque<Integer> deque = new ArrayDeque<>();
//        // when used like a queue
//        deque.offer(); // won't
//        deque.add(); // will throw error if type error occurred
//        deque.poll();
//        // when used like a stack
//        deque.pop();
//        deque.push();
//        // shared
//        deque.isEmpty();
//        deque.size();


//        ArrayList<Integer> aaa = new ArrayList<>();
//        aaa.remove();
        if (nums.length == 0) {
            return false;
        }

        if (nums.length == 1) {
            return true;
        }

        int stepsLeft = nums[0];
        int i = 1;
        while (stepsLeft > 0) {
            if (i == nums.length - 1) {
                return true;
            }

            // we try to reach the last position in the array by getting max left steps as many as possible when increment by 1
            stepsLeft = Math.max(stepsLeft - 1, nums[i]);
            i++;
        }
        return false;
    }

    // round 4
    // d.p. bottom-up with memorization
//    public boolean canJump(int[] nums) {
//        if (nums.length == 0) {
//            return false;
//        }
//
//        boolean[] reachable = new boolean[nums.length];
//        reachable[nums.length - 1] = true;
//        for (int i = nums.length - 2; i >= 0; i--) {
//            int maxSteps = nums[i];
//            if (maxSteps == 0) {
//                continue;
//            }
//
//            for (int j = 1; i+j < nums.length && j <= maxSteps; j++) {
//                if (reachable[i+j] == true) {
//                    reachable[i] = true;
//                    break;
//                }
//            }
//        }
//        return reachable[0];
//    }

    // round 3 top-down with memorization 1000ms, 43.7mb
//    public boolean canJump(int[] nums) {
//        Boolean[] cache = new Boolean[nums.length];
//        cache[nums.length - 1] = true;
//        return reachable(nums, cache, 0);
//    }
//
//    private boolean reachable(int[] nums, Boolean[] cache, int index) {
//        if (cache[index] != null) {
//            return cache[index];
//        }
//
//        for (int i = 1; i <= nums[index] && index + i < nums.length; i++) {
//            if (reachable(nums, cache, nums[index + i])) {
//                cache[index + i] = true;
//                return true;
//            }
//        }
//
//        cache[index] = false;
//        return false;
//    }

// !!!! Greedy solution
// round 2
    // from the last index, keep track of the last position of index that can read to the last index
    // return true if equals to 0
//    public boolean canJump(int[] nums) {
//        int lastGood = Integer.MIN_VALUE;
//        for (int i = nums.length - 1; i >= 0; i--) {
//            if (i + nums[i] >= lastGood) {
//                lastGood = i;
//            }
//        }
//
//        return lastGood == 0;
//    }




// round 1
//    public boolean canJump(int[] nums) {
//        int lastPos = nums.length - 1;
//
//        for (int i = nums.length - 1; i >= 0; i--) {
//            if (i + nums[i] > lastPos) {
//                lastPos = i;
//            }
//        }
//
//        return lastPos == 0;
//    }
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
