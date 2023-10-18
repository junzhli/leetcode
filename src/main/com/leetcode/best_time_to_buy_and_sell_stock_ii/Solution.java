package com.leetcode.best_time_to_buy_and_sell_stock_ii;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/solutions/803206/python-js-java-go-c-o-n-by-dp-greedy-visualization/?envType=featured-list&envId=top-interview-questions
// t.c. o(n)
// s.c. o(1)
public class Solution {
    public int maxProfit(int[] prices) {
        int hold = Integer.MIN_VALUE;
        int nothold = 0;

        for (int price: prices) {
            int prevHold = hold;
            int prevNotHold = nothold;

            hold = Math.max(prevHold, prevNotHold - price);
            nothold = Math.max(prevNotHold, prevHold + price);
        }

        return nothold;

    }
}
