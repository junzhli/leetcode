package io.educative.two_pointers;

import java.util.Arrays;
import java.util.HashMap;

// use prefix sum technique and formula: ri % k = rj % k <-> sub(i+1, j) % k = 0 (sub(i+1, j) = sub(0, j) - sub(0, i)
// it reduces t.c. to o(n)
public class SubarraySumPrefixSumDivisibleByK {
    public static int subarraySumDivisible(int[] nums, int k) {
        // WRITE YOUR BRILLIANT CODE HERE
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1);
        int accSum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            accSum += nums[i];
            int remainder = accSum % k;
            int complement = (k - remainder) % k;
            if (prefixSumMap.containsKey(complement)) {
                count += prefixSumMap.get(complement);
                prefixSumMap.replace(complement, prefixSumMap.get(complement) + 1);
            } else {
                prefixSumMap.put(complement, 1);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String[] inputs = {"3 1 2 5 1"};
        String[] inputs1 = {"3"};
        for(int i = 0; i < inputs.length; i++) {
            int[] nums = Arrays.stream(inputs[i].split(" ")).mapToInt(Integer::parseInt).toArray();
            int k = Integer.parseInt(inputs1[i]);
            System.out.println("Subarray sum divisible :"+subarraySumDivisible(nums, k));
        }
    }
}
