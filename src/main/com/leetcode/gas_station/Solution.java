package com.leetcode.gas_station;

public class Solution {
    /**
     * The ideas:
     * (1) If the sum of gas and cost is positive, there must be a solution
     * (2) If the sum of gas and cost from i to j is negative, the circuit from i + 1, i + 2, ... to j is negative.
     * Check from j + 1 instead of i + 1...
     *
     * t.c. big o n
     *
     * https://www.itread01.com/content/1546586114.html
     *
     * the best ever explanation
     * https://medium.com/@mingchoi/leetcode-134-gas-station-solution-with-explanation-0ms-100-faster-100-less-4d6db27d1496
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = 0;
        int sumCost = 0;
        int start = 0;
        int tank = 0;
        for (int i = 0; i < gas.length; i++) {
            sumGas += gas[i];
            sumCost += cost[i];

            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        if (sumGas < sumCost) {
            return -1;
        } else {
            return start;
        }
    }
}
