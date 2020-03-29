package com.leetcode.best_time_to_buy_and_sell_stock;

public class Solution {
    /**
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
     */

    public int maxProfit(int[] prices) {
        /**
         * Concept: Find min value at i and max value at j and j > i
         * 7 1 5 3 6 4
         *
         * t: n
         * s: n
         */

        // if number of prices is less than 2, return 0
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }

        int res = 0;
        int min = prices[0];
        int max = prices[0];

        for (int i = 0; i < prices.length; i++) {
            /**
             * find value which is greater than min as max, and then return max - min
             */
            if (prices[i] > max) {
                max = prices[i];
            } else if (prices[i] < min) {
                /**
                 * if we find the value is lower than min. min and max both needs to be cleared and reset
                 * because max at j and min at i must fit the need which is j > i
                 * to keep last best result, check the current value (max - min) is greater than the previous result
                 *
                 * *   * * * *
                 *   *
                 *
                 *
                 * *   * * * *
                 *
                 *
                 */
                res = Math.max(res, max - min);

                min = prices[i];
                max = prices[i];
            }
        }

        return Math.max(max - min, res);
    }
}
