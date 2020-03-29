package com.leetcode.gas_station;

public class Solution {
    /**
     * The ideas:
     * (1) If the sum of gas and cost is positive, there must be a solution
     * (2) If the sum of gas and cost from i to j is negative, the circuit from i + 1, i + 2, ... to j is negative.
     * Check from j + 1 instead of i + 1...
     *
     * t.c. big o n
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
