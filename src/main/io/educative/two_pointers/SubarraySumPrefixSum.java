package io.educative.two_pointers;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Prefix sum algorithm, reduced to time complexity o(n) with hashmap mapping from prefix_sum to index
 * https://www.youtube.com/watch?v=pVS3yhlzrlQ
 *
 * Problem statement
 *
 * Given an array of integers and an integer target, find a subarray that sums to target and returns the start and end indices of the subarray. It’s guaranteed to have a unique solution.
 * Example:
 *
 * Input: [1 -20 -3 30 5 4], 7
 *
 * Output: 1 4
 *
 * Explanation: -20 - 3 + 30 = 7. The indices for subarray [-20,-3,30] is 1 and 4 (right exclusive)
 *
 *
 * e.g.         1, 3, -3, 8, 5, 7
 *              0, 1,  2, 3, 4, 5
 * sum(0, 3)    <---------> (accSum)
 *                    9
 * sum(0, 1)    <--->       (prefix[i])
 *                4
 * sum(2, 3)         <----> (target)
 *                    9 - 4 = 5
 *The time complexity is O(N)O(N) since we traverse the array twice –– once to calculate prefix sum and the other time to find the solution.
 */
public class SubarraySumPrefixSum {
    public static int[] subarraySum(int[] arr, int target) {
        // WRITE YOUR BRILLIANT CODE HERE
        // Use hashmap to get faster from o(n) to o(1)
        HashMap<Integer, Integer> prefixSumMapToIndex = new HashMap<>();
        prefixSumMapToIndex.put(0, 0); // to cover prefix(0)
        int accSum = 0;
        for (int i = 0; i < arr.length; i++) {
            accSum += arr[i];
            int complement = accSum - target;
            if (prefixSumMapToIndex.containsKey(complement)) {
                int from = prefixSumMapToIndex.get(complement);
                int to = i + 1; // i + 1 denotes the range of ans I...J that meets target equality
                return new int[] {from, to};
            }
            prefixSumMapToIndex.put(accSum, i + 1); // i + 1 denotes the range of ans I...J that meets target equality
        }

        int[] res = new int[2];
        return res;
    }

    public static void main(String[] args) {
        String[] inputs = {"1 3 -3 8 5 7","1 1 1","1 -20 -3 30 5 7"};
        String[] inputs1={"5","3","7"};
        for(int i = 0; i < inputs.length; i++) {
            int[] arr = Arrays.stream(inputs[i].split(" ")).mapToInt(Integer::parseInt).toArray();
            int target = Integer.parseInt(inputs1[i]);
            int[] res = subarraySum(arr, target);
            System.out.println("Subarray sum : "+res[0] + " " + res[1]);
        }
    }
}
