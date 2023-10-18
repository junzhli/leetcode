package io.educative.two_pointers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * We have an array and a sliding window defined by a start index and an end index. The sliding window moves from left to right. There are always k elements in the window. The window moves one position at a time. Find the maximum integer within the window each time it moves.
 *
 * Example
 *
 * Input:
 *
 * arr = [1, 3, 2, 5, 8, 7]
 *
 * Output:
 *
 * [3, 5, 8, 8]
 *
 * Explanation
 * Brute force
 *
 * We can write a nested loop. The outer loop goes through each window and the inner loop finds the max within the window. This is O(N2)O(N2) time complexity.
 *
 * To optimize on brute force, we can reduce either outer loop complexity or inner loop complexity. Since we have to examine each element at least once (there’s no way to find the maximum if we don’t know what the values are), there is not much we can do for the outer loop. Thus we have to work on the inner loop.
 * Preserving inner elements’ maximum
 *
 * Currently, to get the max of the sliding window, we look at each element in the window and compare them. Analogous to the sliding window sum problem (given an array and a window size, return the sum of each window), when a window slides, only two elements change. The left-most gets removed and a new element gets added to the right. Everything in the middle (let’s call them “inner elements”) is unchanged, and the maximum element among these inner elements are unchanged as well. The key to reducing inner loop complexity is to persist the maximum of the inner elements as we slide the window. Ideally, we want to be able to access the maximum element in less than O(N)O(N) time and update it in less than O(N)O(N) time.
 * Balanced binary search tree
 *
 * One way to achieve this goal is to save the window elements in a self-balancing binary search tree. Because it’s self-balancing, the depth of the tree is guaranteed to be O(log(N))O(log(N)) and lookup, getting max, insert and delete are all O(log(N))O(log(N)) operations. Every time we slide the window, we remove the node that’s out of the window and add the one that comes into the window to the tree. Overall, this gives us O(Nlog(k))O(Nlog(k)) since the number of tree nodes is k and we slide a max of N times.
 *
 * This is pretty good already, but can we do better?
 * Larger elements entering window invalidates smaller elements
 *
 * A question we can ask ourselves is “do we need to keep all the window elements in our state?” An important observation is that for two elements arr[left] and arr[right], where left < right, arr[left] leaves the window earlier as we slide. If arr[right] is larger than arr[left], then there is no point keeping arr[left] in our state since arr[right] is always gonna be larger during the time arr[left] is in the window. Therefore, arr[left] can never be the maximum.
 * Monotonic deque
 *
 * Here we introduce an interesting data structure. It’s a deque with an interesting property. The elements in the deque from head to tail are in decreasing order (hence the name monotonic).
 *
 * To achieve this property, we modify the push operation so that
 *
 * when we push an element into the deque, we first pop everything smaller than it out of the deque.
 *
 * This enforces the decreasing order. Let’s see it in action.
 *
 */
public class SlidingWindowsMaximum {
    public static List<Integer> slidingWindowMaximum(int[] nums, int k) {
        // WRITE YOUR BRILLIANT CODE HERE
        PriorityQueue<Integer> queue = new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return nums[o2] - nums[o1];
            }
        });
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i - k + 1 < 0) {
                queue.offer(i);
                continue;
            }

            if (queue.isEmpty()) {
                queue.offer(i);
                continue;
            }

            while (!queue.isEmpty() && queue.peek() < i - k + 1) { // pop up all unneccessary
                queue.poll();
            }

            if (queue.isEmpty()) {
                list.add(nums[i]);
                queue.offer(i);
                continue;
            }

            if (nums[queue.peek()] >= nums[i]) {
                list.add(nums[queue.peek()]);
            } else {
                list.add(nums[i]);
            }
            queue.offer(i);
        }

        return list;
    }
}
